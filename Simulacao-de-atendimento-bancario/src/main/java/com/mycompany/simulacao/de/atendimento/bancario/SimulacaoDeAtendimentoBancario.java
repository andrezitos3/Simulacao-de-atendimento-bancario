package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.ArrayList;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args){

        ArrayList<Cliente> Fila = new ArrayList<Cliente>();
        Random rd = new Random();
        int ClientesTotal = 0;
        int tempoDeEspera = 0;
        
        Guiche guiches[] = new Guiche[3];
        for (int i = 0; i < guiches.length; i++) {
            guiches[i] = new Guiche();
            guiches[i].setOcupado(false);
        }
        
        int cronometro = 0;
        int tempoExtra = 0;
       
        
            if (cronometro == 0) { // seta os guichês para começarem vazios ao iniciar o programa
                for (int i = 0; i < guiches.length; i++) {
                    guiches[i].setOcupado(false);
                }
            }

        while (cronometro <= 21600 || Fila.isEmpty() == false) {
            
            if(cronometro > 21600) { //tempo extra
                tempoExtra++;
            }
            
            if(cronometro <= 21600){ // Adiciona cliente a fila enquanto ainda está dentro do expediente
                int cliente;
                cliente = rd.nextInt(0, 30);
                

                if (cliente == 0) {
                    int op = rd.nextInt(0, 3);
                    Fila.add(new Cliente(cronometro, op));
                    ClientesTotal++;
                }
            }




            //verifica se os guiches estão livres para serem usados

            if(Fila.isEmpty() == false){ //verifica se a fila esta vazia
                Cliente clienteGuiche = Fila.get(0); //pega o primeiro cliente da fila
                 Fila.remove(0);
                for (int i = 0; i < guiches.length; i++) { //percorre o array de guichês
                    
                    if (guiches[i].isOcupado() == false) { //verifica se algum guiche esta livre
                        guiches[i].setOcupado(true); //ocupando o guiche 
                        tempoDeEspera += cronometro - clienteGuiche.getCronometroCliente();
                        
                        guiches[i].setTempoUtilizacao(clienteGuiche.operacao() + cronometro);  //pega o tempo que o guiche ficou ocupado e soma com o tempo atual
                    }
                }
            }
            
            //libera o guiche com base no tempo que demora para fazer a operação
            
            for(int i = 0; i < guiches.length; i++){
                if(guiches[i].isOcupado() == true && cronometro == guiches[i].getTempoUtilizacao()) {
                    guiches[i].setOcupado(false);
                }
            }
            
            cronometro++;
        }
        
        //Relatório final
        
        
    }
}