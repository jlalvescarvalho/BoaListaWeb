/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Kleriston
 */
@Entity(name="mercado")
public class Mercado implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private String nome_fantasia;
    private long cpf_cnpj;
    private String razao;
    private String telefone;

    @Deprecated
    public Mercado() {
    }

    public Mercado(long id, String nome_fantasia, long cpf_cnpj, String razao, String telefone) {
        this.id = id;
        this.nome_fantasia = nome_fantasia;
        this.cpf_cnpj = cpf_cnpj;
        this.razao = razao;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
}
