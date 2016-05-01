/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Dao.DaoManagerHiber;
import br.pi.boalista.Modelo.Marca;
import br.pi.boalista.Modelo.Repositorio.RepositorioMarca;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "MarcaBean")
@RequestScoped
public class ControladorMarcaBean implements InterfaceController {
    
    
    private RepositorioMarca repMarca = null;
    private Marca marca;
    private List<SelectItem> MarcaSelected;
    
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

    public List<SelectItem> getMarcaSelected() {
        MarcaSelected = new ArrayList<SelectItem>();
           List<Marca> ListaMarcas = DaoManagerHiber.getInstance().recoverAll("from marca");
           
           if(!ListaMarcas.isEmpty()){
               SelectItem item;
               for (int i=0; i<ListaMarcas.size(); i++) {
                   item = new SelectItem(ListaMarcas.get(i).getMarca());
                   MarcaSelected.add(item);
               }
           
        }
        
        return MarcaSelected;
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
    public List<Marca> recuperarTodos() {
       return repMarca.recuperarTodos();
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
