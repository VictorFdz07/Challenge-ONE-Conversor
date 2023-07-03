package com.conversor.modelo;

import javax.swing.*;

public class Opcion {
    Object[] opcionesDeConversion = { "Conversor Moneda", "Conversor Temperatura", "Conversor Distancia",
            "Conversor Tiempo", "Conversor Unidades"};
    Object[] opcionesContinuar = { "Yes", "No", "Cancel" };
    int tipo;
    Double resultado;

    public Opcion() {

    }

    public Opcion(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public void menu(){
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión", "Menú",
                JOptionPane.INFORMATION_MESSAGE, null,
                opcionesDeConversion, opcionesDeConversion[0]);

        if (selectedValue != null ) {
            if (selectedValue.equals("Conversor Moneda")) {
                Moneda moneda = new Moneda();
                moneda.menuMoneda(selectedValue);

            }
            if (selectedValue.equals("Conversor Temperatura")) {
                Temperatura temperatura = new Temperatura();
                temperatura.menuTemperatura(selectedValue);

            }
        }else {
            JOptionPane.showMessageDialog(null, "Programa Finalizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void menuContinuar(){
        Object selectedValue = JOptionPane.showInputDialog(null,
                "¿Desea continuar?", "Menú",
                JOptionPane.INFORMATION_MESSAGE, null,
                opcionesContinuar, opcionesContinuar[0]);

        if (selectedValue != null && selectedValue.equals("Yes")) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Programa Finalizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
