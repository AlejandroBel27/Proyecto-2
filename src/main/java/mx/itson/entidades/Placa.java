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

public class Placa {
    
    private String numeroPlaca;
    
    private String tipoTramite;
    
    private Date fechaEmision;
    
    private Date fechaRecepcion;
    
    private String costoPlacas;

    public Placa() {
    }

    public Placa(String numeroPlaca, String tipoTramite, Date fechaEmision, Date fechaRecepcion, String costoPlacas) {
        this.numeroPlaca = numeroPlaca;
        this.tipoTramite = tipoTramite;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costoPlacas = costoPlacas;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getCostoPlacas() {
        return costoPlacas;
    }

    public void setCostoPlacas(String costoPlacas) {
        this.costoPlacas = costoPlacas;
    }
    
    
}
