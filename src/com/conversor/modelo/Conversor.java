package com.conversor.modelo;

public interface Conversor {
    double convertir(Object tipo, Double valor);

    boolean validar(String valor);
}
