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
public class GuardaUsuario {
    
    private String correo;
    private String contrasenia;
    private String msg;
    private UsuarioDAO usuario_bd;
    
    public GuardaUsuario(){
        this.msg = "Todo Bien";
        this.usuario_bd = new UsuarioDAO();
    }
    
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
    
    
    
    public void guardar(){
        
        Usuario u  = this.usuario_bd.encuentraUsuarioPorCorreo(correo);
        if(u != null){
            this.msg = "Ya existe un usuario con ese correo";
            return;
        }
            u= new Usuario();
            u.setNombre("Actualizame");
            u.setCorreo(this.correo);
            u.setFoto("Actualizame");
            u.setContrasenia(this.contrasenia);
           // u.setFnacimiento(null);
            this.usuario_bd.guarda(u);
            this.msg="Se guardo con exito";
        
        
    }
    
}
