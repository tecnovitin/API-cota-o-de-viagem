package com.example.demo.controller;

import com.example.demo.dto.DescontoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/descontos")
public class DescontoController {

    private List<DescontoDTO> descontos = new ArrayList<>();

    @GetMapping
    public List<DescontoDTO> listarTodos() {
        return descontos;
    }

    @PostMapping
    public DescontoDTO criar(@RequestBody DescontoDTO dto) {
        descontos.add(dto);
        return dto;
    }

    @GetMapping("/{id}")
    public DescontoDTO buscarPorId(@PathVariable Long id) {
        return descontos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
