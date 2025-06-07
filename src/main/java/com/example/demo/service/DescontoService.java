package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Cotacao;
import com.example.demo.Entities.Desconto;
import com.example.demo.dto.DescontoDTO;
import com.example.demo.mapper.DescontoMapper;
import com.example.demo.repository.ICotacaoRepository;
import com.example.demo.repository.IDescontoRepository;

@Service
public class DescontoService {

    @Autowired
    private IDescontoRepository descontoRepository;

    @Autowired
    private DescontoMapper descontoMapper;
   
    @Autowired
        private ICotacaoRepository cotacaoRepository;
    
    // registra desconto
    public DescontoDTO registrarDesconto(DescontoDTO dto) {
        Desconto desconto = descontoMapper.toEntity(dto);
        Cotacao cotacao = cotacaoRepository.findById(dto.getCotacaoId())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + dto.getCotacaoId()));        
        desconto.setCotacao(cotacao);
     
        BigDecimal valorCalculadoDoDesconto = calcularDesconto(cotacao, cotacao.getValorTotal());
        desconto.setValorDesconto(valorCalculadoDoDesconto);
                desconto = descontoRepository.save(desconto);
                desconto.setDataDesconto(LocalDateTime.now()); 
                desconto.setValorDesconto(calcularDesconto(desconto.getCotacao(), desconto.getCotacao().getValorTotal()));
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

    
 public DescontoDTO atualizar(Long id, DescontoDTO dto) {
        Optional<Desconto> descontoOpt = descontoRepository.findById(id);
        if (descontoOpt.isPresent()) {
            Desconto desconto = descontoOpt.get();

            
            desconto.setDescricao(dto.getDescricao());

            desconto = descontoRepository.save(desconto);
            return descontoMapper.toDTO(desconto);
        }
       
        throw new RuntimeException("Desconto não encontrado com o id: " + id);
    }

    // deleta desconto
    public void deletar(Long id) {
        descontoRepository.deleteById(id);
    }

    private BigDecimal calcularDesconto (Cotacao cotacao, BigDecimal valorTotal) {
            BigDecimal descontoTotal = BigDecimal.ZERO;
            String destino = cotacao.getDestino().getNome();
           if (destino.equalsIgnoreCase("Fernando de Noronha") ||
                destino.equalsIgnoreCase("Rio de Janeiro") ||
                destino.equalsIgnoreCase("Maceió") ||
                destino.equalsIgnoreCase("Maceio")) {

                    descontoTotal = descontoTotal.add(valorTotal.multiply(new BigDecimal("0.10"))); 

                }

                int mes = cotacao.getDataCotacao().getMonthValue();
                  if(mes >= 4 && mes <= 6){
                        descontoTotal = descontoTotal.add(valorTotal.multiply(new BigDecimal("0.15")));
                    }
            return descontoTotal;
        };


}
