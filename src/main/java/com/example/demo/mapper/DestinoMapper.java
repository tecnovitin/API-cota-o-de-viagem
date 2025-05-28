package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Destino;
import com.example.demo.dto.DestinoDTO;

// Faz a ligação da DTO de destino e a destino 
@Mapper(componentModel = "spring")
public interface DestinoMapper {

   public Destino toEntity(DestinoDTO dto);

   public DestinoDTO toDTO(Destino des);

   public List<DestinoDTO> toDTOList(List<Destino> destinos);
}