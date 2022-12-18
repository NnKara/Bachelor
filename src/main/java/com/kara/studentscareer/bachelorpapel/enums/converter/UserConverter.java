package com.kara.studentscareer.bachelorpapel.enums.converter;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDto entityToDto(User user){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(user, UserDto.class);
    }

    public List<UserDto> entityToDto(List<User> user){
        return user.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    public User dtoToEntity(UserDto dto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto,User.class);
    }

    public List<User> dtoToEntity(List<UserDto> dtoList){
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


}
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserDto entityToDto(User user){
//        UserDto dto=new UserDto();
//        dto.setUserName(user.getUsername());
//        dto.setFName(user.getFirstName());
//        dto.setLName(user.getLastname());
//        dto.setEducations(user.getEducations());
//        dto.setExperiences(user.getExperiences());
//        dto.setPhones(user.getPhones());
//        dto.setEmails(user.getEmails());
//        return dto;
//    }
//
//   public User dtoToEntity(UserDto userDto){
//        User user=userRepository.findByEmail(userDto.getEmail());
//        user.setFirstName(userDto.getFName());
//        user.setLastname(userDto.getLName());
//        user.setUsername(userDto.getUserName());
//
//        return user;
//   }
//
//}
