package com.kara.studentscareer.bachelorpapel.Controller;


import com.kara.studentscareer.bachelorpapel.Dto.UserDto;
import com.kara.studentscareer.bachelorpapel.Entity.User;
import com.kara.studentscareer.bachelorpapel.ServiceImpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private ModelMapper modelMapper;

    public UserController(UserController userController){
        super();
        this.userService=userService;
    }


    @GetMapping
    public List<UserDto> getUsers(){
        return userService.findAllUsers().stream().map(user->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id")Integer id){
        Optional<User> user=userService.findUserById(id);
        UserDto userResponse=modelMapper.map(user,UserDto.class);
        return ResponseEntity.ok().body(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        //dto to entity
        User userRequest=modelMapper.map(userDto,User.class);
        User user=userService.createUser(userRequest);

        //entity to dto
        UserDto userResponse=modelMapper.map(user, UserDto.class);
        return  new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);

    }




}
