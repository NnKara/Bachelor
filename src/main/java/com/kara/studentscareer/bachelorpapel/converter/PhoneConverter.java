package com.kara.studentscareer.bachelorpapel.converter;

import com.kara.studentscareer.bachelorpapel.dto.PhoneDto;
import com.kara.studentscareer.bachelorpapel.entity.Phone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhoneConverter {

    public PhoneDto entityToDto(Phone phone){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(phone, PhoneDto.class);
    }

    public Phone dtoToEntity(PhoneDto phoneDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(phoneDto, Phone.class);
    }

    public List<PhoneDto> listEntityToDto(List<Phone> phones){
        return phones.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Phone> listDtoToEntity(List<PhoneDto> phoneDto){
        return phoneDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
