package com.example.demo.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DestinoDTO {

    @NotBlank(message="O nome do destino é obrigatorio.")
    private String nome;

    @NotBlank(message = "A descrição é obrigatoria")
    private  String descricao;

    @NotBlank(message = "A localização é obrigatoria")
    private  String localizacao;
    
    @NotNull(message = "O preco é obrigatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precoPorPessoa;


}
