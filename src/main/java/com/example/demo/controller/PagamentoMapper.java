package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PagamentoDTO;
import com.example.demo.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<PagamentoDTO> listar() {
        return pagamentoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<PagamentoDTO> buscarPorId(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id);
    }

    @PostMapping
    public PagamentoDTO salvar(@RequestBody PagamentoDTO dto) {
        return pagamentoService.salvar(dto);
    }

    @PutMapping("/{id}")
    public PagamentoDTO atualizar(@PathVariable Long id, @RequestBody PagamentoDTO dto) {
        return pagamentoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pagamentoService.deletar(id);
    }
}