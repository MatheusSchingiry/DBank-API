package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.model.ClientModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientModel toModel(ClientDTO dto);
    ClientDTO toDTO(ClientModel model);
}
