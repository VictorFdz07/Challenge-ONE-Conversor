package com.conversor.modelo;

public class Moneda extends Opcion implements Conversor {

    @Override
    public double convertir(Object tipo, Double valor) {
        return 0;
    }

    @Override
    public boolean validar(String valor) {
        return false;
    }


}