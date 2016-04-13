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

/**
 *
 * @author Luciano
 */
public class ControladorUsuario {
    
    private RepositorioUsuario repUsuario = null;
    List<Usuario> ListaProdutos = new ArrayList<Usuario>();
    
    public void inserir(Usuario usuario){
        repUsuario.inserir(usuario);
    }
    public void alterar(Usuario usuario){
        repUsuario.alterar(usuario);
    }
    public List<Usuario> recuperarTodos() {
        return repUsuario.recuperarTodos();
    }
    public void excluir(Usuario usuario) {
      repUsuario.excluir(usuario);
    }
    public Usuario recuperar(Long id) {
        return repUsuario.recuperar(id);
    }
}
