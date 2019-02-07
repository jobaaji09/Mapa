/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.controlador;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.unam.ciencias.is.mapa.modelo.Usuario;
import mx.unam.ciencias.is.mapa.modelo.UsuarioDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@RequestScoped
public class GuardaUsuario {
    
    private String correo;
    private String contrasenia;
    private String msg;
    
  
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    public String guardar(){
        UsuarioDAO usuario_bd = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario u  = usuario_bd.encuentraUsuarioPorCorreo(correo);
        if(u != null){
            this.msg = "Ya existe un usuario con ese correo";
            context.addMessage(null, new FacesMessage(this.msg));
            this.contrasenia="";
            this.correo="";
            return "" ;
        }
        u= new Usuario();
        u.setNombre("Actualizame");
        u.setCorreo(this.correo);
        u.setFoto("Actualizame");
        u.setContrasenia(this.contrasenia);
        // u.setFnacimiento(null);
        usuario_bd.guarda(u);
        this.msg="Se guardo con exito";
        context.addMessage(null, new FacesMessage(this.msg));
        this.contrasenia="";
        this.correo="";
        return "";
        
    }
    
}
