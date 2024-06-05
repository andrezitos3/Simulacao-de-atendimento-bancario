package com.mycompany.simulacao.de.atendimento.bancario;

//o guichê só precisa verificar se ele esta ocupado e guardar o tempo que ele será liberado
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
        return this.ocupado;
    }

    public int getTempoUtilizacao() {
        return tempoUtilizacao;
    }
}
