/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;

import java.util.List;

public interface RepositorioGenerico<T, t> {
   
    public void inserir(T t);
    public void alterar(T t);
    public T recuperar(t chave);
    public void excluir(T t);
    public List<T>recuperarTodos();
    
}
