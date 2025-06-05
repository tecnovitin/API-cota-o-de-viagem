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

    

    @NotNull(message = "O id da cotação e obrigatorio.")
    public Long cotacaoId;

    @NotNull(message = "O valor do desconto e obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do desconto deve ser maior que zero.")
    public BigDecimal valorDesconto;

    @NotBlank(message = "A descrição e obrigatoria.")
    public String descricao;
}
