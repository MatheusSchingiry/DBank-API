package com.DBank.DBank.Mapper;

import com.DBank.DBank.DTO.EnterpriseDTO;
import com.DBank.DBank.Model.EnterpriseModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EnterpriseMapper {

    EnterpriseModel toModel(EnterpriseDTO dto);
    EnterpriseDTO toDTO(EnterpriseModel model);
}
