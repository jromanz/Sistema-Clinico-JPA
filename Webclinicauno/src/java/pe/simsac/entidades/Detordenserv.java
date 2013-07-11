/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "detordenserv", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detordenserv.findAll", query = "SELECT d FROM Detordenserv d"),
    @NamedQuery(name = "Detordenserv.findByIdDors", query = "SELECT d FROM Detordenserv d WHERE d.idDors = :idDors"),
    @NamedQuery(name = "Detordenserv.findByCantidadDors", query = "SELECT d FROM Detordenserv d WHERE d.cantidadDors = :cantidadDors"),
    @NamedQuery(name = "Detordenserv.findByPreciobaseOrds", query = "SELECT d FROM Detordenserv d WHERE d.preciobaseOrds = :preciobaseOrds"),
    @NamedQuery(name = "Detordenserv.findByDescuentoOrds", query = "SELECT d FROM Detordenserv d WHERE d.descuentoOrds = :descuentoOrds"),
    @NamedQuery(name = "Detordenserv.findByPrecioOrds", query = "SELECT d FROM Detordenserv d WHERE d.precioOrds = :precioOrds")})
public class Detordenserv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DORS")
    private Integer idDors;
    @Column(name = "CANTIDAD_DORS")
    private Integer cantidadDors;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOBASE_ORDS")
    private BigDecimal preciobaseOrds;
    @Column(name = "DESCUENTO_ORDS")
    private BigDecimal descuentoOrds;
    @Column(name = "PRECIO_ORDS")
    private BigDecimal precioOrds;
    @JoinColumn(name = "ID_ORDS", referencedColumnName = "ID_ORDS")
    @ManyToOne(optional = false)
    private Maeordenserv idOrds;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;

    public Detordenserv() {
    }

    public Detordenserv(Integer idDors) {
        this.idDors = idDors;
    }

    public Integer getIdDors() {
        return idDors;
    }

    public void setIdDors(Integer idDors) {
        this.idDors = idDors;
    }

    public Integer getCantidadDors() {
        return cantidadDors;
    }

    public void setCantidadDors(Integer cantidadDors) {
        this.cantidadDors = cantidadDors;
    }

    public BigDecimal getPreciobaseOrds() {
        return preciobaseOrds;
    }

    public void setPreciobaseOrds(BigDecimal preciobaseOrds) {
        this.preciobaseOrds = preciobaseOrds;
    }

    public BigDecimal getDescuentoOrds() {
        return descuentoOrds;
    }

    public void setDescuentoOrds(BigDecimal descuentoOrds) {
        this.descuentoOrds = descuentoOrds;
    }

    public BigDecimal getPrecioOrds() {
        return precioOrds;
    }

    public void setPrecioOrds(BigDecimal precioOrds) {
        this.precioOrds = precioOrds;
    }

    public Maeordenserv getIdOrds() {
        return idOrds;
    }

    public void setIdOrds(Maeordenserv idOrds) {
        this.idOrds = idOrds;
    }

    public Maetarifario getIdMtar() {
        return idMtar;
    }

    public void setIdMtar(Maetarifario idMtar) {
        this.idMtar = idMtar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDors != null ? idDors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detordenserv)) {
            return false;
        }
        Detordenserv other = (Detordenserv) object;
        if ((this.idDors == null && other.idDors != null) || (this.idDors != null && !this.idDors.equals(other.idDors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idDors.toString();
    }
    
}
