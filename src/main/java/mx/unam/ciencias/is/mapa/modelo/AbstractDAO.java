/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.mapa.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase abtracta para crear DAO de difentes entidades
 * @author jonathan
 */
public abstract class AbstractDAO {
    
    
    protected SessionFactory sessionFactory;

    
    /**
     * Constructor de la clase.
     * inicializa la variable sessionFactory para que podamos abrir una session
    */
    public AbstractDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    /**
     * Metodo abtracta para agregar un objeto a la base de datos.
     * @param obj 
     */
    protected void save(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
         try {
            
            tx = session.beginTransaction();
            session.persist(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null){ 
               tx.rollback();
            }
            e.printStackTrace(); 
        } finally {
            session.close();
        }
    }

    /**
     * Metodo para actualizar un objeto en la base de datos.
     * @param obj 
     */
    protected void update(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null){ 
               tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que borra un objeto de la base de datos.
     * @param obj 
     */
    protected void delete(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null){ 
               tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    
    /**
     * Metodo que regresa un objeto obtenido de la base de datos
     * @param clazz la clase a la que pertence el objeto
     * @param id el id del objeto en la base de datos
     * @return el objeto que tenga el id en la base de datos si no existe regresa null.
     */
    protected Object find(Class clazz, int id) {
        Object obj = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null){ 
               tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    
    /**
     * Metodo que regresa un lista de todo los objetos de una misma clase de la base de datos
     * @param clazz la clase a la que pertencen los objetos
     * @return una lista de los objetos obtenidos.
     */
    protected List findAll(Class clazz) {
        List objects = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null){ 
               tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return objects;
    }
   
}
