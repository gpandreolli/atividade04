package com.mycompany.atividade01;

public final class Passeio extends Veiculo implements Calcular{

    private int qtdePassageiros;

    public Passeio(String placa, String marca, String modelo, float velocMax, int qtdePassageiros, String cor, int qtdeRodas) {
        super(placa, marca, modelo, velocMax,cor,qtdeRodas);
        this.qtdePassageiros = qtdePassageiros;
    }

    public Passeio() {
        this.qtdePassageiros =0;
    }

    public int getQtdePassageiros() {
        return qtdePassageiros;
    }

    public void setQtdePassageiros(int qtdePassageiros) {
        this.qtdePassageiros = qtdePassageiros;
    }

    @Override
    public float calcVel(float velocMax) {

        velocMax = velocMax * 1000;

        return velocMax;
    }

    @Override
    public int calcular() {

        return getPlaca().length() + getCor().length() + getMarca().length() + getModelo().length();
    }
}
