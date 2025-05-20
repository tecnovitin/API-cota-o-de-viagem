package com.example.demo.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table (name = "Cotacao")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Long IdCliente;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Long IdDestino;

    @Column(nullable = false)
    private LocalDateTime dataCotacao;

    @Column(nullable = false)
    private Integer numeroDePessoas;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private String status;
    
}
