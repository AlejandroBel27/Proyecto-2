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
public class Licencia {
    private String idLicencia;
    private String rfc;
    private String tipoLicencia;
    private Date vigencia;
    private Date fechaExpedicion;
    private int costoLicencia;
    
    public Licencia(){
        
    }

    public Licencia(String idLicencia, String rfc, String tipoLicencia, Date vigencia, Date fechaExpedicion, int costoLicencia) {
        this.idLicencia = idLicencia;
        this.rfc = rfc;
        this.tipoLicencia = tipoLicencia;
        this.vigencia = vigencia;
        this.fechaExpedicion = fechaExpedicion;
        this.costoLicencia = costoLicencia;
    }

    public String getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(String idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public int getCostoLicencia() {
        return costoLicencia;
    }

    public void setCostoLicencia(int costoLicencia) {
        this.costoLicencia = costoLicencia;
    }
    
}
