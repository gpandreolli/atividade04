/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade01;

/**
 *
 * @author gpa
 */
public class Motor {
    private int qtdPist;
    private int potencia;


    public Motor(int qtdPist,int potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public Motor() {
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    
    
    
        
}
