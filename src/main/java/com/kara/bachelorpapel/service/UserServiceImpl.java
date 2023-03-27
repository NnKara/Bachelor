package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.converter.UserConverter;
import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.entity.Role;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.RoleRepository;
import com.kara.bachelorpapel.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void save(UserDto userDto)  {
        User userFromDb=userRepository.findByUsername(userDto.getUsername());
        if(userFromDb!=null){
            throw new EntityExistsException("This user already exists!");
        }
        User newUser=userConverter.dtoToEntity(userDto);
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = checkRoleExist();
        if (role == null) {
            role = new Role();
            role.setName("ROLE_USER");
            role = roleRepository.save(role);
        }
        newUser.setRoles(List.of(role));
        userRepository.save(newUser);
        }

    private Role checkRoleExist(){
        Role role=new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.entityToDto(users);
    }


    @Override
    public UserDto findByUsername(String username) {
        User isThereUser = userRepository.findByUsername(username);
        if(findAllUsers().isEmpty()){
            throw new EntityNotFoundException("There is no user with this username");
        }
        return userConverter.entityToDto(isThereUser);
    }


    @Override
    public UserDto updateUser(User updateUser) {
        User userFromDB = userRepository.findByUsername(updateUser.getUsername());
        if (userFromDB == null) {
            throw new EntityNotFoundException("There is no User with this Username: " + updateUser.getUsername());
        }
        if (updateUser.getFirstname() != null) {
            userFromDB.setFirstname(updateUser.getFirstname());
        }
        if (updateUser.getLastname() != null) {
            userFromDB.setLastname(updateUser.getLastname());
        }
        if (updateUser.getUsername() != null) {
            userFromDB.setUsername(updateUser.getUsername());
        }
        if (updateUser.getAddresses() != null) {
            userFromDB.setAddresses(updateUser.getAddresses().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updateUser.getEducations() != null) {
            userFromDB.setEducations(updateUser.getEducations().stream().map(ed -> {
                ed.setUser(userFromDB);
                return ed;
            }).collect(Collectors.toList()));
        }
        if (updateUser.getEmails() != null) {
            userFromDB.setEmails(updateUser.getEmails().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updateUser.getEducations() != null) {
            userFromDB.setEducations(updateUser.getEducations().stream().map(ex -> {
                ex.setUser(userFromDB);
                return ex;
            }).collect(Collectors.toList()));
        }
        if (updateUser.getPhones() != null) {
            userFromDB.setPhones(updateUser.getPhones().stream().map(p -> {
                p.setUser(userFromDB);
                return p;
            }).collect(Collectors.toList()));
        }
        userRepository.save(userFromDB);
        return userConverter.entityToDto(userFromDB);

    }

    @Override
    public void deleteUserById(Integer id) {
        boolean existingUser = userRepository.existsById(id);
        if (!existingUser) {
            throw new EntityNotFoundException("There is no User with this ID: " + id);
        }
        userRepository.deleteById(id);
    }
}



