package model.entities;

import jakarta.persistence.Embedded;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Younes & Alejandro
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Criptomoneda.findAllOrderByPriceASC",
            query="SELECT c FROM Criptomoneda c ORDER BY c.ultima_cotizacion ASC"),
    @NamedQuery(name="Criptomoneda.findAllOrderByPriceDESC",
            query="SELECT c FROM Criptomoneda c ORDER BY c.ultima_cotizacion DESC"),
    @NamedQuery(name = "Criptomoneda.findByIdWithLastTransaction",
            query = "SELECT c, t.precio "
                    + "FROM Criptomoneda c "
                    + "LEFT JOIN Transaccion t " 
                    + "WHERE c.id = :criptoId "
                    + "AND t.cripto.id = :criptoId "
                    + "ORDER BY t.fecha_compra DESC")

    })
public class Criptomoneda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Cripto_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cripto_Gen") 
    private Long id;
        
    private String nombre;
    
    private String descripcion;
    
    @Embedded
    private UltimaCotizacion ultima_cotizacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UltimaCotizacion getUltima_cotizacion() {
        return ultima_cotizacion;
    }

    public void setUltima_cotizacion(UltimaCotizacion ultima_cotizacion) {
        this.ultima_cotizacion = ultima_cotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Criptomoneda)) {
            return false;
        }
        Criptomoneda other = (Criptomoneda) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Criptomoneda{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ultima_cotizacion=" + ultima_cotizacion + '}';
    }
    
}
