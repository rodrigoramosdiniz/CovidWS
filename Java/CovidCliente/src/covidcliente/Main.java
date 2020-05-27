/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidcliente;

import covidcliente.CovidView;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Rodrigo
 */
public class Main {
    public static void main(String[] args) {
        CovidView view = new CovidView();
        
        JFrame janela = new JFrame();
        janela.setTitle("COVID_19");
        janela.setSize(650, 580);
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.add(view);
        janela.setVisible(true);
        
        ControllerCovid ctl = new ControllerCovid(view);
    }
}
