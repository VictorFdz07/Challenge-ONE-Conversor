package com.conversor.modelo;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Moneda extends Opcion implements Conversor {
    Object[] opcionesMoneda = {"MXN a USD", "MXN a EUR", "MXN a GBP", "MXN a JPY", "MXN a KRW",
                                "USD a MXN", "EUR a MXN", "GBP a MXN", "JPY a MXN", "KRW a MXN"};

    String inputValue;
    @Override
    public double convertir(Object tipo, Double valor) {
        this.tipo = (int) tipo;

        switch (this.tipo){
            //MXN a USD
            case 0:
                this.resultado = (valor*0.059);
                return this.resultado;
            //MXN a EUR
            case 1:
                this.resultado = (valor*0.054);
                return this.resultado;
            //MXN a GBP
            case 2:
                this.resultado = (valor*0.046);
                return this.resultado;
            //MXN a JPY
            case 3:
                this.resultado = (valor*8.48);
                return this.resultado;
            //MXN a KRW
            case 4:
                this.resultado = (valor*76.47);
                return this.resultado;
            //USD a MXN
            case 5:
                this.resultado = (valor*17.06);
                return this.resultado;
            //EUR a MXN
            case 6:
                this.resultado = (valor*18.62);
                return this.resultado;
            //GBP a MXN
            case 7:
                this.resultado = (valor*21.65);
                return this.resultado;
            //JPY a MXN
            case 8:
                this.resultado = (valor*0.013);
                return this.resultado;
            //KRW a MXN
            case 9:
                this.resultado = (valor*0.12);
                return this.resultado;
        }

        return this.resultado;
    }

    @Override
    public boolean validar(String inputValue) {
        try {
            double valor = Double.parseDouble(this.inputValue);
            return valor >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void menuMoneda(Object selectedValue) {
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

        // Crear un mapa para mapear las conversiones de moneda
        Map<Integer, String> conversionesMoneda = new HashMap<>();
        conversionesMoneda.put(0, "MXN a USD");
        conversionesMoneda.put(1, "MXN a EUR");
        conversionesMoneda.put(2, "MXN a GBP");
        conversionesMoneda.put(3, "MXN a JPY");
        conversionesMoneda.put(4, "MXN a KRW");
        conversionesMoneda.put(5, "USD a MXN");
        conversionesMoneda.put(6, "EUR a MXN");
        conversionesMoneda.put(7, "GBP a MXN");
        conversionesMoneda.put(8, "JPY a MXN");
        conversionesMoneda.put(9, "KRW a MXN");

        // Obtener el valor seleccionado
        selectedValue = JOptionPane.showInputDialog(null, "Seleccione la moneda a la cual desea convertir", "Menú",
                JOptionPane.INFORMATION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]).toString();

        // Verificar si el valor seleccionado está en el mapa de conversiones
        int indiceMoneda = -1;
        for (Map.Entry<Integer, String> entry : conversionesMoneda.entrySet()) {
            if (entry.getValue().equals(selectedValue)) {
                indiceMoneda = entry.getKey();
                break;
            }
        }

        if (indiceMoneda != -1) {
            String monedaDestino = ((String) selectedValue).split(" a ")[1];
            JOptionPane.showMessageDialog(null, "Tienes $" + this.convertir(indiceMoneda, valor) + " " + monedaDestino, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }

        this.menuContinuar();
    }
}