/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.controlador;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.unam.ciencias.is.mapa.modelo.Usuario;
import mx.unam.ciencias.is.mapa.modelo.UsuarioDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@ViewScoped
public class ActualizaUsuario {
    
    private String idusuario;
    private Usuario usuario;
    private String msg;
    private UsuarioDAO usuario_bd;

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
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
        this.usuario = this.usuario_bd.encuentraUSuario(Integer.parseInt(this.idusuario));
        try{
            this.usuario.getIdusuario();
        }catch(Exception e){
            this.msg="No hay usuario";
        }
    }
    
    public void actualiza(){
        
    
    }
}
