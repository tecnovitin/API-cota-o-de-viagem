package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@NoArgsConstructor
public class CotacaoDTO {

    @NotBlank(message = "A data da cotação é obrigatória")
    @Future(message = "A data da cotação deve ser no futuro")
    private LocalDateTime dataCotacao;

    @NotBlank(message = "A quantidade de pessoas é obrigatório")
    @Min(value = 1, message = "O número de pessoas deve ser maior que zero")
    private Integer numeroDePessoas;

    @NotBlank(message = "O valor da Viagem é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor total deve ser maior que zero")
    private BigDecimal valorTotal;

    @NotBlank(message = "O status é obrigatório")
    @Pattern(regexp = "Pendente|Aprovada|Rejeitada", message = "Status inválido. Valores permitidos: Pendente, Aprovada ou Rejeitada")
    private String status;
    
}
