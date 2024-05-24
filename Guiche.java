/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacaodeatendimentobancario;

import java.util.ArrayList;
import java.util.Random;

public class Guiche {
        
        public boolean ocupado = false;
        
        public int operacao(){
            
            Random rd = new Random();
            
            int opcao = rd.nextInt(0, 3);
            
            int tempomedio = 0;
            
            // 0 saque 1 deposito 2 pagamento
            // retorna os tempo em segundos 
            switch (opcao){
                case 0:
                    tempomedio = 60;
                    break;
                case 1:
                    tempomedio = 90;
                    break;
                case 2:
                    tempomedio = 120;
                    break;
            }
            return tempomedio;
        }
        public void utilizando(ArrayList Fila){
            
            ocupado = true;
            
            Fila.remove(0);
        }
}
