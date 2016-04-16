
package br.pi.boalista.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="tipoproduto")
public class TipoProduto implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    @Column
    private double valor;
    
    @OneToMany
    private List<Produto> produtos;
    

    public TipoProduto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
        
    }

  

    public TipoProduto() {
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
   
}
