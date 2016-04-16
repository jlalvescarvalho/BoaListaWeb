package br.pi.boalista.Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity(name="produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private int codigo;
    @Column
    private String nome;
   
    @OneToOne
    private TipoProduto tipoProduto;
    @OneToOne
    private Marca marca;
 
    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        
       
    }
     public Produto() {
    }
 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

   
    
  
    
}
