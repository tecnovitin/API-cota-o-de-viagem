package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {


    @Mapping(target = "cotacao", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dataPagamento", target = "dataPagamento")
    Pagamento toEntity(PagamentoDTO dto);
    
    @Mapping(source = "cotacao.id", target = "cotacaoId")
    PagamentoDTO toDTO(Pagamento entity);

    List<PagamentoDTO> toDTOList(List<Pagamento> entities);
}