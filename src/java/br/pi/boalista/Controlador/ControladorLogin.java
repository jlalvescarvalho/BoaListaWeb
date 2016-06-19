package br.pi.boalista.Controlador;

import br.pi.boalista.Modelo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "LoginBean")
@SessionScoped
public class ControladorLogin {
    
    private Usuario usuarioLogado = null;
    private ControladorUsuarioBean controleUsuario = null;

    public ControladorLogin() {
        
        HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true));
        
        controleUsuario=(ControladorUsuarioBean)session.getAttribute("controleUsuario");
        
        if(controleUsuario == null){
            controleUsuario = new ControladorUsuarioBean();
            session.setAttribute("controleUsuario", controleUsuario);
        }
    }
  
    public String realizarLogin(String login, String senha){
        logarUsuario(login, senha);
        
        if(usuarioLogado == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atenção!", "Funcionário Não Cadastrado!"));
            return "/index.xhtml";
        }else if(usuarioLogado != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem Vindo! "+usuarioLogado.getNome()));
            return "/ListarProduto.xhtml";
        }
        
        return null;
    }
    
    public void logarUsuario(String login, String senha){
     Usuario u = controleUsuario.recuperar(login, senha);
      if(u != null){
          FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", u);
        usuarioLogado = u;
      }else{
          usuarioLogado=null;
      }
    }
    
  

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
  
    public void sair(){
        
               this.usuarioLogado=null;
        ((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true))).removeAttribute("usuario");
        
        
        
    }

    
}
