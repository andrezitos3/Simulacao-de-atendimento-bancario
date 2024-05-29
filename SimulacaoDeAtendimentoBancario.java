package com.mycompany.simulacaodeatendimentobancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    static int cronometro = 0;

    public static void main(String[] args) throws InterruptedException {
        
        ArrayList<Cliente> Fila = new ArrayList<Cliente>();
        
        Random rd = new Random();

         Guiche guiches[] = new Guiche[3];

         for (int i = 0; i < guiches.length; i++){
         
            guiches[i] =new  Guiche();
            
         }


        while(cronometro < 21600) {

            if (cronometro == 0){
                for (int i = 0; i < guiches.length; i++){
                    guiches[i].setOcupado(false);
                }
            }
            
            // Adiciona cliente a fila
            int cliente;
            cliente = rd.nextInt(0, 30);
            cronometro++;

            
            
            
            if (cliente == 0) {
                
                int op = rd.nextInt(0, 3);
                
                Fila.add(new Cliente(cronometro, op));
                
                
                
                

//                if (guiches[0].ocupado == false) {
//                    int op = guiches[0].operacao();
//                    System.out.println("operacao: " + op);
//                    duracaoOp = cronometro + op;
//                    System.out.println("Segundos contados: " + cronometro);
//                    System.out.println("tempo que o cliente vai sair do guiche: " + duracaoOp);
//                }
//                if (cronometro >= duracaoOp){
//                    System.out.println("Segundos contados: " + cronometro);
//                    System.out.println("Liberado!!!");
//                }
            }

        }
        for (int i = 0; i < Fila.size(); i++){
            
            Cliente cliente = Fila.get(i);
            
            cliente.mostrarCliente();
        }
    }
}
