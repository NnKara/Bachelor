package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.User;
import com.kara.studentscareer.bachelorpapel.Repository.UserRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.UserCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserCrudService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {
        Optional<User> isThereUser=findUserById(id);
        if(isThereUser.isEmpty()){
            throw new EntityNotFoundException("There is no User with ID: "+id);
        }
        User existingUser=isThereUser.get();
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEducations(updatedUser.getEducations());
        existingUser.setEmails(updatedUser.getEmails());
        existingUser.setExperiences(updatedUser.getExperiences());
        existingUser.setPhones(updatedUser.getPhones());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
