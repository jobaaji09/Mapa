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

    /**
     * Metodo que encuentra un usuario.
     * @param id el id del usuario a encontrar
     * @return u el usuario encontrado.
     */
    public Usuario encuentraUsuario(int id){
        Usuario u = (Usuario)super.find(Usuario.class, id);
        return u;
    }
    
    /**
     * Metodo que actualiza un usuario. 
     * El usuario debe de existir en la base de datos
     * @param usuario 
     */
    public void actualizaUsuario(Usuario usuario){
        super.update(usuario);
    }
}
