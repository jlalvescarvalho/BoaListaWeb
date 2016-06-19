/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Repositorio.RepositorioTipoProduto;
import br.pi.boalista.Modelo.TipoProduto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Luciano
 */
@ManagedBean(name="TipoProdutoBean")
@RequestScoped
public class ControllerTipoProdutoBean implements InterfaceController{

    private TipoProduto tipoProduto;
    private RepositorioTipoProduto repTipoProduto=null;
    private List<SelectItem> tipoSelected;

    
    
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
    
    public List<SelectItem> getTipoSelected() {
        tipoSelected = new ArrayList<SelectItem>();
        
        List<TipoProduto> listaTipo = DaoManagerHiber.getInstance().recover("from tipoproduto");
        if(!listaTipo.isEmpty()){
            SelectItem item;
            
            for (int i = 0; i < listaTipo.size(); i++) {
                item = new SelectItem(listaTipo.get(i).getNome());
                tipoSelected.add(item);
            }
        }
        return tipoSelected;
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
    public List<TipoProduto> recuperarTodos() {
        return repTipoProduto.recuperarTodos();
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
