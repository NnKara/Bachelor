package com.kara.studentscareer.bachelorpapel.converter;

import com.kara.studentscareer.bachelorpapel.entity.Email;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EmailConverter {

    public EmailConverter entityToDto(Email email){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(email, EmailConverter.class);
    }

    public Email dtoToEntity(EmailConverter emailDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(emailDto, Email.class);
    }

    public List<EmailConverter> listEntityToDto(List<Email> emails){
        return emails.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Email> listDtoToEntity(List<EmailConverter> emailDto){
        return emailDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
