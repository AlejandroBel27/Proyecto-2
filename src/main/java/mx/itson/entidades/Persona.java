/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.entidades;

import java.util.Date;

/**
 *
 * @author Equipo3
 */
public class Persona {
    private String rfc;
    private String nombre;
    private Date fechaNacimiento;
    private int telefono;

    public Persona() {
    }

    public Persona(String rfc, String nombre, Date fechaNacimiento, int telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
