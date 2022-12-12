package com.kara.studentscareer.bachelorpapel.converter;

import com.kara.studentscareer.bachelorpapel.dto.ExperienceDto;
import com.kara.studentscareer.bachelorpapel.entity.Experience;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExperienceConverter {

    public ExperienceDto entityToDto(Experience experience){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(experience, ExperienceDto.class);
    }

    public Experience dtoToEntity(ExperienceDto experienceDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(experienceDto, Experience.class);
    }

    public List<ExperienceDto> listEntityToDto(List<Experience> experiences){
        return experiences.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Experience> listDtoToEntity(List<ExperienceDto> experienceDtos){
        return experienceDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
