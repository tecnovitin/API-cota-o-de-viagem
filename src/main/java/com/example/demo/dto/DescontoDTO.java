package com.example.demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DescontoDTO {

    private Long id;

    @NotNull(message = "O id da cotação e obrigatorio.")
    private Long cotacaoId;

    @NotNull(message = "O valor do desconto e obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do desconto deve ser maior que zero.")
    private BigDecimal valorDesconto;

    @NotBlank(message = "A descrição e obrigatoria.")
    private String descricao;
}
