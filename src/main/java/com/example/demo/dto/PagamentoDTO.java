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

    

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    public BigDecimal valorPago;

    @NotBlank(message = "O status é obrigatório")
    public String status;

    @NotNull(message = "A data do pagamento é obrigatória")
    public LocalDateTime dataPagamento;

    @NotNull(message = "O id da cotação é obrigatório")
    public Long cotacaoId;
}