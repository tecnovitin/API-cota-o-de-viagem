package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ClienteDTO {

    @NotBlank(message="O nome é obrigatório.")
    public String nome;

    @NotBlank(message = "O email é obrigatório.")
    public  String email;

    @NotBlank(message = "O número de telefone é obrigatório")
    public  String telefone;
}
