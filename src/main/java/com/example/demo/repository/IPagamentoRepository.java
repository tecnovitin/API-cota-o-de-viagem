package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Pagamento;

@Repository
public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {

    Optional<Pagamento> findByRegistroPagamento(BigDecimal registro_pagamento);

    Optional<Pagamento> findByStatus(String status);
}
