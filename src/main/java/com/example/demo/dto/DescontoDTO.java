package com.example.demo.dto;


import java.time.LocalDateTime;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DescontoDTO {

    

    @NotNull(message = "O id da cotação e obrigatorio.")
    public Long cotacaoId;

 
    @NotNull(message = "A data do desconto é obrigatória")
    private LocalDateTime dataDesconto;

    @NotBlank(message = "A descrição e obrigatoria.")
    public String descricao;
}
