package com.conversor.modelo;

public class Temperatura extends Opcion implements Conversor{
    @Override
    public double Convertir(Object tipo, Double valor) {
        this.tipo = (int) tipo;

        //Fahrenheit
        if (this.tipo == 0){
            this.resultado = 9.0/5.0*valor+32;
        }
        //Celsius
        else if (this.tipo == 1) {
            this.resultado = 5.0/9.0*valor-32;
        }
        return this.resultado;
    }
}
