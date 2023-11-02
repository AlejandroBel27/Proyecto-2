/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.accesdatos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo 3
 */
@Entity
@Table(name = "placas")
@NamedQueries({
    @NamedQuery(name = "Placas.findAll", query = "SELECT p FROM Placas p"),
    @NamedQuery(name = "Placas.findByNumeroPlaca", query = "SELECT p FROM Placas p WHERE p.numeroPlaca = :numeroPlaca"),
    @NamedQuery(name = "Placas.findByTipoTramite", query = "SELECT p FROM Placas p WHERE p.tipoTramite = :tipoTramite"),
    @NamedQuery(name = "Placas.findByFechaEmision", query = "SELECT p FROM Placas p WHERE p.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Placas.findByFechaRecepcion", query = "SELECT p FROM Placas p WHERE p.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Placas.findByCosto", query = "SELECT p FROM Placas p WHERE p.costo = :costo"),
    @NamedQuery(name = "Placas.findByRfc", query = "SELECT p FROM Placas p WHERE p.rfc = :rfc")})
public class Placas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroPlaca")
    private String numeroPlaca;
    @Basic(optional = false)
    @Column(name = "tipoTramite")
    private String tipoTramite;
    @Basic(optional = false)
    @Column(name = "fechaEmision")
    private String fechaEmision;
    @Basic(optional = false)
    @Column(name = "fechaRecepcion")
    private String fechaRecepcion;
    @Basic(optional = false)
    @Column(name = "costo")
    private String costo;
    @Basic(optional = false)
    @Column(name = "RFC")
    private String rfc;
    @OneToMany(mappedBy = "numeroPlaca")
    private Collection<Automovil> automovilCollection;

    public Placas() {
    }

    public Placas(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Placas(String numeroPlaca, String tipoTramite, String fechaEmision, String fechaRecepcion, String costo, String rfc) {
        this.numeroPlaca = numeroPlaca;
        this.tipoTramite = tipoTramite;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.rfc = rfc;
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

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Collection<Automovil> getAutomovilCollection() {
        return automovilCollection;
    }

    public void setAutomovilCollection(Collection<Automovil> automovilCollection) {
        this.automovilCollection = automovilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPlaca != null ? numeroPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placas)) {
            return false;
        }
        Placas other = (Placas) object;
        if ((this.numeroPlaca == null && other.numeroPlaca != null) || (this.numeroPlaca != null && !this.numeroPlaca.equals(other.numeroPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.itson.accesorios.Placas[ numeroPlaca=" + numeroPlaca + " ]";
    }
    
}
