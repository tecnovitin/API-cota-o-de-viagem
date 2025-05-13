package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Destino;
import com.example.demo.dto.destinoDTO;

@Mapper(componentModel = "spring")
public interface DestinoMapper {

    Destino toEntity(DestinoDTO dto);
    Des

}
