package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.Entities.Cotacao;
import com.example.demo.dto.CotacaoDTO;






@Mapper(componentModel = "spring")
public interface CotacaoMapper {
    @Mapping(target="valorTotal", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "destino", ignore = true)
    @Mapping(source = "dataCotacao", target = "dataCotacao")
    public Cotacao toEntity(CotacaoDTO dto);
     
    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "destino.id", target = "destinoId")
        public CotacaoDTO toDTO(Cotacao cotacao);

     
     List<CotacaoDTO> toDTOList(List<Cotacao> cotacoes);


} 


