package com.joao.FirstSpringProject.controller;

import com.joao.FirstSpringProject.model.ProdutoModel;
import com.joao.FirstSpringProject.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

//CREATE — Criar produto (POST)
    @PostMapping
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto){
        return produtoService.criarProduto(produto);
    }

//READ — Listar todos os produtos (GET)
    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }

//READ — Buscar produto por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> listarPorId(@PathVariable int id){

        ProdutoModel produto = produtoService.listarPorId(id);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

//UPDATE — Atualizar produto (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(
            @PathVariable int id,
            @RequestBody ProdutoModel produtoAtualizado) {

        ProdutoModel produtoExistente = produtoService.atualizarProduto(id, produtoAtualizado);

        if (produtoExistente == null) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(produtoExistente);
    }

//DELETE — Remover produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable int id) {

        boolean removido = produtoService.removerProduto(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}


