package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Cotacao;
import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.repository.ICotacaoRepository;
import com.example.demo.repository.IPagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @Autowired
    private IPagamentoRepository pagamentoRepository;

    @Autowired
    private ICotacaoRepository cotacaoRepository;

    public List<PagamentoDTO> listar() {
        return pagamentoMapper.toDTOList(pagamentoRepository.findAll());
    }

    public Optional<PagamentoDTO> buscarPorId(Long id) {
        return pagamentoRepository.findById(id).map(pagamentoMapper::toDTO);
    }

    public PagamentoDTO salvar(PagamentoDTO dto) {
        Pagamento pagamento = pagamentoMapper.toEntity(dto);
        // Busca e seta a cotação correta
        Cotacao cotacao = cotacaoRepository.findById(dto.getCotacaoId())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o id: " + dto.getCotacaoId()));
        pagamento.setCotacao(cotacao);
        return pagamentoMapper.toDTO(pagamentoRepository.save(pagamento));
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public PagamentoDTO atualizar(Long id, PagamentoDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(id).map(existing -> {
            existing.setValorPago(dto.getValorPago());
            existing.setStatus(dto.getStatus());
            existing.setDataPagamento(dto.getDataPagamento());
            Cotacao cotacao = cotacaoRepository.findById(dto.getCotacaoId())
                    .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o id: " + dto.getCotacaoId()));
            existing.setCotacao(cotacao);
            return pagamentoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o id: " + id));
        return pagamentoMapper.toDTO(pagamento);
    }
}