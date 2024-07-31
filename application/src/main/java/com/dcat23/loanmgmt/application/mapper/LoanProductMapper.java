package com.dcat23.loanmgmt.application.mapper;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductResponse;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoanProductMapper {

    LoanProductMapper INSTANCE = Mappers.getMapper(LoanProductMapper.class);

    LoanProduct toEntity(LoanProductCreationDTO loanProductDTO);

    void update(LoanProductUpdateDTO loanProductDTO, @MappingTarget LoanProduct loanProduct);

    LoanProductResponse toResponse(LoanProduct saved);

    List<LoanProductResponse> toResponseList(List<LoanProduct> products);
}
