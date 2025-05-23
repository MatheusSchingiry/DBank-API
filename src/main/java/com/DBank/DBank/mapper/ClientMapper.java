package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.model.ClientModel;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientModel toModel(ClientDTO dto);
    ClientDTO toDTO(ClientModel model);
}
