package com.dcat23.loanmgmt.application.mapper;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationResponse;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoanApplicationMapper {

    LoanApplicationMapper INSTANCE = Mappers.getMapper(LoanApplicationMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "loanProduct", ignore = true)
    @Mapping(target = "applicationDate", ignore = true)
    LoanApplication toEntity(LoanApplicationCreationDTO loanApplicationCreationDTO);

    @Mapping(target = "loanProductName", source = "loanProduct.name")
    LoanApplicationResponse toResponse(LoanApplication loanApplication);

    @Mapping(target = "loanProductName", source = "loanProduct.name")
    List<LoanApplicationResponse> toResponse(List<LoanApplication> applications);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "loanProduct", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "applicationDate", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(LoanApplicationUpdateDTO loanApplicationUpdateDTO, @MappingTarget LoanApplication loanApplication);
}
