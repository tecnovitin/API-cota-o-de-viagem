package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Destino;
import com.example.demo.dto.CotacaoDTO;
import com.example.demo.mapper.CotacaoMapper;
import com.example.demo.Entities.Cotacao;
import com.example.demo.repository.IDestinoRepository;
import com.example.demo.repository.ICotacaoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.Entities.Cliente;

import com.example.demo.repository.IClienteRepository;

@Service
public class CotacaoService {
    
    @Autowired
    private ICotacaoRepository cotacaoRepository;

    @Autowired
    private CotacaoMapper cotacaoMapper;
    
    @Autowired
    private IDestinoRepository destinoRepository;
    
 @Autowired
    private IClienteRepository clienteRepository;


    public List<CotacaoDTO> listarTodos() {
        return cotacaoMapper.toDTOList(cotacaoRepository.findAll());
    }

     public Optional<CotacaoDTO> buscarPorId(Long id) {
        return cotacaoRepository.findById(id).map(cotacaoMapper::toDTO);
    }

    public CotacaoDTO salvar(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoMapper.toEntity(cotacaoDTO);
        Destino destino = destinoRepository.findById(cotacaoDTO.getDestinoId())
       .orElseThrow(() -> new RuntimeException("Destino não encontrado com o ID: " + cotacaoDTO.getDestinoId()));
        cotacao.setDestino(destino);
         Cliente cliente = clienteRepository.findById(cotacaoDTO.getClienteId())
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + cotacaoDTO.getClienteId()));
        cotacao.setCliente(cliente);
        cotacao.setDataCotacao(LocalDateTime.now());
        calcularValorTotal(cotacao);
       
        return cotacaoMapper.toDTO(cotacaoRepository.save(cotacao));
    }

    public void deletar(Long id){
        cotacaoRepository.deleteById(id);
    }
    private void calcularValorTotal (Cotacao cotacao){
    int numeroDePessoas = cotacao.getNumeroDePessoas();
    BigDecimal precoPorPessoa = cotacao.getDestino().getPrecoPorPessoa();

    BigDecimal valorTotal = precoPorPessoa.multiply(BigDecimal.valueOf(numeroDePessoas));
    cotacao.setValorTotal(valorTotal);
        } 
    
        
    }