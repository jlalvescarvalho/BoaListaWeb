/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Repositorio.RepositorioTipoProduto;
import br.pi.boalista.Modelo.TipoProduto;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luciano
 */
@ManagedBean(name="TipoProdutoBean")
public class ControllerTipoProdutoBean implements InterfaceController{

    private TipoProduto tipoProduto;
    private RepositorioTipoProduto repTipoProduto=null;
    
    public ControllerTipoProdutoBean(){
        tipoProduto = new TipoProduto();
        repTipoProduto = new RepositorioTipoProduto();
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    
    @Override
    public void inserir() {
        repTipoProduto.inserir(tipoProduto);
    }

    @Override
    public void alterar() {
        repTipoProduto.alterar(tipoProduto);
    }

    @Override
    public List<Object> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
       repTipoProduto.excluir(tipoProduto);
    }

    @Override
    public TipoProduto recuperar(Long id) {
        return repTipoProduto.recuperar(id);
    }
    
}
