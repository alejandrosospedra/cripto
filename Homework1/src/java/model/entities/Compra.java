package model.entities;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Compra_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Compra_Gen") 
    Long id;
    private Date fecha_compra;
    private float monto_pagado;
    private float cantidad;
    
    @ManyToOne
    @JoinColumn(name="CRIPTO_ID")
    private Criptomoneda cripto;
    
    @ManyToOne  
    @JoinColumn(name="USER_ID") 
    private Usuario usuario;

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Criptomoneda getCripto() {
        return cripto;
    }

    public void setCripto(Criptomoneda cripto) {
        this.cripto = cripto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
    
    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public float getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(float monto_pagado) {
        this.monto_pagado = monto_pagado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Compra{" + "id=" + id + ", fecha_compra=" + fecha_compra + ", monto_pagado=" + monto_pagado + ", cantidad=" + cantidad + ", cripto=" + cripto + ", usuario=" + usuario + '}';
    }


}
