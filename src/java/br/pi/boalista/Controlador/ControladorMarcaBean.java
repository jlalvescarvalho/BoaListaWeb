/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Marca;
import br.pi.boalista.Modelo.Repositorio.RepositorioMarca;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Kleriston
 */


@ManagedBean(name = "MarcaBean")

public class ControladorMarcaBean implements InterfaceController {
    
    
    private RepositorioMarca repMarca = null;
    private Marca marca;
    
    public ControladorMarcaBean(){
        marca = new Marca();
        repMarca = new RepositorioMarca();
        
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public void inserir() {
        repMarca.inserir(marca);
    }

    @Override
    public void alterar() {
     repMarca.alterar(marca);
    }

    @Override
    public List<Object> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
       repMarca.excluir(marca);
    }

    @Override
    public Marca recuperar(Long id) {
        return repMarca.recuperar(id);
    }
    

    


   
    
}
