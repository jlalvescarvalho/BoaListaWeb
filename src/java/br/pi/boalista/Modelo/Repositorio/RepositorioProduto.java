package br.pi.boalista.Modelo.Repositorio;


import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Produto;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProduto implements RepositorioGenerico<Produto, Long>{

    List<Produto> listaProdutos = new ArrayList();
    
    @Override
    public void inserir(Produto produto) {
        DaoManagerHiber.getInstance().persist(produto);
    }
    

    @Override
    public void alterar(Produto t) {
      DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Produto recuperar(Long id) {
        return (Produto) DaoManagerHiber.getInstance().recover(id);
    }

    @Override
    public void excluir(Produto t) {
        
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from produto");
    }

   
    
    
  
    
    
    
    
}
