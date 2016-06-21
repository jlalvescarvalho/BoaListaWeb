/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marcia
 */
@Entity(name ="venda")
@Table
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(name="data_venda")
    private String dataVenda;
    private double valorTotal;
    private String mesa;
    private String horavenda;
    
    @OneToMany(cascade = CascadeType.ALL)
    
    private List<ItemDeVenda> itens; 
    
    @Deprecated
    public Venda() {
        
        this.itens = new ArrayList<>();
    }

    public Venda(int id, String dataVenda, List<ItemDeVenda> itens, double valorTotal, String mesa, String horavenda) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.mesa = mesa;
        this.horavenda = horavenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getHoravenda() {
        return horavenda;
    }

    public void setHoravenda(String horavenda) {
        this.horavenda = horavenda;
    }

  
    
    
    
    public void addItemVenda(ItemDeVenda itemDeVenda){
        this.itens.add(itemDeVenda);
    }
    
    
    
}
