package com.kara.studentscareer.bachelorpapel.converter;


import com.kara.studentscareer.bachelorpapel.dto.StudentInfoDto;
import com.kara.studentscareer.bachelorpapel.entity.StudentInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentInfoConverter {

    public StudentInfoDto entityToDto(StudentInfo studentInfo){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(studentInfo, StudentInfoDto.class);
    }

    public StudentInfo dtoToEntity(StudentInfoDto studentInfoDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(studentInfoDto, StudentInfo.class);
    }

    public List<StudentInfoDto> listEntityToDto(List<StudentInfo> studentInfo){
        return studentInfo.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<StudentInfo> listDtoToEntity(List<StudentInfoDto> studentInfoDto){
        return studentInfoDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
