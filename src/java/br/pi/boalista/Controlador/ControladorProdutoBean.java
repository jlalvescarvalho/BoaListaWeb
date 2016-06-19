package br.pi.boalista.Controlador;


import br.pi.boalista.Modelo.Marca;
import br.pi.boalista.Modelo.Produto;
import br.pi.boalista.Modelo.Repositorio.RepositorioMarca;
import br.pi.boalista.Modelo.Repositorio.RepositorioProduto;
import br.pi.boalista.Modelo.Repositorio.RepositorioTipoProduto;
import br.pi.boalista.Modelo.TipoProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ProdutoBean")
@SessionScoped
public class ControladorProdutoBean implements InterfaceController{
    
    private RepositorioProduto repProduto = null;
    private RepositorioMarca repMarca = null;
    private RepositorioTipoProduto repTipo = null;
    private Produto produto;
    private Marca marca;
    private TipoProduto tipo;
    
    


    public ControladorProdutoBean(){
        produto = new Produto();
        repProduto = new RepositorioProduto();
        repMarca = new RepositorioMarca();
        repTipo = new RepositorioTipoProduto();
        tipo = new TipoProduto();
        marca = new Marca();
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
    
    
    @Override
    public void inserir() {
        marca = repMarca.recuperar(marca.getId());
        tipo = repTipo.recuperar(tipo.getId());
        produto.setMarca(marca);
        produto.setTipoProduto(tipo);
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
