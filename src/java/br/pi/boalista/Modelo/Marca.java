package br.pi.boalista.Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="marca")
public class Marca implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private String marca;
    

    public Marca(String marca) {
        this.marca = marca;
        
    }

    
    public Marca() {
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    
}
