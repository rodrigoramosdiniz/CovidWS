/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.ipli.servidorcovid_19;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Rodrigo
 */

@WebService(targetNamespace = "http://localhost:8000/covid")
public class CovidService {
 
    private CovidDao dao;
    
    public CovidService(){
        dao = new CovidDao();
    }
    
    
    @WebMethod
    public void inserir(@WebParam(name="covid")Covid_19 covid ){
    
    dao.persistir(covid);
    
    }
    
    @WebMethod
    public void alterar(@WebParam(name = "covid") Covid_19 covid) {
        dao.alterar(covid);
    }
    
    @WebMethod
    public void remover(@WebParam(name = "id") int id) {
        dao.remover(id);
    }
    
    public List<Covid_19> listar(){
   return dao.listarTodos();
    
    }
   
    
    }
