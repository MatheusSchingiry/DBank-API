package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.model.EnterpriseModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EnterpriseMapper {

    EnterpriseModel toModel(EnterpriseDTO dto);
    EnterpriseDTO toDTO(EnterpriseModel model);
}
