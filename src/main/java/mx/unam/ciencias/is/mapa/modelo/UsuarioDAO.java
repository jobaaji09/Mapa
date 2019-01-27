/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.modelo;

/**
 *
 * @author jonathan
 */

public class UsuarioDAO extends AbstractDAO{
    
    public UsuarioDAO(){
        super();
    }

    public Usuario encuentraUSuario(Long id){
        Usuario u = (Usuario)super.find(Usuario.class, id);
        return u;
    }
    
    public void actualizaUsuario(Usuario usuario){
        super.update(usuario);
    }
}
