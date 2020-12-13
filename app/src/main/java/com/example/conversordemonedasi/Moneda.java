package com.example.conversordemonedasi;

/**
 * Clase del modelo de datos, representa a una moneda. Tiene como propiedades el nombre y el valor.
 */
public class Moneda {
    private String nombre;
    private float valor;

    /**
     * Constructor especializado para inicializar el nombre y valor de la moneda
     * @param nombre
     * @param valor
     */
    public Moneda(String nombre, float valor){
        this.nombre=nombre;
        this.valor=valor;
    }
    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }
}
