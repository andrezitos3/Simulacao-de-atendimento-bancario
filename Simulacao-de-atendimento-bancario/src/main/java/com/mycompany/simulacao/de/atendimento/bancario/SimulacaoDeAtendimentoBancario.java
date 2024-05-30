package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Cliente> Fila = new ArrayList<Cliente>();
        Random rd = new Random();
        
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
                }
            
            }

            if (cronometro == 0) {
                for (int i = 0; i < guiches.length; i++) {
                    guiches[i].setOcupado(false);
                }
            }


            //verifica se os guiches estão vazios

                for (int i = 0; i < guiches.length; i++) {
                    Cliente clienteGuiche = Fila.get(0);
                    if (Fila.isEmpty() == false) {
                        
                        if (guiches[i].isOcupado() == false) {

                        guiches[i].setOcupado(true);

                        guiches[i].setTempoUtilizacao(clienteGuiche.getTempodeOperacao());
                        

                        }
                    }

                    // se estiver vazio adiciona o cliente

                }
        }

        for (int i = 0; i < Fila.size(); i++) {

            Cliente cliente = Fila.get(i);

            cliente.mostrarCliente();
        }
    }
}

//    static int segundosContados = 0;
//    
//    public static void main(String[] args) throws InterruptedException {
//        ArrayList<Integer> Fila = new ArrayList<Integer>();
//        Random rd = new Random();
//        Guiche guiches[] = new Guiche[3];
//        
//        for(int i = 0; i < guiches.length; i++) {
//            guiches[i] = new Guiche();
//        }
//
//        // inicializa cliente
//        int Cliente = 123;
//        int finall = 0;
//
//        
//        while(segundosContados < 21600) {
//            
//            // Adiciona cliente a fila
//            Cliente = rd.nextInt(0, 30);
//            segundosContados++;
//            
//            if(Cliente == 0) {
//                Fila.add(segundosContados);
//                System.out.println("Cliente encontrado na fila no segundo " + segundosContados);
//                int ClienteFila = 0;
//                System.out.println(Fila);
//                
//                if(guiches[0].ocupado == false) {
//                    int op = guiches[0].operacao();
//                    ClienteFila = segundosContados;
//                    System.out.println("operacao: " + op);
//                    finall = segundosContados + op;
//                    System.out.println("Segundos contados: " + segundosContados);
//                    System.out.println("tempo que o cliente vai sair do guiche: " + finall);
//                    segundosContados = guiches[0].estaOcupado(segundosContados, finall);
//                    System.out.println("segundos contados dps do estaOcupado: " + segundosContados);
//                    
//                }
//                if(segundosContados >= finall){
//                    System.out.println("Segundos contados: " + segundosContados);
//                    System.out.println("Liberado!!!");
//                    Fila.remove(0);
//                }
//            }
//            
//        }
//        System.out.println(Fila);
//        System.out.println(Fila);
//        
//    }
