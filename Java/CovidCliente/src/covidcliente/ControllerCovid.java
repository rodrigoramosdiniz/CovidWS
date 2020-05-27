/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidcliente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;


import java.util.List;
import javax.swing.table.DefaultTableModel;

import localhost._8000.covid.Covid19;



/**
 *
 * @author Rodrigo
 */
public class ControllerCovid {
    
    private final CovidView view;
    private static final String EDITANDO = "EDITANDO";
    private static final String INICIAL = "INICIAL";
    private static final String OBJETO_SELECIONADO = "OBJETO_SELECIONADO";
    private String estado;
    private Covid19 covidAtual;
    
    public ControllerCovid(CovidView view){
        this.view = view;
        this.estado = INICIAL;
         aplicarEstado();
        InicializarBotoes();
        inicializarTabela();
       
    
    }
    
    public void aplicarEstado() {
        if (estado.equals(ControllerCovid.INICIAL)) {

            view.getCampoCidade().setEnabled(false);
            view.getCampoData().setEnabled(false);
            view.getCampoSexo().setEnabled(false);
            view.getCampoIdade().setEnabled(false);

            view.getBotaoAlterar().setEnabled(false);
            view.getBotaoRemover().setEnabled(false);
            view.getBotaoSalvar().setEnabled(false);
            view.getBotaoNovo().setEnabled(true);
        }

        if (estado.equals(ControllerCovid.EDITANDO)) {

            view.getCampoCidade().setEnabled(true);
            view.getCampoData().setEnabled(true);
            view.getCampoSexo().setEnabled(true);
            view.getCampoIdade().setEnabled(true);

            view.getBotaoSalvar().setEnabled(true);
            view.getBotaoAlterar().setEnabled(true);
            view.getBotaoRemover().setEnabled(true);
            view.getBotaoNovo().setEnabled(false);
        

        if (estado.equals(ControllerCovid.OBJETO_SELECIONADO)) {

            view.getCampoCidade().setEnabled(false);
            view.getCampoData().setEnabled(false);
            view.getCampoSexo().setEnabled(true);
            view.getCampoIdade().setEnabled(false);
           
            view.getBotaoAlterar().setEnabled(true);
            view.getBotaoSalvar().setEnabled(false);
            view.getBotaoRemover().setEnabled(true);
            view.getBotaoNovo().setEnabled(false);
        }

      }
    }
   
    private void inicializarTabela() {
        String[] colunas = {"ID", "Cidade", "Data","Sexo", "Idade"};

        List<Covid19> listaCovid = ControllerCovid.listar();
        Object[][] data = {};
        DefaultTableModel tb = new DefaultTableModel(data, colunas);
        for (Covid19 covid : listaCovid) {
            
            Object[] dadosRecebidos = {covid.getId(), covid.getCidade(), covid.getData(), covid.getSexo(), covid.getIdade()};
            tb.addRow(dadosRecebidos);
        }
        
        
        view.getTabela().setModel(tb);
        this.estado = ControllerCovid.OBJETO_SELECIONADO;
        aplicarEstado();

    }
    
    
    public  void InicializarBotoes(){
        view.getBotaoNovo().addActionListener((ActionEvent e) -> {
            covidAtual = null;
            
            this.estado = ControllerCovid.EDITANDO;

            aplicarEstado();
        });
        
        view.getBotaoSalvar().addActionListener((ActionEvent e) -> {
           if(covidAtual == null){
                    
                    Covid19 covid = new Covid19();
                    
                    covid.setCidade(view.getCampoCidade().getText());
                    covid.setData(view.getCampoData().getText());
                    covid.setSexo(view.getCampoSexo().getText());
                    covid.setIdade(Integer.parseInt(view.getCampoIdade().getText()));
                    
                    ControllerCovid.inserir(covid);
                    
                    this.estado = ControllerCovid.OBJETO_SELECIONADO;
                            
                    inicializarTabela();
                    LimparCampos();
                 
                }else {
                
                covidAtual.setCidade(view.getCampoCidade().getText());
                
                covidAtual.setData(view.getCampoData().getText());
                covidAtual.setSexo(view.getCampoSexo().getText());
                covidAtual.setIdade(Integer.parseInt(view.getCampoIdade().getText()));

                ControllerCovid.alterar(covidAtual);
               this.estado = ControllerCovid.EDITANDO;
                aplicarEstado();
                inicializarTabela();
                LimparCampos();
               
            }
        });
        
      
       
        view.getBotaoAlterar().addActionListener((ActionEvent e) -> {

            List<Covid19> listaCovid = ControllerCovid.listar();

            int linhaSelecionada = view.getTabela().getSelectedRow();

            if (linhaSelecionada >= 0) {
                
                covidAtual = listaCovid.get(linhaSelecionada);

                view.getCampoCidade().setText(covidAtual.getCidade());
               
                view.getCampoData().setText(covidAtual.getData());
                
                view.getCampoSexo().setText(covidAtual.getSexo());
                
                view.getCampoIdade().setText(String.valueOf(covidAtual.getIdade()));
                
                  this.estado = ControllerCovid.EDITANDO;
                aplicarEstado();
               
            }

        });
        
        
        view.getBotaoRemover().addActionListener((ActionEvent e) -> {
           
            int linhaSelecionada = view.getTabela().getSelectedRow();
                
                if (linhaSelecionada >=0) {
                   
                    
                   ControllerCovid.remover(linhaSelecionada);
                    
                    inicializarTabela();
                } 
                
                this.estado = ControllerCovid.OBJETO_SELECIONADO;
                aplicarEstado();
        });
        
        
    }
    
    public void LimparCampos(){
        view.getCampoCidade().setText("");
        view.getCampoData().setText("");
        view.getCampoSexo().setText("");
        view.getCampoIdade().setText("");
    }

    private static java.util.List<localhost._8000.covid.Covid19> listar() {
        localhost._8000.covid.CovidServiceService service = new localhost._8000.covid.CovidServiceService();
        localhost._8000.covid.CovidService port = service.getCovidServicePort();
        return port.listar();
    }

    private static void inserir(localhost._8000.covid.Covid19 covid) {
        localhost._8000.covid.CovidServiceService service = new localhost._8000.covid.CovidServiceService();
        localhost._8000.covid.CovidService port = service.getCovidServicePort();
        port.inserir(covid);
    }

    private static void alterar(localhost._8000.covid.Covid19 covid) {
        localhost._8000.covid.CovidServiceService service = new localhost._8000.covid.CovidServiceService();
        localhost._8000.covid.CovidService port = service.getCovidServicePort();
        port.alterar(covid);
    }

    private static void remover(int id) {
        localhost._8000.covid.CovidServiceService service = new localhost._8000.covid.CovidServiceService();
        localhost._8000.covid.CovidService port = service.getCovidServicePort();
        port.remover(id);
    }

    
    
    
    
    
    

}

    
  








