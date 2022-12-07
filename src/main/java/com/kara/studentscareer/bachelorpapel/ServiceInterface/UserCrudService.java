package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserCrudService {

    User createUser(User user);

    List<User>findAllUsers();

    Optional<User>findUserById(Integer id);

    User updateUser(Integer id,User user);

    void deleteUserById(Integer id);


}
