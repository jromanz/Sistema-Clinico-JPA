/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeordenserv", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeordenserv.findAll", query = "SELECT m FROM Maeordenserv m"),
    @NamedQuery(name = "Maeordenserv.findByIdOrds", query = "SELECT m FROM Maeordenserv m WHERE m.idOrds = :idOrds"),
    @NamedQuery(name = "Maeordenserv.findByFechaOrds", query = "SELECT m FROM Maeordenserv m WHERE m.fechaOrds = :fechaOrds"),
    @NamedQuery(name = "Maeordenserv.findByCoaseguroOrds", query = "SELECT m FROM Maeordenserv m WHERE m.coaseguroOrds = :coaseguroOrds"),
    @NamedQuery(name = "Maeordenserv.findByTotalOrds", query = "SELECT m FROM Maeordenserv m WHERE m.totalOrds = :totalOrds"),
    @NamedQuery(name = "Maeordenserv.findByDescuentoOrds", query = "SELECT m FROM Maeordenserv m WHERE m.descuentoOrds = :descuentoOrds"),
    @NamedQuery(name = "Maeordenserv.findByBaseOrds", query = "SELECT m FROM Maeordenserv m WHERE m.baseOrds = :baseOrds"),
    @NamedQuery(name = "Maeordenserv.findByFlgcargaconsumoOrds", query = "SELECT m FROM Maeordenserv m WHERE m.flgcargaconsumoOrds = :flgcargaconsumoOrds"),
    @NamedQuery(name = "Maeordenserv.findByFlgcargahonorarioOrds", query = "SELECT m FROM Maeordenserv m WHERE m.flgcargahonorarioOrds = :flgcargahonorarioOrds"),
    @NamedQuery(name = "Maeordenserv.findByCodigoOrda", query = "SELECT m FROM Maeordenserv m WHERE m.codigoOrda = :codigoOrda")})
public class Maeordenserv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDS")
    private Integer idOrds;
    @Column(name = "FECHA_ORDS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrds;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COASEGURO_ORDS")
    private BigDecimal coaseguroOrds;
    @Column(name = "TOTAL_ORDS")
    private BigDecimal totalOrds;
    @Column(name = "DESCUENTO_ORDS")
    private BigDecimal descuentoOrds;
    @Column(name = "BASE_ORDS")
    private BigDecimal baseOrds;
    @Column(name = "FLGCARGACONSUMO_ORDS")
    private Integer flgcargaconsumoOrds;
    @Column(name = "FLGCARGAHONORARIO_ORDS")
    private Integer flgcargahonorarioOrds;
    @Size(max = 20)
    @Column(name = "CODIGO_ORDA")
    private String codigoOrda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrds")
    private Collection<Detordenserv> detordenservCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne
    private Tabestado idTest;
    @JoinColumn(name = "ID_SERV", referencedColumnName = "ID_SERV")
    @ManyToOne(optional = false)
    private Tabservicio idServ;
    @JoinColumn(name = "ID_ORDA", referencedColumnName = "ID_ORDA")
    @ManyToOne(optional = false)
    private Maeordenaten idOrda;

    public Maeordenserv() {
    }

    public Maeordenserv(Integer idOrds) {
        this.idOrds = idOrds;
    }

    public Integer getIdOrds() {
        return idOrds;
    }

    public void setIdOrds(Integer idOrds) {
        this.idOrds = idOrds;
    }

    public Date getFechaOrds() {
        return fechaOrds;
    }

    public void setFechaOrds(Date fechaOrds) {
        this.fechaOrds = fechaOrds;
    }

    public BigDecimal getCoaseguroOrds() {
        return coaseguroOrds;
    }

    public void setCoaseguroOrds(BigDecimal coaseguroOrds) {
        this.coaseguroOrds = coaseguroOrds;
    }

    public BigDecimal getTotalOrds() {
        return totalOrds;
    }

    public void setTotalOrds(BigDecimal totalOrds) {
        this.totalOrds = totalOrds;
    }

    public BigDecimal getDescuentoOrds() {
        return descuentoOrds;
    }

    public void setDescuentoOrds(BigDecimal descuentoOrds) {
        this.descuentoOrds = descuentoOrds;
    }

    public BigDecimal getBaseOrds() {
        return baseOrds;
    }

    public void setBaseOrds(BigDecimal baseOrds) {
        this.baseOrds = baseOrds;
    }

    public Integer getFlgcargaconsumoOrds() {
        return flgcargaconsumoOrds;
    }

    public void setFlgcargaconsumoOrds(Integer flgcargaconsumoOrds) {
        this.flgcargaconsumoOrds = flgcargaconsumoOrds;
    }

    public Integer getFlgcargahonorarioOrds() {
        return flgcargahonorarioOrds;
    }

    public void setFlgcargahonorarioOrds(Integer flgcargahonorarioOrds) {
        this.flgcargahonorarioOrds = flgcargahonorarioOrds;
    }

    public String getCodigoOrda() {
        return codigoOrda;
    }

    public void setCodigoOrda(String codigoOrda) {
        this.codigoOrda = codigoOrda;
    }

    @XmlTransient
    public Collection<Detordenserv> getDetordenservCollection() {
        return detordenservCollection;
    }

    public void setDetordenservCollection(Collection<Detordenserv> detordenservCollection) {
        this.detordenservCollection = detordenservCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabservicio getIdServ() {
        return idServ;
    }

    public void setIdServ(Tabservicio idServ) {
        this.idServ = idServ;
    }

    public Maeordenaten getIdOrda() {
        return idOrda;
    }

    public void setIdOrda(Maeordenaten idOrda) {
        this.idOrda = idOrda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrds != null ? idOrds.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeordenserv)) {
            return false;
        }
        Maeordenserv other = (Maeordenserv) object;
        if ((this.idOrds == null && other.idOrds != null) || (this.idOrds != null && !this.idOrds.equals(other.idOrds))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOrds.toString();
    }
    
}
