package com.example.demo.controller;

import com.example.demo.dto.DescontoDTO;
import com.example.demo.service.DescontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descontos")
public class DescontoController {

    @Autowired
    private DescontoService descontoService;

    // 1 - Registrar Desconto
    @PostMapping
    public DescontoDTO registrarDesconto(@RequestBody DescontoDTO dto) {
        return descontoService.registrarDesconto(dto);
    }

    // 2 - Listar Descontos
    @GetMapping
    public List<DescontoDTO> listarDescontos() {
        return descontoService.listarDescontos();
    }

    // 3 - Detalhar Desconto
    @GetMapping("/{id}")
    public DescontoDTO buscarPorId(@PathVariable Long id) {
        return descontoService.buscarPorId(id);
    }

    // 4 - Listar Descontos de uma Cotação
    @GetMapping("/cotacao/{cotacaoId}")
    public List<DescontoDTO> listarPorCotacao(@PathVariable Long cotacaoId) {
        return descontoService.listarPorCotacao(cotacaoId);
    }

    // 5 - Atualizar Desconto
    @PutMapping("/{id}")
    public DescontoDTO atualizar(@PathVariable Long id, @RequestBody DescontoDTO dto) {
        return descontoService.atualizar(id, dto);
    }

    // 6 - Remover Desconto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        descontoService.deletar(id);
    }
}