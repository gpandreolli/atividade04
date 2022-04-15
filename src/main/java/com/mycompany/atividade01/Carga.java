package com.mycompany.atividade01;

public final class Carga extends Veiculo{

    private int cargaMax;
    private int tara;


    public Carga(String placa, String marca, String modelo, float velocMax, int cargaMax, int tara) {
        super(placa, marca, modelo, velocMax);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public float calcVel(float velocMax) {
        velocMax = velocMax *100000;

        return velocMax;
    }
}
