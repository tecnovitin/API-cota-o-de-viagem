package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Cotacao;

public interface ICotacaoRepository extends JpaRepository<Cotacao, Long> {
    Optional<Cotacao> findByStatus(String status);

    Optional<Cotacao> findByClienteId(Long idCliente);

    Optional<Cotacao> findByDestinoId(Long idDestino);

    Optional<Cotacao> findByDataCotacao(LocalDateTime data);

    Optional<Cotacao> findByNumeroDePessoas(Integer quantidade);
    
} 
