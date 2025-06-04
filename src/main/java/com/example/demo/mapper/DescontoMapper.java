package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.Entities.Desconto;
import com.example.demo.dto.DescontoDTO;

@Mapper(componentModel = "spring")
public interface DescontoMapper {

    @Mapping(source = "cotacao.id", target = "cotacaoId")
    DescontoDTO toDTO(Desconto desconto);

    @Mapping(source = "cotacaoId", target = "cotacao.id")
    Desconto toEntity(DescontoDTO dto);

    List<DescontoDTO> toDTOList(List<Desconto> descontos);
}
