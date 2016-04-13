/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;


import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Usuario;
import java.util.List;

public class RepositorioUsuario implements RepositorioGenerico<Usuario, Long> {

    @Override
    public void inserir(Usuario t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Usuario t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Usuario recuperar(Long id) {
        return (Usuario) DaoManagerHiber.getInstance().recover(Usuario.class, id);
    }

    @Override
    public void excluir(Usuario t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Usuario> recuperarTodos() {
        return DaoManagerHiber.getInstance().recoverAll("from usuario");
    }

    
    
    
    
    
    
}
