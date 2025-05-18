package com.example.demo.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table (name = "pagamentos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Pagamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="valor_pago", nullable = false)
    private BigDecimal valorPago;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;

    @ManyToOne
    @JoinColumn(name = "cotacao_id", nullable = false)
    private Cotacao cotacao;
    
}
