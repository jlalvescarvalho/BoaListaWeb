/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Mercado;
import java.util.List;

/**
 *
 * @author Kleriston
 */
public class RepositorioMercado implements RepositorioGenerico<Mercado, Long>{

    @Override
    public void inserir(Mercado t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Mercado t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Mercado recuperar(Long id) {
        return (Mercado) DaoManagerHiber.getInstance().recover(Mercado.class, id);
    }

    @Override
    public void excluir(Mercado t) {
        DaoManagerHiber.getInstance().delete(t);
                
    }

    @Override
    public List<Mercado> recuperarTodos() {
        return DaoManagerHiber.getInstance().recoverAll("from mercado");
    }
    
}
