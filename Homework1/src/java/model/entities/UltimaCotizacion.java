/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yuones & Alejandro
 */
@Embeddable @Access(AccessType.FIELD) 
public class UltimaCotizacion implements Serializable {
    
    @Column(name="ultima_cotizacion")
    private float ultima_cotizacion;
    private Date fecha_actual;

    public float getUltima_cotizacion() {
        return ultima_cotizacion;
    }

    public void setUltima_cotizacion(float ultima_cotizacion) {
        this.ultima_cotizacion = ultima_cotizacion;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    @Override
    public String toString() {
        return "UltimaCotizacion{" + "ultima_cotizacion=" + ultima_cotizacion + ", fecha_actual=" + fecha_actual + '}';
    }
    
    
    
}
