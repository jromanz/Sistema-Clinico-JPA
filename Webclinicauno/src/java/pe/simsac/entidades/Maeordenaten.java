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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeordenaten", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeordenaten.findAll", query = "SELECT m FROM Maeordenaten m"),
    @NamedQuery(name = "Maeordenaten.findByIdOrda", query = "SELECT m FROM Maeordenaten m WHERE m.idOrda = :idOrda"),
    @NamedQuery(name = "Maeordenaten.findByFechaOrda", query = "SELECT m FROM Maeordenaten m WHERE m.fechaOrda = :fechaOrda"),
    @NamedQuery(name = "Maeordenaten.findByConsultaOrda", query = "SELECT m FROM Maeordenaten m WHERE m.consultaOrda = :consultaOrda"),
    @NamedQuery(name = "Maeordenaten.findByDeducibleOrda", query = "SELECT m FROM Maeordenaten m WHERE m.deducibleOrda = :deducibleOrda"),
    @NamedQuery(name = "Maeordenaten.findByFlgcargaconsumoOrda", query = "SELECT m FROM Maeordenaten m WHERE m.flgcargaconsumoOrda = :flgcargaconsumoOrda"),
    @NamedQuery(name = "Maeordenaten.findByFlgcargahonorarioOrda", query = "SELECT m FROM Maeordenaten m WHERE m.flgcargahonorarioOrda = :flgcargahonorarioOrda")})
public class Maeordenaten implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDA")
    private Integer idOrda;
    @Column(name = "FECHA_ORDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CONSULTA_ORDA")
    private BigDecimal consultaOrda;
    @Column(name = "DEDUCIBLE_ORDA")
    private BigDecimal deducibleOrda;
    @Column(name = "FLGCARGACONSUMO_ORDA")
    private Integer flgcargaconsumoOrda;
    @Column(name = "FLGCARGAHONORARIO_ORDA")
    private Integer flgcargahonorarioOrda;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne
    private Tabestado idTest;
    @JoinColumn(name = "ID_MMED", referencedColumnName = "ID_MMED")
    @ManyToOne(optional = false)
    private Maemedicos idMmed;
    @JoinColumn(name = "ID_REGI", referencedColumnName = "ID_REGI")
    @ManyToOne(optional = false)
    private Maeregistro idRegi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrda")
    private Collection<Maeordenserv> maeordenservCollection;

    public Maeordenaten() {
    }

    public Maeordenaten(Integer idOrda) {
        this.idOrda = idOrda;
    }

    public Integer getIdOrda() {
        return idOrda;
    }

    public void setIdOrda(Integer idOrda) {
        this.idOrda = idOrda;
    }

    public Date getFechaOrda() {
        return fechaOrda;
    }

    public void setFechaOrda(Date fechaOrda) {
        this.fechaOrda = fechaOrda;
    }

    public BigDecimal getConsultaOrda() {
        return consultaOrda;
    }

    public void setConsultaOrda(BigDecimal consultaOrda) {
        this.consultaOrda = consultaOrda;
    }

    public BigDecimal getDeducibleOrda() {
        return deducibleOrda;
    }

    public void setDeducibleOrda(BigDecimal deducibleOrda) {
        this.deducibleOrda = deducibleOrda;
    }

    public Integer getFlgcargaconsumoOrda() {
        return flgcargaconsumoOrda;
    }

    public void setFlgcargaconsumoOrda(Integer flgcargaconsumoOrda) {
        this.flgcargaconsumoOrda = flgcargaconsumoOrda;
    }

    public Integer getFlgcargahonorarioOrda() {
        return flgcargahonorarioOrda;
    }

    public void setFlgcargahonorarioOrda(Integer flgcargahonorarioOrda) {
        this.flgcargahonorarioOrda = flgcargahonorarioOrda;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maemedicos getIdMmed() {
        return idMmed;
    }

    public void setIdMmed(Maemedicos idMmed) {
        this.idMmed = idMmed;
    }

    public Maeregistro getIdRegi() {
        return idRegi;
    }

    public void setIdRegi(Maeregistro idRegi) {
        this.idRegi = idRegi;
    }

    @XmlTransient
    public Collection<Maeordenserv> getMaeordenservCollection() {
        return maeordenservCollection;
    }

    public void setMaeordenservCollection(Collection<Maeordenserv> maeordenservCollection) {
        this.maeordenservCollection = maeordenservCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrda != null ? idOrda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeordenaten)) {
            return false;
        }
        Maeordenaten other = (Maeordenaten) object;
        if ((this.idOrda == null && other.idOrda != null) || (this.idOrda != null && !this.idOrda.equals(other.idOrda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOrda.toString();
    }
    
}
