/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.ipli.servidorcovid_19;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rodrigo
 */
public class FabricaGerenciadordeEntidades {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static FabricaGerenciadordeEntidades fabrica;
    
    public FabricaGerenciadordeEntidades(){
        emf = Persistence.createEntityManagerFactory("Covid_19");
        em = emf.createEntityManager();
    }
    
    public static FabricaGerenciadordeEntidades getInstance(){
        if(fabrica == null){
            fabrica = new FabricaGerenciadordeEntidades();
        
        }
        
        return fabrica;
    }
    
    public static EntityManager getEntityManager() {
        return getInstance().getEm();
    }

    private EntityManager getEm() {
        return em;
    }
}
