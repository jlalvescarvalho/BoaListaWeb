package br.pi.boalista.Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;




@Entity(name="produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 20, unique = true)
    private long codigo;
    @Column
    private String nome;
   
    @ManyToOne
    private TipoProduto tipoProduto;
    @ManyToOne
    private Marca marca;
 
    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        
       
    }
    @Deprecated
     public Produto() {
    }
 

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

   
    
  
    
}
