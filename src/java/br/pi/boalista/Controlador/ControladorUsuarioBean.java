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
public class ControladorUsuarioBean implements InterfaceController{
    
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

    @Override
    public void inserir() {
        repUsuario.inserir(usuario);
    }

    @Override
    public void alterar() {
        repUsuario.alterar(usuario);
    }

    @Override
    public List<Object> recuperarTodos() {
        return null;
    }

    @Override
    public void excluir() {
        repUsuario.excluir(usuario);
    }

    @Override
    public Usuario recuperar(Long id) {
         return repUsuario.recuperar(id);
                 
    }
}    
    