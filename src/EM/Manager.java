/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EM;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import zinbite.model.Produk;

/**
 *
 * @author Haluan
 */
public class Manager {
    private EntityManagerFactory emf;
    private EntityManager em;
    public Manager(){
        emf = Persistence.createEntityManagerFactory("ZinbitePU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    public void persist(Object o){
        em.persist(o);
    }
    public void save(){
        em.getTransaction().commit();
    }
    public List<Produk> getAllProduk(){
        String SQL = "select * from Produk";
        Query q = em.createNativeQuery(SQL, Produk.class);
        return q.getResultList();
    }
    public void end(){
        em.close();
        emf.close();
    }
}
