package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CotacaoDTO;

import com.example.demo.service.CotacaoService;
import com.example.demo.service.Utils.ApiResponse;
import com.example.demo.service.Utils.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Tag(name = "Cotação", description = "Endpoints para gerenciamento de catação")
@RestController
@RequestMapping("api/cotacao")
public class CotacaoController {
    
    @Autowired
    private CotacaoService cotacaoServise;

    @GetMapping
    public List<CotacaoDTO> ListarCotacao() {
        return cotacaoServise.listarTodos();
    }
    @Operation(summary = "Lista todos os usuários", description = "Retorna uma lista com todos as cotações")
    @GetMapping("/{id}")
    public ResponseEntity<CotacaoDTO> buscarPorId(@PathVariable Long id) {
        Optional<CotacaoDTO> cotacaoDTO = cotacaoServise.buscarPorId(id);
        return cotacaoDTO.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cria uma nova cotação", description = "Cadastra uma nova cotação no sistema")
    @PostMapping
    public ResponseEntity<ApiResponse<CotacaoDTO>> criarCotacao(@Valid @RequestBody CotacaoDTO cotacaoDTO) {
        try {
            CotacaoDTO savedCotacao = cotacaoServise.salvar(cotacaoDTO);

            ApiResponse<CotacaoDTO> response = new ApiResponse<>(savedCotacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse("Argumento inválido", e.getMessage());
            ApiResponse<CotacaoDTO> response = new ApiResponse<>(errorResponse);
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Erro interno", e.getMessage());
            ApiResponse<CotacaoDTO> response = new ApiResponse<>(errorResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @Operation(summary = "Deleta uma cotação", description = "Remove uma cotação do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCotacao(@PathVariable Long id) {
        cotacaoServise.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
