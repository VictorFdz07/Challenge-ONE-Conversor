package com.conversor.modelo;

import javax.swing.*;

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
                this.resultado = (5.0/9.0*(valor-32.0))+273.0;
                return this.resultado;
            //Celsius a Fahrenheit
            case 2:
                this.resultado = 9.0/5.0*valor+32.0;
                return this.resultado;
            //Celsius a Kelvin
            case 3:
                this.resultado = valor+273.0;
                return this.resultado;
            //Kelvin a Fahrenheit
            case 4:
                this.resultado = (9.0/5.0*(valor-273.0))+32.0;
                return this.resultado;
            //Kelvin a Celsius
            case 5:
                this.resultado = valor-273.0;
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
        if (selectedValue.equals("Conversor Temperatura")){
            selectedValue = JOptionPane.showInputDialog(null,
                    "Seleccione la temperatura a la cual desea convertir", "Menú",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    opcionesTemperatura, opcionesTemperatura[0]);

            if (selectedValue.equals("De Fahrenheit a Celsius")){
                JOptionPane.showMessageDialog(null,"El valor en Fahrenheit es: "
                        + this.convertir(0,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedValue.equals("De Fahrenheit a Kelvin")){
                JOptionPane.showMessageDialog(null,"El valor en Fahrenheit es: "
                        + this.convertir(1,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedValue.equals("De Celsius a Fahrenheit")){
                JOptionPane.showMessageDialog(null,"El valor en Celsius es: "
                        + this.convertir(2,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedValue.equals("De Celsius a Kelvin")){
                JOptionPane.showMessageDialog(null,"El valor en Celsius es: "
                        + this.convertir(3,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedValue.equals("De Kelvin a Fahrenheit")){
                JOptionPane.showMessageDialog(null,"El valor en Kelvin es: "
                        + this.convertir(4,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedValue.equals("De Kelvin a Celsius")){
                JOptionPane.showMessageDialog(null,"El valor en Kelvin es: "
                        + this.convertir(5,valor), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        this.menuContinuar();

    }
}
