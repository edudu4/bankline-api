package com.dio.santander.banklineapi.controller;

import com.dio.santander.banklineapi.dto.NovaMovimentacao;
import com.dio.santander.banklineapi.model.Movimentacao;
import com.dio.santander.banklineapi.repository.MovimentacaoRepository;
import com.dio.santander.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta) {
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);
    }
}
