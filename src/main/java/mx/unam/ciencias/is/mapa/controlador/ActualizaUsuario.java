/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.controlador;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
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
@ViewScoped
public class ActualizaUsuario implements Serializable{
    
    private String nombre;
    private String foto;
    private String correo;
    private Date fnacimiento;
    private String contrasenia;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    @PostConstruct
    public void llenaDatos(){
        UsuarioDAO u_db = new UsuarioDAO();
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        Usuario u = u_db.encuentraUsuarioPorCorreo(user);
        //this.contrasenia = u.getContrasenia();
        this.correo = u.getCorreo();
        this.fnacimiento = u.getFnacimiento();
        this.nombre = u.getNombre();
    }
     
    public void actualiza(){
        UsuarioDAO u_db = new UsuarioDAO();
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        Usuario u = u_db.encuentraUsuarioPorCorreo(user);
        int n_actualizados =0;
        if(!u.getNombre().equals(nombre)){
            u.setNombre(nombre);
            n_actualizados++;
        }
        if(!u.getCorreo().equals(correo)){
            u.setCorreo(correo);
            n_actualizados++;
        }
        if(this.fnacimiento!=null){
            if(this.fnacimiento.compareTo(fnacimiento)!=0){
                u.setFnacimiento(fnacimiento);
                n_actualizados++;
            }
        }
        if(!u.getContrasenia().equals(contrasenia)){
            u.setContrasenia(contrasenia);
            n_actualizados++;
        }
        if(n_actualizados<1){
            info("No hay nada que actualizar");
        }else{
            u_db.actualizaUsuario(u);
            info("Se a actualizo la informacion " + n_actualizados);
        }
    }
    
    private void info(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje));
    }
}
