package com.project;

public class Vertice_Vizinho {

        private float valor_peso;
    private String valor_vertice;

    public float getValor_peso() {
        return valor_peso;
    }

    public String getValor_vertice() {
        return valor_vertice;
    }

    public void setValor_peso(float valor_peso) {
        this.valor_peso = valor_peso;
    }

    public void setValor_vertice(String valor_vertice) {
        this.valor_vertice = valor_vertice;
    }

    public String toString() {
        return "[Vertice Vizinho = " + valor_vertice + " Peso da Aresta = " + valor_peso + "]";
    }

    public Vertice_Vizinho(float valor_peso, String valor_vertice) {
        this.valor_peso = valor_peso;
        this.valor_vertice = valor_vertice;
    }

}