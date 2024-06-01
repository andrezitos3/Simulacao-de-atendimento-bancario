package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Cliente> Fila = new ArrayList<Cliente>();
        Random rd = new Random();
        int ClientesTotal = 0;
        
        Guiche guiches[] = new Guiche[3];
        for (int i = 0; i < guiches.length; i++) {
            guiches[i] = new Guiche();
        }
        
        int cronometro = 0;
        int tempoExtra = 0;

        while (cronometro <= 21600 || Fila.isEmpty() == false) {
            
            if(cronometro > 21600) { //tempo extra
                tempoExtra++;
            }
            
            if(cronometro <= 21600){ // Adiciona cliente a fila enquanto ainda está dentro do expediente
                int cliente;
                cliente = rd.nextInt(0, 30);
                cronometro++;

                if (cliente == 0) {
                    int op = rd.nextInt(0, 3);
                    Fila.add(new Cliente(cronometro, op));
                    ClientesTotal++;
                }
            }

            if (cronometro == 0) { // seta os guichês para começarem vazios ao iniciar o programa
                for (int i = 0; i < guiches.length; i++) {
                    guiches[i].setOcupado(false);
                }
            }


            //verifica se os guiches estão livres para serem usados

                for (int i = 0; i < guiches.length; i++) { //percorre o array de guichês
                    Cliente clienteGuiche = Fila.get(0); //pega o primeiro cliente da fila
                    
                    if (Fila.isEmpty() == false && guiches[i].isOcupado() == false) { //verifica se a fila esta vazia e se algum guiche esta livre
                        guiches[i].setOcupado(true); //ocupando o guiche 
                        
                        int tempoOcupado = clienteGuiche.operacao() + cronometro; //pega o tempo que o guiche ficou ocupado e soma com o tempo atual
                        clienteGuiche.setTempoOcupado(tempoOcupado); // salva o valor do tempo ocupado na lcasse cliente
                    }
                }
        }

        for (int i = 0; i < Fila.size(); i++) {

            Cliente cliente = Fila.get(i);

            cliente.mostrarCliente();
        }
    }
}