package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DescontoDTO {

    private Long id;

    @NotBlank(message = "O nome do desconto é obrigatório.")
    private String nome;

    @NotNull(message = "O percentual é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O percentual deve ser maior que zero.")
    private Double percentual;

    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private Double valor;
}
