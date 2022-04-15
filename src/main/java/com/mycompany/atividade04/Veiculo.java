/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade04;

/**
 *
 * @author gpa
 */
public  abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private float velocMax;
    private Motor motor ;
    private String cor;
    private int qtdeRodas;


    public Veiculo(String placa,String marca, String modelo, float velocMax,String cor,int qtdeRodas) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.velocMax = velocMax;    
        this.motor = new Motor();
        this.cor = cor;
        this.qtdeRodas = qtdeRodas;
    }

    public Veiculo() {
        placa ="";
        marca = "";
        modelo = "";
        cor = "";
        qtdeRodas = 0;
        velocMax = 0.0f;
        motor = new Motor();
    }

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    public abstract float calcVel(float velocMax);

    public String getCor() {return cor;}

    public final void setCor(String cor) {this.cor = cor;}

    public final int getQtdeRodas() {return qtdeRodas;}

    public void setQtdeRodas(int qtdeRodas) {this.qtdeRodas = qtdeRodas;}
}
