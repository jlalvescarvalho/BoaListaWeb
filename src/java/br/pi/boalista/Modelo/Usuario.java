
package br.pi.boalista.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="usuario")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String nome;
    
    private String sobrenome;
    private String email;
    private String login;
    private String senha;

   

    public Usuario(String nome, String sobrenome, String email, String login, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

     public Usuario() {
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
      public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
