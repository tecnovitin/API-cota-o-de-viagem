package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagamentoDTO {

    public Long id;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    public BigDecimal valor;

    @NotBlank(message = "O método de pagamento é obrigatório")
    public String metodoPagamento;

    @NotNull(message = "A data do pagamento é obrigatória")
    public LocalDateTime dataPagamento;

    @NotNull(message = "O id da reserva é obrigatório")
    public Long reservaId;
}