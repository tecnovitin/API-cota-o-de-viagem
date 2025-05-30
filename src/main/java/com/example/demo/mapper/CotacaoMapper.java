package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entities.Cotacao;
import com.example.demo.dto.CotacaoDTO;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.IDestinoRepository;






@Mapper(componentModel = "spring")
public interface CotacaoMapper {


    public Cotacao toEntity(CotacaoDTO dto);
        @Mappings({
            @Mapping(source = "cliente.id", target = "clienteId"),
            @Mapping(source = "destino.id", target = "destinoId")
        })
        public CotacaoDTO toDTO(Cotacao cot);

     
     List<CotacaoDTO> toDTOList(List<Cotacao> cotacoes);


} 


