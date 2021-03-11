package com.example.pruebascodigo;

public class Valor {

    private double valor1, valor2;

    public Valor(){}

    public Valor(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    @Override
    public String toString() {
        return "Valor{" +
                "valor1=" + valor1 +
                ", valor2=" + valor2 +
                '}';
    }
}
