package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    Pagamento toEntity(PagamentoDTO dto);

    PagamentoDTO toDTO(Pagamento entity);

    List<PagamentoDTO> toDTOList(List<Pagamento> entities);
}