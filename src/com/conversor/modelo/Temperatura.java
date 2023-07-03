package com.conversor.modelo;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Temperatura extends Opcion implements Conversor{
    Object[] opcionesTemperatura = {"De Fahrenheit a Celsius","De Fahrenheit a Kelvin",
            "De Celsius a Fahrenheit", "De Celsius a Kelvin", "De Kelvin a Fahrenheit", "De Kelvin a Celsius"};

    String inputValue;
    @Override
    public double convertir(Object tipo, Double valor) {
        this.tipo = (int) tipo;

        switch (this.tipo){
            //Fahrenheit a Celsius
            case 0:
                this.resultado = (5.0/9.0*(valor-32.0));
                return this.resultado;
            //Fahrenheit a Kelvin
            case 1:
                this.resultado = ((5.0/9.0*(valor-32.0))+273.0);
                return this.resultado;
            //Celsius a Fahrenheit
            case 2:
                this.resultado = (9.0/5.0*valor+32.0);
                return this.resultado;
            //Celsius a Kelvin
            case 3:
                this.resultado = (valor+273.0);
                return this.resultado;
            //Kelvin a Fahrenheit
            case 4:
                this.resultado = ((9.0/5.0*(valor-273.0))+32.0);
                return this.resultado;
            //Kelvin a Celsius
            case 5:
                this.resultado = (valor-273.0);
                return this.resultado;
        }

        return this.resultado;
    }

    @Override
    public boolean validar(String inputValue) {
        try {
            double valor = Double.parseDouble(this.inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void menuTemperatura(Object selectedValue){
        boolean isValid = false;
        this.inputValue = "";

        while (!isValid){
            this.inputValue = JOptionPane.showInputDialog("Por favor ingrese la cantidad a convertir");
            isValid = this.validar(this.inputValue);

            if(!isValid){
                JOptionPane.showMessageDialog(null, "Valor no válido. Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double valor = Double.parseDouble(this.inputValue);

        Map<Integer, String> conversionesTemperatura = new HashMap<>();
        conversionesTemperatura.put(0, "De Fahrenheit a Celsius");
        conversionesTemperatura.put(1, "De Fahrenheit a Kelvin");
        conversionesTemperatura.put(2, "De Celsius a Fahrenheit");
        conversionesTemperatura.put(3, "De Celsius a Kelvin");
        conversionesTemperatura.put(4, "De Kelvin a Fahrenheit");
        conversionesTemperatura.put(5, "De Kelvin a Celsius");

        // Obtener el valor seleccionado
        selectedValue = JOptionPane.showInputDialog(null, "Seleccione la moneda a la cual desea convertir", "Menú",
                JOptionPane.INFORMATION_MESSAGE, null, opcionesTemperatura, opcionesTemperatura[0]).toString();

        // Verificar si el valor seleccionado está en el mapa de conversiones
        int indiceTemperatura = -1;
        for (Map.Entry<Integer, String> entry : conversionesTemperatura.entrySet()) {
            if (entry.getValue().equals(selectedValue)) {
                indiceTemperatura = entry.getKey();
                break;
            }
        }

        if (indiceTemperatura != -1) {
            String monedaDestino = ((String) selectedValue).split(" a ")[1];
            JOptionPane.showMessageDialog(null, "El valor en " + monedaDestino +" es: "+ this.convertir(indiceTemperatura, valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }



        this.menuContinuar();

    }
}
