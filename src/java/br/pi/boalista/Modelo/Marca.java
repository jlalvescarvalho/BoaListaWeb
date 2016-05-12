package br.pi.boalista.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="marca")
public class Marca implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="nome", nullable = false)
    private String nome;
        
    public Marca(String nome) {
        this.nome = nome;
        
    }

    
    public Marca() {
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
