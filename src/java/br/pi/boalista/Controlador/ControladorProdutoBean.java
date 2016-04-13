package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Produto;
import br.pi.boalista.Modelo.Repositorio.RepositorioProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

@ManagedBean(name="ControlaProdutoBean")
public class ControladorProdutoBean{
    
    private RepositorioProduto repProduto = null;
    private Produto produto;
    



    public ControladorProdutoBean(){
        produto = new Produto();
        repProduto = new RepositorioProduto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   
    public void inserir(){
        repProduto.inserir(produto);
        
    }
    public void alterar(Produto produto){
        repProduto.alterar(produto);
    }
    public List<Produto> recuperarTodos() {
        return repProduto.recuperarTodos();
    }
    public void excluir(Produto produto) {
      repProduto.excluir(produto);
    }
    public Produto recuperar(Long id) {
        return repProduto.recuperar(id);
    }
}
