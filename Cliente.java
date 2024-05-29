/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacaodeatendimentobancario;

import java.util.Random;

public class Cliente {
    
          private int cronometroCliente;
          private int tempodeOperacao;
    
          public Cliente(){}
          
          public Cliente(int segundos, int operacao){
              this.cronometroCliente = segundos;
              int op = operacao();
              this.tempodeOperacao = op;
          }
    
          public void mostrarCliente(){
              System.out.println("Tempo de identificação de cliente: " + getCronometroCliente());
              System.out.println("//");
              System.out.println("Tempo de Operação: " + getTempodeOperacao());
          }
          
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
        public int getCronometroCliente(){
            return this.cronometroCliente;
        }
        public int getTempodeOperacao(){
            return this.tempodeOperacao;
        }
}
