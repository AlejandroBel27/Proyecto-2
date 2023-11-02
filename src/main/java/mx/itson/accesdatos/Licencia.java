/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.accesdatos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cocob
 */
@Entity
@Table(name = "licencia")
@NamedQueries({
    @NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l"),
    @NamedQuery(name = "Licencia.findByIdLicencia", query = "SELECT l FROM Licencia l WHERE l.idLicencia = :idLicencia"),
    @NamedQuery(name = "Licencia.findByTipoLicencia", query = "SELECT l FROM Licencia l WHERE l.tipoLicencia = :tipoLicencia"),
    @NamedQuery(name = "Licencia.findByVigencia", query = "SELECT l FROM Licencia l WHERE l.vigencia = :vigencia"),
    @NamedQuery(name = "Licencia.findByFechaExpedicion", query = "SELECT l FROM Licencia l WHERE l.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Licencia.findByCostoLicencia", query = "SELECT l FROM Licencia l WHERE l.costoLicencia = :costoLicencia")})
public class Licencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLicencia")
    private String idLicencia;
    @Basic(optional = false)
    @Column(name = "tipoLicencia")
    private String tipoLicencia;
    @Basic(optional = false)
    @Column(name = "vigencia")
    private String vigencia;
    @Basic(optional = false)
    @Column(name = "fechaExpedicion")
    private String fechaExpedicion;
    @Basic(optional = false)
    @Column(name = "costoLicencia")
    private String costoLicencia;
    @JoinColumn(name = "RFC", referencedColumnName = "RFC")
    @ManyToOne(optional = false)
    private Persona rfc;

    public Licencia() {
    }

    public Licencia(String idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Licencia(String idLicencia, String tipoLicencia, String vigencia, String fechaExpedicion, String costoLicencia) {
        this.idLicencia = idLicencia;
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

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getCostoLicencia() {
        return costoLicencia;
    }

    public void setCostoLicencia(String costoLicencia) {
        this.costoLicencia = costoLicencia;
    }

    public Persona getRfc() {
        return rfc;
    }

    public void setRfc(Persona rfc) {
        this.rfc = rfc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.idLicencia == null && other.idLicencia != null) || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.itson.accesorios.Licencia[ idLicencia=" + idLicencia + " ]";
    }
    
}
