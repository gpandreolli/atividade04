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
                        listaVeiculoPasseio = cadastrarVeiculoPasseio(listaVeiculoPasseio);
                        break;

                    }else{
                        System.out.printf("Você atingiu o limite máximo de veiculos cadastrados");
                        break;

                    }
                case 2:
                    if (listaVeiculoCarga.size() < 5){
                        listaVeiculoCarga = cadastrarVeiculoCarga(listaVeiculoCarga);
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
        veiculoCarga.setTara(Integer.parseInt(dadosVeiculo[6]));
        veiculoCarga.setCargaMax(Integer.parseInt(dadosVeiculo[7]));
        veiculoCarga.getMotor().setQtdPist(Integer.parseInt(dadosVeiculo[5]));
        veiculoCarga.getMotor().setPotencia(Integer.parseInt(dadosVeiculo[4]));

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
        veiculoPasseio.setQtdePassageiros(Integer.parseInt(dadosVeiculo[5]));
        veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(dadosVeiculo[5]));
        veiculoPasseio.getMotor().setPotencia(Integer.parseInt(dadosVeiculo[4]));

        return veiculoPasseio;
    }

    public static ArrayList<Passeio> cadastrarVeiculoPasseio(ArrayList<Passeio> listaVeiculos){

        String[] dadosVeiculos;
        do{
            dadosVeiculos = menuCadastro("Carga");
            listaVeiculos.add( criarVeicuPasseio(dadosVeiculos));
        }while (listaVeiculos.size() < 5 && dadosVeiculos[9].equalsIgnoreCase("1"));

        return listaVeiculos;
    }


    public static String[] menuCadastro(String tipoVeiculo){
        String[] dadosVeiculo;
        dadosVeiculo = new String[10];
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
            System.out.println("Informe a qtde de Passageiros do Veículo de "+tipoVeiculo);
            dadosVeiculo[6] = leitura.entDados("");
        }

        System.out.println("Deseja cadastrar mais um veiculo de "+tipoVeiculo+" ? Digite 1 para Sim 2 Para Não!");
        dadosVeiculo[9] = leitura.entDados("");
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
        System.out.println("Dados do Veiculo"+i+"° de Carga");
        System.out.println("Marca: "+v.getMarca());
        System.out.println("Modelo: "+v.getModelo());
        System.out.println("Placa: "+v.getPlaca());
        System.out.println("A Velocidade maxima é de "+ df.format(v.calcVel(v.getVelocMax()))+" centimeter/hour");
        System.out.println("Dados do Motor");
        System.out.println("Potência: "+v.getMotor().getPotencia()+" hp");
        System.out.println("Quantidade de Pistões: "+v.getMotor().getQtdPist());
        System.out.println("Carga Maxima  : "+v.getCargaMax());
        System.out.println("Tara  : "+v.getTara()+"\n");
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
        System.out.println("Dados do Veiculo"+i+"° de Passeio");
        System.out.println("Marca: "+v.getMarca());
        System.out.println("Modelo: "+v.getModelo());
        System.out.println("Placa: "+v.getPlaca());
        System.out.println("A Velocidade maxima é de "+ df.format(v.calcVel(v.getVelocMax()))+" meter/hour");
        System.out.println("Dados do Motor");
        System.out.println("Potência: "+v.getMotor().getPotencia()+" hp");
        System.out.println("Quantidade de Pistões: "+v.getMotor().getQtdPist());
        System.out.println("Quantidade de Passageiros  : "+v.getQtdePassageiros());
    }

    public static String capturaPlaca(){
        String placa;
        Leitura leitura = new Leitura();
        System.out.println("Informe a placa do veiculo que deseja mostrar: ");
        placa = leitura.entDados("");
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
