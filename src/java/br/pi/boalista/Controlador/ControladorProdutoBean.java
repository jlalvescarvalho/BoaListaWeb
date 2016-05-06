package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Produto;
import br.pi.boalista.Modelo.Repositorio.RepositorioProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

@ManagedBean(name="ProdutoBean")
public class ControladorProdutoBean implements InterfaceController{
    
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

    @Override
    public void inserir() {
        repProduto.inserir(produto);
    }

    @Override
    public void alterar() {
        repProduto.alterar(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return repProduto.recuperarTodos();
    }

    @Override
    public void excluir() {
       repProduto.excluir(produto);
    }

    @Override
    public Object recuperar(Long id) {
        return repProduto.recuperar(id);
    }
}
