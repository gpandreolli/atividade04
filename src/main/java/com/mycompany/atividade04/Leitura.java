package com.mycompany.atividade04;

import java.util.Scanner;

public class Leitura {

    public String entDados(String entrada){

        System.out.println(entrada);
        Scanner leitura = new Scanner(System.in);

        return leitura.next();
    }
}
