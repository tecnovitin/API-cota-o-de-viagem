package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.Entities.Cotacao;
import com.example.demo.dto.CotacaoDTO;






@Mapper(componentModel = "spring")
public interface CotacaoMapper {




    
    public Cotacao toEntity(CotacaoDTO dto);

    public CotacaoDTO toDTO(Cotacao cot);

  
     List<CotacaoDTO> toDTOList(List<Cotacao> cotacoes);


} 


