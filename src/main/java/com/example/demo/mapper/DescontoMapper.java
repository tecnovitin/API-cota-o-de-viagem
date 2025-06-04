package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Desconto;
import com.example.demo.dto.DescontoDTO;

@Mapper(componentModel = "spring")
public interface DescontoMapper {

    public Desconto toEntity(DescontoDTO dto);
 
    public DescontoDTO toDto(Desconto desconto);
 
    List<DescontoDTO> toDtoList(List<Desconto> descontos);

}
