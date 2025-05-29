package com.example.demo.dto;


import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DestinoDTO {

    @NotBlank(message="O nome do destino é obrigatorio.")
    public  String nome;

    @NotBlank(message = "A descrição é obrigatoria")
    public  String descricao;

    @NotBlank(message = "A localização é obrigatoria")
    public  String localizacao;
    
    @NotNull(message = "O preco é obrigatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    public BigDecimal precoPorPessoa;

   

}
