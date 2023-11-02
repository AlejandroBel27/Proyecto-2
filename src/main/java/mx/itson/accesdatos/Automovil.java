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
 * @author Equipo 3
 */
@Entity
@Table(name = "automovil")
@NamedQueries({
    @NamedQuery(name = "Automovil.findAll", query = "SELECT a FROM Automovil a"),
    @NamedQuery(name = "Automovil.findByNumeroSeria", query = "SELECT a FROM Automovil a WHERE a.numeroSeria = :numeroSeria"),
    @NamedQuery(name = "Automovil.findByMarca", query = "SELECT a FROM Automovil a WHERE a.marca = :marca"),
    @NamedQuery(name = "Automovil.findByLinea", query = "SELECT a FROM Automovil a WHERE a.linea = :linea"),
    @NamedQuery(name = "Automovil.findByColor", query = "SELECT a FROM Automovil a WHERE a.color = :color"),
    @NamedQuery(name = "Automovil.findByModelo", query = "SELECT a FROM Automovil a WHERE a.modelo = :modelo")})
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroSeria")
    private String numeroSeria;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "linea")
    private String linea;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "numeroPlaca", referencedColumnName = "numeroPlaca")
    @ManyToOne
    private Placas numeroPlaca;

    public Automovil() {
    }

    public Automovil(String numeroSeria) {
        this.numeroSeria = numeroSeria;
    }

    public Automovil(String numeroSeria, String marca, String linea, String color, String modelo) {
        this.numeroSeria = numeroSeria;
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

    public Placas getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(Placas numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSeria != null ? numeroSeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.numeroSeria == null && other.numeroSeria != null) || (this.numeroSeria != null && !this.numeroSeria.equals(other.numeroSeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.itson.accesorios.Automovil[ numeroSeria=" + numeroSeria + " ]";
    }
    
}
