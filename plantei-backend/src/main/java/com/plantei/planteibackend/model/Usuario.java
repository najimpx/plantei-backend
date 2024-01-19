package com.plantei.planteibackend.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = true)
    private String endereco;
    @Column(nullable = false)
    private boolean notificacoes;
    @Column(nullable = true)
    private String area;
    @Column(nullable = true)
    private String iluminacao;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean getNotificacoes() {
        return notificacoes;
    }

    public String getArea() {
        return area;
    }

    public String getIluminacao() {
        return iluminacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(String regiao) {
        this.endereco = regiao;
    }

    public void setNotificacoes(boolean notificacoes) {
        this.notificacoes = notificacoes;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }
}
