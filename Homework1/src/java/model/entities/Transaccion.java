/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

import jakarta.persistence.SequenceGenerator;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Younes & Alejandro
 */
@Entity
@XmlRootElement
public class Transaccion implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Transaccion_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Transaccion_Gen") 
    private Long id;
    @Column(name="fecha_compra")
    private Date fecha_compra;    
    private float cantidad;
    private float precio;
    
    @ManyToOne
    @JoinColumn(name="CRIPTO_ID")
    private Criptomoneda cripto;

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Criptomoneda getCripto() {
        return cripto;
    }

    public void setCripto(Criptomoneda cripto) {
        this.cripto = cripto;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", fecha_compra=" + fecha_compra + ", cantidad=" + cantidad + ", precio=" + precio + ", cripto=" + cripto + '}';
    }
    
    
    
}
