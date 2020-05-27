/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.ipli.servidorcovid_19;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Rodrigo
 */
public class servidor {
    public static void main(String[] args) {
        
        CovidService covid = new CovidService();
        String url = "http://localhost:8000/covid";
        System.out.println("Covid_19 rodando:" + url);
        Endpoint.publish(url, covid);
        
    }
}
