/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Mercado;
import br.pi.boalista.Modelo.Repositorio.RepositorioMercado;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kleriston
 */

@ManagedBean(name="MercadoBean")
@SessionScoped
public class ControladorMercadoBean implements InterfaceController{
    
    private RepositorioMercado repMercado = null;
    private Mercado mercado;
    
    public ControladorMercadoBean(){
        mercado = new Mercado();
        repMercado = new RepositorioMercado();
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
    

    
    
    @Override
    public void inserir() {
        repMercado.inserir(mercado);
    }

    @Override
    public void alterar() {
        repMercado.alterar(mercado);
   
    }

    @Override
    public List<Mercado> recuperarTodos() {
        return repMercado.recuperarTodos();
    }

    @Override
    public void excluir() {
        repMercado.excluir(mercado);
    }

    @Override
    public Mercado recuperar(Long id) {
       return repMercado.recuperar(id);
    }
    
    
    
}
