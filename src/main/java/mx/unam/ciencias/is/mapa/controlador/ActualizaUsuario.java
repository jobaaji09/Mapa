/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.controlador;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import mx.unam.ciencias.is.mapa.modelo.Usuario;
import mx.unam.ciencias.is.mapa.modelo.UsuarioDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@ViewScoped
public class ActualizaUsuario implements Serializable{
    
    private String idusuario;
    private String nombre;
    private String correo;
    private Date fecha;
    private Usuario usuario;
    private String msg;
    private UsuarioDAO usuario_bd;

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    
    public ActualizaUsuario(){
        this.msg = "Como no hay sesion se necesita el id de usuario";
        this.usuario_bd = new UsuarioDAO();
    }
    
    public void encuentraUsuario(){
        this.usuario = this.usuario_bd.encuentraUsuario(Integer.parseInt(this.idusuario));
        if(this.usuario !=null){
            System.out.println(this.usuario);
            this.msg = "El usuario es " + this.usuario.getNombre();
        }else{
            this.msg = "El usuario es null";
        }
    }
    
    public void actualiza(){
        if(this.usuario==null)
            return;
        this.usuario.setCorreo(correo);
        this.usuario.setFnacimiento(fecha);
        this.usuario.setNombre(nombre);
        
        this.usuario_bd.actualizaUsuario(usuario);
        this.msg = "Usuario actualizado";
//        return "actualiza?faces-redirect=true";
    }
}
