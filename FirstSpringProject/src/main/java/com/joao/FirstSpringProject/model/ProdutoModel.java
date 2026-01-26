package com.joao.FirstSpringProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {
//Produto conterá: ID, Nome, Preço, disponivel

//Variáveis
    private int id;
    private String nome;
    private double preco;
    private boolean disponivel;


//    public ProdutoModel(int id, String nome, double preco, boolean disponivel  ){
//        this.id = id;
//        this.nome = nome;
//        this.preco = preco;
//        this.disponivel = disponivel;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public String getNome() {
//        return nome;
//    }
//    public double getPreco() {
//        return preco;
//    }
//    public boolean getDisponivel() {
//        return disponivel;
//    }

}
