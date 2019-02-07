/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.modelo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jonathan
 */

public class UsuarioDAO extends AbstractDAO{

    public UsuarioDAO(){
        super();
    }


    public void guarda(Usuario usuario){
        super.save(usuario);

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
    
    /**
     * Metodo que encuantra a un usuario por su correo
     * @param correo
     * @return 
     */
    
    public Usuario encuentraUsuarioPorCorreo(String correo){
        Usuario usuario = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;

        try {
            tx = session.beginTransaction();
            String hql = "from Usuario where correo = :correo";
            Query query  = session.createQuery(hql);
            query.setParameter("correo", correo);
            usuario =(Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return usuario;

    }
    
    public Usuario encuentraUsuarioPorCorreoContrasenia(String correo,String contrasenia){
        Usuario usuario =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Usuario u where u.correo = :correo and u.contrasenia = :contrasenia";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia", contrasenia);
            usuario = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        
        
        return usuario;
    }
    
}
