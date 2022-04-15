/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade01;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 *
 * @author gpa
 */
public class Teste  implements Calcular{


    public static void main(String[] args) {
        ArrayList<Passeio> listaVeiculoPasseio = new ArrayList<>();
        ArrayList<Carga> listaVeiculoCarga = new ArrayList<>();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        switch (chamarMenuInicial()) {
            case 1:
                cadatraVeiculoCarga();


        }




    }

    public static int chamarMenuInicial() {
        System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
        System.out.println("1 - Cadastrar Veículo de Passeio");
        System.out.println("2 - Cadastrar Veículo de Carga");
        System.out.println("3 - Imprimir todos os Veículos de Passeio");
        System.out.println("4 - Imprimir todos os Veículos de Carga");
        System.out.println("5 - Imprimir Véiculos de Passeio pela Placa");
        System.out.println("6 - Imprimir Véiculos de Carga pela Placa");
        System.out.println("7 - Sair do Sistema");
        Leitura leitura = new Leitura();
        return Integer.parseInt(leitura.entDados(""));
    }

    public static Carga cadatraVeiculoCarga(){
        Carga veiculoCarga = new Carga();
        String[] dadosVeiculo = {};
        menuCadastro("Carga");
        dadosVeiculo = menuCadastro("Carga");
        veiculoCarga.setMarca(dadosVeiculo[0]);
        veiculoCarga.setModelo(dadosVeiculo[1]);
        veiculoCarga.setPlaca(dadosVeiculo[2]);
        veiculoCarga.setVelocMax(Float.parseFloat(dadosVeiculo[3]));
        veiculoCarga.setTara(Integer.parseInt(dadosVeiculo[6]));
        veiculoCarga.setCargaMax(Integer.parseInt(dadosVeiculo[7]));
        veiculoCarga.getMotor().setQtdPist(Integer.parseInt(dadosVeiculo[5]));
        veiculoCarga.getMotor().setPotencia(Integer.parseInt(dadosVeiculo[4]));

        return veiculoCarga;
    }



    public static String[] menuCadastro(String tipoVeiculo){
        String[] dadosVeiculo;
        dadosVeiculo = new String[8];
        Leitura leitura = new Leitura();
        System.out.println("Informe a Marca do Veículo de "+tipoVeiculo);
        dadosVeiculo[0] = leitura.entDados("");
        System.out.println("Informe a Modelo do Veículo de "+tipoVeiculo);
        dadosVeiculo[1] = leitura.entDados("");
        System.out.println("Informe a Placa do Veículo de "+tipoVeiculo);
        dadosVeiculo[2] = leitura.entDados("");
        System.out.println("Informe a Velocidade Máxima do Veículo de "+tipoVeiculo);
        dadosVeiculo[3] = leitura.entDados("");
        System.out.println("Informe a Potencia do motor Veículo de "+tipoVeiculo);
        dadosVeiculo[4] = leitura.entDados("");
        System.out.println("Informe a Qtde de pistões Veículo de "+tipoVeiculo);
        dadosVeiculo[5] = leitura.entDados("");
        if(tipoVeiculo.equalsIgnoreCase("Carga")){
            System.out.println("Informe a Tara doVeículo de "+tipoVeiculo);
            dadosVeiculo[6] = leitura.entDados("");
            System.out.println("Informe a Carga Maxima doVeículo de "+tipoVeiculo);
            dadosVeiculo[7] = leitura.entDados("");
        }else {
            System.out.println("Informe a qtde de Passageiros doVeículo de "+tipoVeiculo);
            dadosVeiculo[6] = leitura.entDados("");
        }

        return dadosVeiculo;
    }
}
