package com.joao.FirstSpringProject.service;

import com.joao.FirstSpringProject.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<ProdutoModel> produtos = new ArrayList<>();

    private int proximoId = 1;

//  CRUD

//  CREATE

public ProdutoModel criarProduto(ProdutoModel produto){
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    };

//Get produto
public List<ProdutoModel> listarProdutos(){
    return produtos;
};

//Get produto por Id
public ProdutoModel listarPorId(int id) {
    return produtos.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);
};

//Update - atualizar produto
    public ProdutoModel atualizarProduto(int id, ProdutoModel produtoAtualizado) {
        ProdutoModel produtoExistente = listarPorId(id);

        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setDisponivel(produtoAtualizado.isDisponivel());
            return produtoExistente;
        }

        return null;
    }

// DELETE - remover produto
    public boolean removerProduto(int id) {
        ProdutoModel produto = listarPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

}
