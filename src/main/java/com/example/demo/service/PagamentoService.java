package com.example.demo.service;

import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.repository.IPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @Autowired
    private IPagamentoRepository pagamentoRepository;

    public List<PagamentoDTO> listar() {
        return pagamentoMapper.toDTOList(pagamentoRepository.findAll());
    }

    public Optional<PagamentoDTO> buscarPorId(Long id) {
        return pagamentoRepository.findById(id).map(pagamentoMapper::toDTO);
    }

    public PagamentoDTO salvar(PagamentoDTO dto) {
        Pagamento pagamento = pagamentoMapper.toEntity(dto);
        return pagamentoMapper.toDTO(pagamentoRepository.save(pagamento));
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public PagamentoDTO atualizar(Long id, PagamentoDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(id).map(existing -> {
            existing.setValor(dto.valor);
            existing.setMetodoPagamento(dto.metodoPagamento);
            existing.setDataPagamento(dto.dataPagamento);
            existing.setReservaId(dto.reservaId);
            return pagamentoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o id: " + id));
        return pagamentoMapper.toDTO(pagamento);
    }
}