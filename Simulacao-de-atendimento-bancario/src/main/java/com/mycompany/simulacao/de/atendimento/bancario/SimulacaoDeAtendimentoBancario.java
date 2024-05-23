package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.LinkedList;
import java.io.*;
import java.lang.Thread;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args) {
        LinkedList<Integer> Fila = new LinkedList<Integer>();
        Cronometro cronometro = new Cronometro();
        Random rd = new Random();
        
        int RandomNumber = rd.nextInt(0, 29);
        
        //fazer os segundos passarem pelos numeros gerados
        //tem que parar quando a fila acabar ok
        while (Fila.isEmpty() != true){
            System.out.println(i);
            
            if(RandomNumber == 0) {
                
            }
        cronometro.segundos();
    }
    }
}
