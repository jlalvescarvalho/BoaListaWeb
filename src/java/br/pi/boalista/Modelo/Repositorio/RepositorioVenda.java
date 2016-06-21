/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Modelo.Repositorio;



import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Venda;
import java.util.List;

/**
 *
 * @author Kleriston
 */
public class RepositorioVenda {
    
    public void inserir(Venda venda){
        DaoManagerHiber.getInstance().persist(venda);
    }
    
    public List<Venda> recuperaTodos(){
        return DaoManagerHiber.getInstance().recover("from venda");
    }
    
    public void excluir(Venda venda){
        DaoManagerHiber.getInstance().delete(venda);
    }
}
