package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ClienteDTO {

    @NotBlank(message="O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    private  String email;

    @NotBlank(message = "O número de telefone é obrigatório")
    private  String telefone;
}
