package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Cliente;
import com.example.demo.dto.ClienteDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    
    public Cliente toEntity(ClienteDTO dto);

    public ClienteDTO toDTO(Cliente cot);

    List<ClienteDTO> toDTOList(List<Cliente> clientes);
}
