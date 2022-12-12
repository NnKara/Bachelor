package com.kara.studentscareer.bachelorpapel.converter;

import com.kara.studentscareer.bachelorpapel.dto.EducationDto;
import com.kara.studentscareer.bachelorpapel.entity.Education;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EducationConverter {

    public EducationDto entityToDto(Education education){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(education, EducationDto.class);
    }

    public Education dtoToEntity(EducationDto educationDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(educationDto, Education.class);
    }

    public List<EducationDto> entityToDto(List<Education> educations){
        return educations.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Education> dtoToEntity(List<EducationDto> educationsDto){
        return educationsDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
