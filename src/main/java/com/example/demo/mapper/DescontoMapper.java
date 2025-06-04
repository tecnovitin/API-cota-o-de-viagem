package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.model.Desconto;
import com.example.demo.dto.DescontoDTO;

@Mapper(componentModel = "spring")
public interface DescontoMapper {

    Desconto toEntity(DescontoDTO dto);

    DescontoDTO toDTO(Desconto desconto);

    List<DescontoDTO> toDTOList(List<Desconto> descontos);
}
