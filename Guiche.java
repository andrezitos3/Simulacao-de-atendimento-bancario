/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacaodeatendimentobancario;

import java.util.ArrayList;
import java.util.Random;

public class Guiche {
        
        private boolean ocupado;
        
        private int tempoUtilizacao;
        
        public Guiche(){}
        
        public void setOcupado(boolean oc){
            this.ocupado = oc;
        }
        public void setTempoUtilizacao(int segundosOp){
            this.tempoUtilizacao = segundosOp;
        }

    public boolean isOcupado() {
        return ocupado;
    }

    public int getTempoUtilizacao() {
        return tempoUtilizacao;
    }
}
