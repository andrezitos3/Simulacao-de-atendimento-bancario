package com.mycompany.simulacao.de.atendimento.bancario;

import java.util.ArrayList;
import java.util.Random;

public class SimulacaoDeAtendimentoBancario {

    public static void main(String[] args){
        
        //inicializa a fila, os guichês e as variaveis que serão utilizadas no relatório final
        ArrayList<Cliente> Fila = new ArrayList<Cliente>();
        Random rd = new Random();
        int cronometro = 0;
        int tempoExtra = 0;
        int ClientesTotal = 0;
        int tempoTotalEspera = 0;
        double mediaEspera = 0;
        int saque, deposito, pagamento;
        saque = deposito = pagamento = 0;
        
        Guiche guiches[] = new Guiche[3];
        for (int i = 0; i < guiches.length; i++) {
            guiches[i] = new Guiche();
            guiches[i].setOcupado(false);
        }
        
        //periodo de expediente
        
        while (cronometro <= 21600 || Fila.isEmpty() == false) { 
            
            //tempo extra
            if(cronometro > 21600) { 
                tempoExtra++;
            }
            
            // Adiciona um cliente a fila enquanto ainda está dentro do expediente
            if(cronometro <= 21600){ 
                int cliente;
                cliente = rd.nextInt(0, 30);
                

                if (cliente == 0) {
                    int op = rd.nextInt(0, 3);
                    
                    if(op == 0) {
                        saque++;
                    } if(op == 1){
                        deposito++;
                    } if(op == 2){
                        pagamento++;
                    }
                    
                    Fila.add(new Cliente(cronometro, op));
                    ClientesTotal++;
                }
            }
            

            //verifica se os guiches estão livres para serem usados e ocupa eles
            if(Fila.isEmpty() == false && guicheLivre(guiches)){
                Cliente clienteGuiche = Fila.get(0);
                Fila.remove(0);
                
                for (int i = 0; i < guiches.length; i++) { //ocupa os guichês
                    if (guiches[i].isOcupado() == false) {
                        guiches[i].setOcupado(true); 
                        guiches[i].setTempoUtilizacao(clienteGuiche.operacao() + cronometro);
                        tempoTotalEspera += cronometro - clienteGuiche.getCronometroCliente();
                    }
                }
            }
            
            //libera o guiche após ser utilizado
            for(int i = 0; i < guiches.length; i++){
                if(guiches[i].isOcupado() == true && cronometro == guiches[i].getTempoUtilizacao()) {
                    guiches[i].setOcupado(false);
                }
            }
            
            cronometro++; //faz o tempo passar
        }
        
        //Relatório final
        
        if(ClientesTotal > 0) { //Faz a média do tempo de espera de todos os clientes
            mediaEspera = tempoTotalEspera / ClientesTotal;
        }
        
        //Cálculos utilizados para obter os segundos e minutos da média
        int segMedia = (int) mediaEspera % 60;
        mediaEspera /= 60;
        int minMedia = (int) mediaEspera % 60;

        int segExtra = (int) tempoExtra % 60;
        tempoExtra /= 60;
        int minExtra = (int) tempoExtra % 60;
        
        System.out.println("Numero total de clientes atendidos: " + ClientesTotal);
        System.out.println("Numero total de clientes que fizeram saque: " + saque);
        System.out.println("Numero total de clientes que fizeram depósito: " + deposito);
        System.out.println("Numero total de clientes que fizeram pagamento: " + pagamento);
        System.out.println("Tempo médio de espera na fila: " + minMedia + " minutos " + segMedia + " segundos");
        System.out.println("tempo extra de expediente: " + minExtra + " minutos " + segExtra + " segundos");
    }
    
        //esse metodo verifica se algum dos guichês esta livre
        public static boolean guicheLivre(Guiche guiches[]) {
        boolean retorno = false;
        for (int i = 0; i < guiches.length; i++) {
            if (guiches[i].isOcupado() == false) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }
}