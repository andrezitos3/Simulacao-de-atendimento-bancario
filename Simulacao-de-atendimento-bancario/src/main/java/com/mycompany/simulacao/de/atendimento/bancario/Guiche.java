
package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.Random;

public class Guiche {
    public boolean ocupado = false;
    
    public int operacao() {
        Random rd = new Random();
        ocupado = true;
        
        int opcao = rd.nextInt(0,2);
        int tempoMedio = 0;
         
        //pega o tempo médio de cada opção para deixar o guiche ocupado pelo tempo médio
        switch (opcao) {
            case 0:
                tempoMedio = 60;
                break;
            case 1:
                tempoMedio = 90;
                break;
            case 2:
                tempoMedio = 120;
                break;
         }
        
        return tempoMedio;
}
}
