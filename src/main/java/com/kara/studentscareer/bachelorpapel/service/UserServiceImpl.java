package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.enums.converter.UserConverter;
import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;


    @Override
    public User save(UserDto userDto) {
       User newUser=userConverter.dtoToEntity(userDto);
        return userRepository.save(newUser);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.entityToDto(users);
    }

    @Override
    public UserDto findByUsername(String username) {
        User isThereUser = userRepository.findByUsername(username);
        if (isThereUser==null) {
            throw new EntityNotFoundException("There is no User with this Username: " +username );
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
    public UserDto updateUser(User updatedUser) {
        User userFromDB = userRepository.findByUsername(updatedUser.getUsername());
        if (userFromDB == null) {
            throw new EntityNotFoundException("There is no User with this Username: " + updatedUser.getUsername());
        }
        if (updatedUser.getFirstname() != null) {
            userFromDB.setFirstname(updatedUser.getFirstname());
        }
        if (updatedUser.getLastname() != null) {
            userFromDB.setLastname(updatedUser.getLastname());
        }
        if (updatedUser.getUsername() != null) {
            userFromDB.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getAddresses() != null) {
            userFromDB.setAddresses(updatedUser.getAddresses().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updatedUser.getEducations() != null) {
            userFromDB.setEducations(updatedUser.getEducations().stream().map(ed -> {
                ed.setUser(userFromDB);
                return ed;
            }).collect(Collectors.toList()));
        }
        if (updatedUser.getEmails() != null) {
            userFromDB.setEmails(updatedUser.getEmails().stream().map(e -> {
                e.setUser(userFromDB);
                return e;
            }).collect(Collectors.toList()));
        }
        if (updatedUser.getEducations() != null) {
            userFromDB.setEducations(updatedUser.getEducations().stream().map(ex -> {
                ex.setUser(userFromDB);
                return ex;
            }).collect(Collectors.toList()));
        }
        if (updatedUser.getPhones() != null) {
            userFromDB.setPhones(updatedUser.getPhones().stream().map(p -> {
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



