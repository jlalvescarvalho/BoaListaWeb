package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Marca;
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
@SessionScoped
public class ControladorProdutoBean implements InterfaceController{
    
    private RepositorioProduto repProduto = null;
    private Produto produto;
    private Produto produtoSeleted;
    



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

    public RepositorioProduto getRepProduto() {
        return repProduto;
    }

    public void setRepProduto(RepositorioProduto repProduto) {
        this.repProduto = repProduto;
    }

    public Produto getProdutoSeleted() {
        return produtoSeleted;
    }

    public void setProdutoSeleted(Produto produtoSeleted) {
        this.produtoSeleted = produtoSeleted;
    }

    public List<Marca> reculperarmarcas(){
        return DaoManagerHiber.getInstance().recoverAll("from marca");
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
    public Produto recuperar(Long id) {
        return repProduto.recuperar(id);
    }
}
