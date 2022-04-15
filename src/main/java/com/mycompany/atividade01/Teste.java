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
public class Teste {

    public static void main(String[] args) {
        ArrayList<Passeio> listaVeiculoPasseio = new ArrayList<>();
        ArrayList<Carga> listaVeiculoCarga = new ArrayList<>();

        int retornoMenuInicial;

        do {
             retornoMenuInicial = chamarMenuInicial();

            switch (retornoMenuInicial){
                case 1:
                    if (listaVeiculoPasseio.size() < 5){
                        cadastrarVeiculoPasseio(listaVeiculoPasseio);
                        break;

                    }else{
                        System.out.printf("Você atingiu o limite máximo de veiculos cadastrados");
                        break;

                    }
                case 2:
                    if (listaVeiculoCarga.size() < 5){
                        cadastrarVeiculoCarga(listaVeiculoCarga);
                        break;

                    }else{
                        System.out.printf("Você atingiu o limite máximo de veiculos cadastrados");
                        break;

                    }
                case 3:
                    imprimeListaVeiculosPasseio(listaVeiculoPasseio);
                    break;

                case 4:
                    imprimeListaVeiculosCarga(listaVeiculoCarga);
                    break;

                case 5:
                    String placaPasseio = capturaPlaca();
                    imprimeVeiculoPasseioPorPlaca(listaVeiculoPasseio,placaPasseio);
                    break;

                case 6:
                    String placaCarga = capturaPlaca();
                    imprimeVeiculoCargaPorPlaca(listaVeiculoCarga,placaCarga);
                    break;

            }
            if (retornoMenuInicial < 1 || retornoMenuInicial> 7 ){
                System.out.println("Opção invalida, digite novamente\n");
            }

        }while (retornoMenuInicial !=7);


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

    public static Carga criarVeiculoCarga(String[] dadosVeiculo){

        Carga veiculoCarga = new Carga();
        veiculoCarga.setMarca(dadosVeiculo[0]);
        veiculoCarga.setModelo(dadosVeiculo[1]);
        veiculoCarga.setPlaca(dadosVeiculo[2]);
        veiculoCarga.setVelocMax(Float.parseFloat(dadosVeiculo[3]));
        veiculoCarga.setCor(dadosVeiculo[4]);
        veiculoCarga.setQtdeRodas(Integer.parseInt(dadosVeiculo[5]));
        veiculoCarga.getMotor().setPotencia(Integer.parseInt(dadosVeiculo[6]));
        veiculoCarga.getMotor().setQtdPist(Integer.parseInt(dadosVeiculo[7]));
        veiculoCarga.setTara(Integer.parseInt(dadosVeiculo[8]));
        veiculoCarga.setCargaMax(Integer.parseInt(dadosVeiculo[9]));
        return veiculoCarga;
    }

    public static ArrayList<Carga> cadastrarVeiculoCarga(ArrayList<Carga> listaVeiculos){

        String[] dadosVeiculos;
        do{
            dadosVeiculos = menuCadastro("Carga");
            listaVeiculos.add( criarVeiculoCarga(dadosVeiculos));
        }while (listaVeiculos.size() < 5 & dadosVeiculos[9].equalsIgnoreCase("1"));

        return listaVeiculos;
    }

    public static Passeio criarVeicuPasseio(String[] dadosVeiculo){

        Passeio veiculoPasseio = new Passeio();
        veiculoPasseio.setMarca(dadosVeiculo[0]);
        veiculoPasseio.setModelo(dadosVeiculo[1]);
        veiculoPasseio.setPlaca(dadosVeiculo[2]);
        veiculoPasseio.setVelocMax(Float.parseFloat(dadosVeiculo[3]));
        veiculoPasseio.setCor(dadosVeiculo[4]);
        veiculoPasseio.setQtdeRodas(Integer.parseInt(dadosVeiculo[5]));
        veiculoPasseio.getMotor().setPotencia(Integer.parseInt(dadosVeiculo[6]));
        veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(dadosVeiculo[7]));
        veiculoPasseio.setQtdePassageiros(Integer.parseInt(dadosVeiculo[10]));
        return veiculoPasseio;
    }

    public static ArrayList<Passeio> cadastrarVeiculoPasseio(ArrayList<Passeio> listaVeiculos){

        String[] dadosVeiculos;
        do{
            dadosVeiculos = menuCadastro("Passeio");
            listaVeiculos.add( criarVeicuPasseio(dadosVeiculos));
        }while (listaVeiculos.size() < 5 && dadosVeiculos[9].equalsIgnoreCase("1"));

        return listaVeiculos;
    }


    public static String[] menuCadastro(String tipoVeiculo){
        String[] dadosVeiculo;
        dadosVeiculo = new String[12];
        Leitura leitura = new Leitura();

        dadosVeiculo[0] = leitura.entDados("Informe a Marca do Veículo de "+tipoVeiculo);
        dadosVeiculo[1] = leitura.entDados("Informe a Modelo do Veículo de "+tipoVeiculo);
        dadosVeiculo[2] = leitura.entDados("Informe a Placa do Veículo de "+tipoVeiculo);
        dadosVeiculo[3] = leitura.entDados("Informe a Velocidade Máxima do Veículo de "+tipoVeiculo);
        dadosVeiculo[4] = leitura.entDados("Informe a Cor do veiculo de "+tipoVeiculo);
        dadosVeiculo[5] = leitura.entDados("Informe a qtde de Rodas do veiculo de "+tipoVeiculo);
        dadosVeiculo[6] = leitura.entDados("Informe a Potencia do motor Veículo de "+tipoVeiculo);
        dadosVeiculo[7] = leitura.entDados("Informe a Qtde de pistões Veículo de "+tipoVeiculo);
        if(tipoVeiculo.equalsIgnoreCase("Carga")){
            dadosVeiculo[8] = leitura.entDados("Informe a Tara doVeículo de "+tipoVeiculo);
            dadosVeiculo[9] = leitura.entDados("Informe a Carga Maxima doVeículo de "+tipoVeiculo);
        }else {
            dadosVeiculo[10] = leitura.entDados("Informe a qtde de Passageiros do Veículo de "+tipoVeiculo);
        }
        dadosVeiculo[11] = leitura.entDados("Deseja cadastrar mais um veiculo de "+tipoVeiculo+" ? Digite 1 para Sim 2 Para Não!");
        return dadosVeiculo;
    }

    public static void imprimeListaVeiculosCarga(ArrayList<Carga> listaVeiculoCarga){
        int i =  1;
        if (listaVeiculoCarga.isEmpty()){
            System.out.printf("Não há veiculos de carga para serem mostrados \n");
        }else {
            for (Carga v: listaVeiculoCarga ) {
                imprimeVeiculoCarga(v,i);
                i++;
            }
        }
    }

    public static void imprimeVeiculoCarga(Carga v, int i){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println("======================================\n");
        System.out.println("Dados do "+ i+"° Veiculo de Carga");
        System.out.println("Placa: "+v.getPlaca());
        System.out.println("Marca: "+v.getMarca());
        System.out.println("Modelo: "+v.getModelo());
        System.out.println("Cor: " + v.getCor());
        System.out.println("A Velocidade maxima é de "+ df.format(v.calcVel(v.getVelocMax()))+" centimeter/hour");
        System.out.println("Qtde de Rodas: "+v.getQtdeRodas());
        System.out.println("Dados do Motor");
        System.out.println("Potência: "+v.getMotor().getPotencia()+" hp");
        System.out.println("Quantidade de Pistões: "+v.getMotor().getQtdPist());
        System.out.println("Carga Maxima  : "+v.getCargaMax());
        System.out.println("Tara  : "+v.getTara()+"\n");
        System.out.println("Soma dos atributos númericos: "+v.calcular());
    }


    private static void imprimeListaVeiculosPasseio(ArrayList<Passeio> listaVeiculoPasseio) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int i =  1;
        if (listaVeiculoPasseio.isEmpty()){
            System.out.printf("Não há veiculos de Passeio para serem mostrados \n");
        }else {
            for (Passeio v: listaVeiculoPasseio ) {
                imprimeVeiculoPasseio(v,i);
                i++;
            }
        }
    }

    public static void imprimeVeiculoPasseio(Passeio v, int i){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println("======================================\n");
        System.out.println("Dados do "+i+"° Veiculo de Passeio");
        System.out.println("Placa: "+v.getPlaca());
        System.out.println("Marca: "+v.getMarca());
        System.out.println("Modelo: "+v.getModelo());
        System.out.println("Cor: " + v.getCor());
        System.out.println("A Velocidade maxima é de "+ df.format(v.calcVel(v.getVelocMax()))+" meter/hour");
        System.out.println("Qtde de Rodas: "+v.getQtdeRodas());
        System.out.println("Dados do Motor");
        System.out.println("Potência: "+v.getMotor().getPotencia()+" hp");
        System.out.println("Quantidade de Pistões: "+v.getMotor().getQtdPist());
        System.out.println("Quantidade de Passageiros  : "+v.getQtdePassageiros());
        System.out.println("Soma dos caracteres dos atributos String: "+v.calcular());
    }

    public static String capturaPlaca(){
        String placa;
        Leitura leitura = new Leitura();
        placa = leitura.entDados("Informe a placa do veiculo que deseja consultar: ");
        return placa;
    }

    public static void imprimeVeiculoPasseioPorPlaca(ArrayList<Passeio> listaVeiculoPasseio,String placa){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int i =  1;
        int j = 0;
        if (listaVeiculoPasseio.isEmpty()){
            System.out.printf("Não há veiculos de Passeio com esta placa \n");
        }else {
            for (Passeio v: listaVeiculoPasseio) {
                if (v.getPlaca().equalsIgnoreCase(placa)){
                    imprimeVeiculoPasseio(v,i);
                    j =1;
                    break;
                }
                i++;
            }
            if (j == 0){
                System.out.println("Não há veiculos de Passeio com esta placa \n");
            }
        }
    }

    public static void imprimeVeiculoCargaPorPlaca(ArrayList<Carga> listaVeiculoCarga,String placa){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int i =  1;
        int j = 0;
        if (listaVeiculoCarga.isEmpty()){
            System.out.printf("Não há veiculos de carga com esta placa \n");
        }else {
            for (Carga v: listaVeiculoCarga) {
                if (v.getPlaca().equalsIgnoreCase(placa)){
                    imprimeVeiculoCarga(v,i);
                    j =1;
                    break;
                }
                i++;
            }
            if (j == 0){
                System.out.println("Não há veiculos de carga com esta placa \n");
            }
        }
    }
}
