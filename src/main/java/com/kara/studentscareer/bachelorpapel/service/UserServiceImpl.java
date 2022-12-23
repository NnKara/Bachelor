package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.converter.UserConverter;
import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.Role;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User save(UserDto userDto) {
        User newUser = userConverter.dtoToEntity(userDto);
        if(newUser.equals(userRepository.findByUsername(userDto.getUsername()))){
            throw new EntityExistsException("This user already exists!");
        }
        newUser.setRoles(Arrays.asList(new Role("ROLE_USER")));
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDB = userRepository.findByUsername(username);
        if (userFromDB == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(userFromDB.getUsername(), userFromDB.getPassword(), mapRolesToAuthorities(userFromDB.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {  //convert role SimpleGrantAuthority kai kanw pass to rolename se auto
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.entityToDto(users);
    }

    @Override
    public UserDto findByUsername(String username) {
        User isThereUser = userRepository.findByUsername(username);
        if (isThereUser == null) {
            throw new EntityNotFoundException("There is no User with this Username: " + username);
        }
        return userConverter.entityToDto(isThereUser);
    }

    public UserDto findUserById(Integer id) {
        Optional<User> isThereUser = userRepository.findById(id);
        if (isThereUser.isEmpty()) {
            throw new EntityNotFoundException("There is no User with this ID: " + id);
        }
        User existingUser = isThereUser.get();
        return userConverter.entityToDto(existingUser);
    }

    @Override
    public User updateUser(UserDto updatedUserDto) {
        User userFromDB = userRepository.findByUsername(updatedUserDto.getUsername());
        if (userFromDB == null) {
            throw new EntityNotFoundException("There is no User with this Username: " + updatedUserDto.getUsername());
        }
        if (updatedUserDto.getFirstname() != null) {
            userFromDB.setFirstname(updatedUserDto.getFirstname());
        }else {
            userFromDB.setFirstname(userFromDB.getFirstname());
        }
        if (updatedUserDto.getLastname() != null) {
            userFromDB.setLastname(updatedUserDto.getLastname());
        }else{
            userFromDB.setLastname(userFromDB.getLastname());
        }
        if (updatedUserDto.getUsername() != null) {
            userFromDB.setUsername(updatedUserDto.getUsername());
        }else{
            userFromDB.setUsername(userFromDB.getUsername());
        }
        if (updatedUserDto.getAddresses() != null) {
            userFromDB.setAddresses(updatedUserDto.getAddresses().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updatedUserDto.getEducations() != null) {
            userFromDB.setEducations(updatedUserDto.getEducations().stream().map(ed -> {
                ed.setUser(userFromDB);
                return ed;
            }).collect(Collectors.toList()));
        }
        if (updatedUserDto.getEmails() != null) {
            userFromDB.setEmails(updatedUserDto.getEmails().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updatedUserDto.getEducations() != null) {
            userFromDB.setEducations(updatedUserDto.getEducations().stream().map(ex -> {
                ex.setUser(userFromDB);
                return ex;
            }).collect(Collectors.toList()));
        }
        if (updatedUserDto.getPhones() != null) {
            userFromDB.setPhones(updatedUserDto.getPhones().stream().map(p -> {
                p.setUser(userFromDB);
                return p;
            }).collect(Collectors.toList()));
        }
        userRepository.save(userFromDB);
        return userConverter.dtoToEntity(updatedUserDto);

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



