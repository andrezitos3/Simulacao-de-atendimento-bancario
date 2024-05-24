/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simulacaodeatendimentobancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;


public class SimulacaoDeAtendimentoBancario {
    
    static int segundosContados;
    
    public static void main(String[] args) throws InterruptedException {
        
        ArrayList<Integer> Fila = new ArrayList<Integer>();
        Random rd = new Random();
        Guiche guiche1 = new Guiche();

        //Adiciona cliente na fila
            
           // inicializar cliente
           int cliente = 123;
           
           // Adiciona
           while(segundosContados < 21600) {

            cliente = rd.nextInt(0, 30);
            segundosContados++;

            if(cliente == 0) {
                
                Fila.add(segundosContados);
                 System.out.println("Cliente encontrado na fila no segundo " + segundosContados);
                 
                if (guiche1.ocupado == false){
                    guiche1.utilizando(Fila);
                    int opcao = guiche1.operacao();
                    int tempoSaida = segundosContados + opcao;
                    System.out.println("operacao feita em segundos: " + opcao);
                    guiche1.ocupado = false;
                    System.out.println("tempo de saida " + tempoSaida);
                }
            }

        }
        
        System.out.println(Fila.size());
        
  }
}
