package com.mycompany.simulacaodeatendimentobancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    static int segundosContados = 0;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> Fila = new ArrayList<Integer>();
        Random rd = new Random();
        Guiche guiche1 = new Guiche();

        // inicializa cliente
        int Cliente = 123;
        int finall = 0;


        while(segundosContados < 21600) {

            // Adiciona cliente a fila
            Cliente = rd.nextInt(0, 30);
            segundosContados++;

            if(Cliente == 0) {
                Fila.add(segundosContados);
                System.out.println("Cliente encontrado na fila no segundo " + segundosContados);

                if(guiche1.ocupado == false) {
                    int op = guiche1.operacao();
                    System.out.println("operacao: " + op);
                    finall = segundosContados + op;
                    System.out.println("Segundos contados: " + segundosContados);
                    System.out.println("tempo que o cliente vai sair do guiche: " + finall);
                    guiche1.ocupado = true;
                }
                if(segundosContados >= finall){
                    guiche1.ocupado = false;
                    System.out.println("Segundos contados: " + segundosContados);
                    System.out.println("Liberado!!!");
                }
            }

        }
        System.out.println(Fila);
        guiche1.utilizando(Fila);
        System.out.println(Fila);
    }
}