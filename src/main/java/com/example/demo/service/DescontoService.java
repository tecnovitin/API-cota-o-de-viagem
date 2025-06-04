package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Desconto;
import com.example.demo.dto.DescontoDTO;
import com.example.demo.mapper.DescontoMapper;
import com.example.demo.repository.IDescontoRepository;

@Service
public class DescontoService {

    @Autowired
    private IDescontoRepository descontoRepository;

    @Autowired
    private DescontoMapper descontoMapper;

    // registra desconto
    public DescontoDTO registrarDesconto(DescontoDTO dto) {
        Desconto desconto = descontoMapper.toEntity(dto);
        desconto = descontoRepository.save(desconto);
        return descontoMapper.toDTO(desconto);
    }

    // Lista tods descontos
    public List<DescontoDTO> listarDescontos() {
        List<Desconto> descontos = descontoRepository.findAll();
        return descontos.stream()
                .map(descontoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // busca desconto por ID
    public DescontoDTO buscarPorId(Long id) {
        Optional<Desconto> desconto = descontoRepository.findById(id);
        return desconto.map(descontoMapper::toDTO).orElse(null);
    }

    public List<DescontoDTO> listarPorCotacao(Long cotacaoId) {
        List<Desconto> descontos = descontoRepository.findAllByCotacaoId(cotacaoId);
        return descontos.stream()
                .map(descontoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // atualiza desconto
    public DescontoDTO atualizar(Long id, DescontoDTO dto) {
        Optional<Desconto> descontoOpt = descontoRepository.findById(id);
        if (descontoOpt.isPresent()) {
            Desconto desconto = descontoOpt.get();
            desconto.setValorDesconto(dto.getValorDesconto());
            desconto.setDescricao(dto.getDescricao());
            desconto = descontoRepository.save(desconto);
            return descontoMapper.toDTO(desconto);
        }
        return null;
    }

    // deleta desconto
    public void deletar(Long id) {
        descontoRepository.deleteById(id);
    }
}
