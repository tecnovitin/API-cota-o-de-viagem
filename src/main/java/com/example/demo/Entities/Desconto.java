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
import lombok.NoArgsConstructor; //acho que é isso
import lombok.Setter;

@Data
@Entity
@Table (name = "desconto")
@Getter @Setter
@NoArgsConstructor 
@AllArgsConstructor

public class Desconto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cotacaoid", nullable = false)
    private Cotacao cotacao;

    @Column(nullable = false)
    private BigDecimal valorDesconto;

    @Column(nullable = false)
    private LocalDateTime dataAplicacao;

    @Column(nullable = false)
    private String descricao;
}
