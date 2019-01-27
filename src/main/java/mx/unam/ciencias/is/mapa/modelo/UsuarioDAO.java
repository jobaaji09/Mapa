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
public class UsuarioDAO extends AbstractDAO {
    
    public UsuarioDAO(){
        super();
    }
    
    public void guarda(Usuario usuario){
        super.save(usuario);
    
    }
    
    public Usuario EncuentraUsuario(Long id){
        Usuario usuario = (Usuario)super.find(Usuario.class, id);
        return usuario;
    }
    
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
}
