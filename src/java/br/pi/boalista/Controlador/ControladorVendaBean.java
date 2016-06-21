/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;


import br.pi.boalista.Modelo.ItemDeVenda;
import br.pi.boalista.Modelo.Produto;
import br.pi.boalista.Modelo.Repositorio.RepositorioVenda;
import br.pi.boalista.Modelo.TipoProduto;
import br.pi.boalista.Modelo.Venda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kleriston
 */
@ManagedBean(name="vendaBean")
@ViewScoped
public class ControladorVendaBean {
    
    
    private RepositorioVenda repVenda=null;
        
    private List<ItemDeVenda> listaItens=null;
    
    private Venda vendaCadastro=null;
    
    private TipoProduto tipo;
    
   

    public ControladorVendaBean() {
        repVenda = new RepositorioVenda();
        vendaCadastro = new Venda();
        tipo = new TipoProduto();
      
        if(listaItens == null){
            this.listaItens = new ArrayList<>();
        }
        
        
    }

    public Venda getVendaCadastro() {
        return vendaCadastro;
    }

    public void setVendaCadastro(Venda vendaCadastro) {
        this.vendaCadastro = vendaCadastro;
    }
    
    public List<ItemDeVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemDeVenda> listaItens) {
        this.listaItens = listaItens;
    }
    
 
   
   public void adicionar(Produto produto){
      
       int posicaoEncontrada=-1;
       
       for(int i=0;i<listaItens.size() && posicaoEncontrada <0;i++){
           ItemDeVenda temp = listaItens.get(i);
          
          if(temp.getProduto().getId() == produto.getId()){
              posicaoEncontrada = i;
          }
       }
       
       ItemDeVenda item = new ItemDeVenda();
       item.setProduto(produto);
       
       if(posicaoEncontrada<0){
        item.setQuantidade(1);
        item.setPrecoVenda(tipo.getValor() );
        listaItens.add(item);
       
       }else{
           ItemDeVenda temp = listaItens.get(posicaoEncontrada);
           item.setQuantidade(temp.getQuantidade()+1);
           item.setPrecoVenda(tipo.getValor() * item.getQuantidade());
           
           listaItens.set(posicaoEncontrada, item);
       }
       vendaCadastro.setValorTotal(  vendaCadastro.getValorTotal());
   }
    
   public void remover(ItemDeVenda item){
              
       int posicaoEncontrada=-1;
       
       for(int i=0;i<listaItens.size() && posicaoEncontrada <0;i++){
           ItemDeVenda temp = listaItens.get(i);
          
          if(temp.getProduto().getId() == item.getProduto().getId()){
              posicaoEncontrada = i;
          }
       }
       if(posicaoEncontrada >-1){
           listaItens.remove(posicaoEncontrada);
           
           vendaCadastro.setValorTotal(vendaCadastro.getValorTotal() - item.getPrecoVenda());
       }
   }
   
   public void carregarDadosVenda(){
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       Date data = new Date();
       vendaCadastro.setDataVenda(sdf.format(data));
       
       SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss");
       Date hora = new Date();
       vendaCadastro.setHoravenda(d.format(hora));
       
   }
   
   public String inserir(){
       vendaCadastro.setItens(listaItens);
       repVenda.inserir(vendaCadastro);
       vendaCadastro = new Venda();
       listaItens = new ArrayList<>();
       
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns! " 
             +" Venda Efetuada Com Sucesso!"));
      
      return "VendaCadastro.xhtml";
   }
   

 
   
   public List<ItemDeVenda> vendasSelecionadas(){
       return this.vendaCadastro.getItens();
   }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
   
   
}
