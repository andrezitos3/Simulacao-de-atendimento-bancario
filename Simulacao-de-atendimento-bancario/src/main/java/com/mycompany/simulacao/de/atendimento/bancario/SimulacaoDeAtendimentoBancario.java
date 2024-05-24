package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.ArrayList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> Fila = new ArrayList<Integer>();
        Cronometro cronometro = new Cronometro();
        Random rd = new Random();

        int RandomNumber;

        //esse for é temporario
        for(int i = 0; i < 21600; i++) {

            RandomNumber = rd.nextInt(0, 29);
            cronometro.segundos();
            
            //Adiciona cliente na fila
            if (RandomNumber == 0) {
                Fila.add(cronometro.contador);
            }
            
            System.out.println(RandomNumber);
        }
        
        
    }
}
