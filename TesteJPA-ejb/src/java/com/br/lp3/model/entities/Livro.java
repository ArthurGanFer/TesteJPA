/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author cacique
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_livro;
    @Size(max = 100)
    private String nome;
    @Size(max = 100)
    private String autor;

    @ManyToOne
    private UserLP3 userLP3;

    public Livro() {
    }

    public long getId_livro() {
        return id_livro;
    }

    public void setId_livro(long id_livro) {
        this.id_livro = id_livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" + "id_livro=" + id_livro + ", nome=" + nome + ", autor=" + autor + '}';
    }

}
