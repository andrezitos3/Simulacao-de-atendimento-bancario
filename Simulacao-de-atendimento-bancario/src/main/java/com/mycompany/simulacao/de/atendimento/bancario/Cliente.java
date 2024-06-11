package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.Random;

public class Cliente {

    private int cronometroCliente; //tempo que o cliente entrou na fila
    private int tempodeOperacao; //tempo que demora para fazer a operação

    public Cliente() {
    }

    public Cliente(int segundos, int operacao) {
        this.cronometroCliente = segundos;
        int op = this.operacao();
        this.tempodeOperacao = op;
    }

    public void mostrarCliente() {
        System.out.println("Tempo de identificação de cliente: " + cronometroCliente);
        System.out.println("Tempo de Operação: " + tempodeOperacao);
    }
    
    public int operacao() { //define o tempo médio de cada operação

        Random rd = new Random();

        int opcao = rd.nextInt(0, 3);

        int tempomedio = 0;

        // 0 saque 1 deposito 2 pagamento
        // retorna os tempos em segundos 
        switch (opcao) {
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

    public int getCronometroCliente() {
        return this.cronometroCliente;
    }

    public int getTempodeOperacao() {
        return this.tempodeOperacao;
    }
}
