package com.kara.studentscareer.bachelorpapel.converter;

import com.kara.studentscareer.bachelorpapel.dto.AddressDto;
import com.kara.studentscareer.bachelorpapel.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {


    public AddressDto entityToDto(Address address){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(address, AddressDto.class);
    }

    public List<AddressDto> entityToDto(List<Address> addresses){
        return addresses.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    public Address dtoToEntity(AddressDto addressDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(addressDto,Address.class);
    }

    public List<Address> dtoToEntity(List<AddressDto> addressDto){
        return addressDto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
