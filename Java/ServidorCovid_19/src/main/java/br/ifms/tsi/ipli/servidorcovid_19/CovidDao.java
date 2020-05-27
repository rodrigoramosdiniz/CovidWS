/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.ipli.servidorcovid_19;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Rodrigo
 */
public class CovidDao {
    private EntityManager em;
    
    
    public CovidDao(){
        em = FabricaGerenciadordeEntidades.getEntityManager();
    }
    
    public void persistir(Covid_19 covid){
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        
        em.persist(covid);
        em.getTransaction().commit();
    }
    
    public void remover(int id) {
        em.getTransaction().begin();
        em.remove(buscarPorId(id));
        em.getTransaction().commit();
    }
    

    public void alterar(Covid_19 covid) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.merge(covid);
        em.getTransaction().commit();
    }

   public Covid_19 buscarPorId(int id) {
        return em.find(Covid_19.class, id);
    }
    
    
    public List<Covid_19> listarTodos() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT a ");
        query.append("FROM ");
        query.append("Covid_19 ");
        query.append("a");
        
        
        try{
            
            List<Covid_19> lista = em.createQuery(query.toString()).getResultList();  
            
            System.out.println("============================"+lista.size());
            
            return lista;
            
        }catch(Exception erroSql){
            System.out.println("errro sql"+erroSql.getMessage());  
        }
       return null; 
    }
    
    public EntityManager getEm() {
        return em;
    }
    
    
    }

