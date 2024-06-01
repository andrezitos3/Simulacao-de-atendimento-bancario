package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.Random;

public class Cliente {

    private int cronometroCliente;
    private int tempodeOperacao;
    private int saque, deposito, pagamento;
    private int tempoOcupado;

    public Cliente() {
    }

    public Cliente(int segundos, int operacao) {
        this.cronometroCliente = segundos;
        int op = operacao();
        this.tempodeOperacao = op;
    }

    public void mostrarCliente() {
        System.out.println("Tempo de identificação de cliente: " + cronometroCliente);
        System.out.println("Tempo de Operação: " + tempodeOperacao);
    }

    public int operacao() {

        Random rd = new Random();

        int opcao = rd.nextInt(0, 3);

        int tempomedio = 0;

        // 0 saque 1 deposito 2 pagamento
        // retorna os tempo em segundos 
        switch (opcao) {
            case 0:
                tempomedio = 60;
                this.saque++;
                break;
            case 1:
                tempomedio = 90;
                this.deposito++;
                break;
            case 2:
                tempomedio = 120;
                this.pagamento++;
                break;
        }
        return tempomedio;
    }

    public int getSaque() {
        return saque;
    }

    public void setSaque(int saque) {
        this.saque = saque;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getTempoOcupado() {
        return tempoOcupado;
    }

    public void setTempoOcupado(int tempoOcupado) {
        this.tempoOcupado = tempoOcupado;
    }

    public int getCronometroCliente() {
        return this.cronometroCliente;
    }

    public int getTempodeOperacao() {
        return this.tempodeOperacao;
    }
}
