/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Repositorio.RepositorioUsuario;
import br.pi.boalista.Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luciano
 */

@ManagedBean(name="UsuarioBean")
public class ControladorUsuarioBean {
    
    private RepositorioUsuario repUsuario = null;
    private Usuario usuario;
    
    
    public ControladorUsuarioBean(){
        usuario = new Usuario();
        repUsuario = new RepositorioUsuario();
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario() {
        this.usuario = usuario;
    }
       
    public void inserir(){
        repUsuario.inserir(usuario);
    }
    public void alterar(){
        repUsuario.alterar(usuario);
    }
    public List<Usuario> recuperarTodos() {
        return repUsuario.recuperarTodos();
    }
    public void excluir() {
      repUsuario.excluir(usuario);
    }
    public Usuario recuperar(Long id) {
        return repUsuario.recuperar(id);
    }
}
