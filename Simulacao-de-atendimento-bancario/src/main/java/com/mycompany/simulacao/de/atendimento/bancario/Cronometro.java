package com.mycompany.simulacao.de.atendimento.bancario;

import java.io.*;
import java.lang.Thread;

public class Cronometro {
    public int contador;
    
    void segundos() throws InterruptedException{
        Thread.sleep(1000);
        contador = contador + 1;
    }
    
    
}
