/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.entidades;

/**
 *
 * @author Equipo3
 */
public class Automovil {
    private String numeroSeria;
    private String numeroPlaca;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    public Automovil(){
        
    }

    public Automovil(String numeroSeria, String numeroPlaca, String marca, String linea, String color, String modelo) {
        this.numeroSeria = numeroSeria;
        this.numeroPlaca = numeroPlaca;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
    }

    public String getNumeroSeria() {
        return numeroSeria;
    }

    public void setNumeroSeria(String numeroSeria) {
        this.numeroSeria = numeroSeria;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
