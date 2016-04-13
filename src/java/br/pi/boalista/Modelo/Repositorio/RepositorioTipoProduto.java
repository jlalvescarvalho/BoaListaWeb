/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;


import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.TipoProduto;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class RepositorioTipoProduto implements RepositorioGenerico<TipoProduto, Long>{

    @Override
    public void inserir(TipoProduto t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(TipoProduto t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public TipoProduto recuperar(Long id) {
        return (TipoProduto)DaoManagerHiber.getInstance().recover(TipoProduto.class, id);
    }

    @Override
    public void excluir(TipoProduto t) {
       DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<TipoProduto> recuperarTodos() {
        return DaoManagerHiber.getInstance().recoverAll("from tipoproduto");
    }
    
}
