package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CotacaoDTO;
import com.example.demo.mapper.CotacaoMapper;
import com.example.demo.Entities.Cotacao;

import com.example.demo.repository.ICotacaoRepository;

@Service
public class CotacaoService {
    
    @Autowired
    private ICotacaoRepository cotacaoRepository;

    @Autowired
    private CotacaoMapper cotacaoMapper;

    public List<CotacaoDTO> listarTodos() {
        return cotacaoMapper.toDTOList(cotacaoRepository.findAll());
    }

     public Optional<CotacaoDTO> buscarPorId(Long id) {
        return cotacaoRepository.findById(id).map(cotacaoMapper::toDTO);
    }

    public CotacaoDTO salvar(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoMapper.toEntity(cotacaoDTO);
        return cotacaoMapper.toDTO(cotacaoRepository.save(cotacao));
    }

    public void deletar(Long id){
        cotacaoRepository.deleteById(id);
    }
}