/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;


import br.pi.boalista.Modelo.dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Marca;
import java.util.List;

public class RepositorioMarca implements RepositorioGenerico<Marca, Long> {

    @Override
    public List recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from marca");
    }

    @Override
    public void inserir(Marca t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Marca t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Marca recuperar(Long id) {
        return (Marca)DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void excluir(Marca t) {
       DaoManagerHiber.getInstance().delete(t);
    }
    
}
