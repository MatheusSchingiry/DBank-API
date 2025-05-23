package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toModel(ClientDTO dto);
    ClientDTO toDTO(Client model);
}
