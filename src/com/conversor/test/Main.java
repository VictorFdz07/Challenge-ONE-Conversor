package com.conversor.test;

import com.conversor.modelo.Opcion;
import com.conversor.modelo.Temperatura;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Temperatura temperatura = new Temperatura();

        Object[] opcionesDeConversion = { "Conversor Moneda", "Conversor Temperatura" };

        Object[] opcionesTemperatura = {"Fahrenheit","Celsius"};

        Object selectedValue = JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión", "Menú",
                JOptionPane.INFORMATION_MESSAGE, null,
                opcionesDeConversion, opcionesDeConversion[0]);

        if (selectedValue.equals("Conversor Temperatura")){
            Double inputValue = Double.valueOf(JOptionPane.showInputDialog("Por favor ingrese la cantidad a convertir"));

            selectedValue = JOptionPane.showInputDialog(null,
                    "Seleccione la temperatura a la cual desea convertir", "Menú",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    opcionesTemperatura, opcionesTemperatura[0]);

            if (selectedValue.equals("Fahrenheit")){
                temperatura.Convertir(0,inputValue);

                System.out.println(temperatura.Convertir(0,inputValue));
            }
        }
    }
}