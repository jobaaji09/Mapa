/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.unam.ciencias.is.mapa.modelo.Usuario;
import mx.unam.ciencias.is.mapa.modelo.UsuarioDAO;

/**
 *
 * @author jonh
 */
@ManagedBean
@SessionScoped
public class ControladorLogin {
 
    private String correo;
    private String contrasenia;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String login() {
        UsuarioDAO u = new UsuarioDAO();
        Usuario user = u.encuentraUsuarioPorCorreoContrasenia(correo, contrasenia);
        FacesContext context = FacesContext.getCurrentInstance();

        if (user == null) {
            context.addMessage(null, new FacesMessage("No se pudo iniciar session, intenta otra vez"));
            correo = null;
            contrasenia = null;
            return "";
        } 
        else {
            context.getExternalContext().getSessionMap().put("user", user.getCorreo());
            correo = null;
            contrasenia = null;
            return "/user/inicio?faces-redirect=true";
        
        }
    }

    public String  logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
    
    
}
