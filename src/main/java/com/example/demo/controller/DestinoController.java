package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DestinoDTO;
import com.example.demo.service.DestinoService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public List<DestinoDTO> listar(){
        return  destinoService.listar();
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<DestinoDTO> buscar(@PathVariable Long id)
    {
        return destinoService.buscarPorID(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity
        .notFound()
        .build());

    }
    
    @PostMapping
    public ResponseEntity<DestinoDTO> criarDestino(@Valid @RequestBody DestinoDTO dto){
        DestinoDTO novoDestinoDTO = destinoService.salvar(dto);
        return ResponseEntity
        .status(201)
        .body(novoDestinoDTO);

    }
    @PutMapping("/{id}")
    public  ResponseEntity<DestinoDTO> atualizarDestino(@PathVariable Long id,@Valid @RequestBody DestinoDTO dto){
        DestinoDTO destinoAtualizado = destinoService.atualizar(id, dto);
        return ResponseEntity.ok(destinoAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDestino(@PathVariable Long id){
        destinoService.deletarDestino(id);
        return ResponseEntity.noContent().build();
    }

}
    


