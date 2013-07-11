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
@Table(name = "maeregistro", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeregistro.findAll", query = "SELECT m FROM Maeregistro m"),
    @NamedQuery(name = "Maeregistro.findByIdRegi", query = "SELECT m FROM Maeregistro m WHERE m.idRegi = :idRegi"),
    @NamedQuery(name = "Maeregistro.findByDeducibleRegi", query = "SELECT m FROM Maeregistro m WHERE m.deducibleRegi = :deducibleRegi"),
    @NamedQuery(name = "Maeregistro.findByCoaseguroRegi", query = "SELECT m FROM Maeregistro m WHERE m.coaseguroRegi = :coaseguroRegi"),
    @NamedQuery(name = "Maeregistro.findByCoasegfarmRegi", query = "SELECT m FROM Maeregistro m WHERE m.coasegfarmRegi = :coasegfarmRegi"),
    @NamedQuery(name = "Maeregistro.findByDscfarmRegi", query = "SELECT m FROM Maeregistro m WHERE m.dscfarmRegi = :dscfarmRegi"),
    @NamedQuery(name = "Maeregistro.findByFechaRegi", query = "SELECT m FROM Maeregistro m WHERE m.fechaRegi = :fechaRegi"),
    @NamedQuery(name = "Maeregistro.findByFechainiRegi", query = "SELECT m FROM Maeregistro m WHERE m.fechainiRegi = :fechainiRegi"),
    @NamedQuery(name = "Maeregistro.findByFechafinRegi", query = "SELECT m FROM Maeregistro m WHERE m.fechafinRegi = :fechafinRegi"),
    @NamedQuery(name = "Maeregistro.findByObservacionRegi", query = "SELECT m FROM Maeregistro m WHERE m.observacionRegi = :observacionRegi"),
    @NamedQuery(name = "Maeregistro.findByConsultaRegi", query = "SELECT m FROM Maeregistro m WHERE m.consultaRegi = :consultaRegi")})
public class Maeregistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGI")
    private Integer idRegi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEDUCIBLE_REGI")
    private BigDecimal deducibleRegi;
    @Column(name = "COASEGURO_REGI")
    private BigDecimal coaseguroRegi;
    @Column(name = "COASEGFARM_REGI")
    private BigDecimal coasegfarmRegi;
    @Column(name = "DSCFARM_REGI")
    private BigDecimal dscfarmRegi;
    @Column(name = "FECHA_REGI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegi;
    @Column(name = "FECHAINI_REGI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiRegi;
    @Column(name = "FECHAFIN_REGI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinRegi;
    @Size(max = 100)
    @Column(name = "OBSERVACION_REGI")
    private String observacionRegi;
    @Column(name = "CONSULTA_REGI")
    private BigDecimal consultaRegi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegi")
    private Collection<Maeordenaten> maeordenatenCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne
    private Tabestado idTest;
    @JoinColumn(name = "ID_ESTR", referencedColumnName = "ID_ESTR")
    @ManyToOne(optional = false)
    private Tabestaregistro idEstr;
    @JoinColumn(name = "ID_COBE", referencedColumnName = "ID_COBE")
    @ManyToOne(optional = false)
    private Tabcobertura idCobe;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;
    @JoinColumn(name = "ID_PLAN", referencedColumnName = "ID_PLAN")
    @ManyToOne(optional = false)
    private Maeplanes idPlan;
    @JoinColumn(name = "ID_PACI", referencedColumnName = "ID_PACI")
    @ManyToOne(optional = false)
    private Maepaciente idPaci;
    @JoinColumn(name = "ID_TATE", referencedColumnName = "ID_TATE")
    @ManyToOne(optional = false)
    private Tabtipoatencion idTate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegi")
    private Collection<Dethoteleria> dethoteleriaCollection;

    public Maeregistro() {
    }

    public Maeregistro(Integer idRegi) {
        this.idRegi = idRegi;
    }

    public Integer getIdRegi() {
        return idRegi;
    }

    public void setIdRegi(Integer idRegi) {
        this.idRegi = idRegi;
    }

    public BigDecimal getDeducibleRegi() {
        return deducibleRegi;
    }

    public void setDeducibleRegi(BigDecimal deducibleRegi) {
        this.deducibleRegi = deducibleRegi;
    }

    public BigDecimal getCoaseguroRegi() {
        return coaseguroRegi;
    }

    public void setCoaseguroRegi(BigDecimal coaseguroRegi) {
        this.coaseguroRegi = coaseguroRegi;
    }

    public BigDecimal getCoasegfarmRegi() {
        return coasegfarmRegi;
    }

    public void setCoasegfarmRegi(BigDecimal coasegfarmRegi) {
        this.coasegfarmRegi = coasegfarmRegi;
    }

    public BigDecimal getDscfarmRegi() {
        return dscfarmRegi;
    }

    public void setDscfarmRegi(BigDecimal dscfarmRegi) {
        this.dscfarmRegi = dscfarmRegi;
    }

    public Date getFechaRegi() {
        return fechaRegi;
    }

    public void setFechaRegi(Date fechaRegi) {
        this.fechaRegi = fechaRegi;
    }

    public Date getFechainiRegi() {
        return fechainiRegi;
    }

    public void setFechainiRegi(Date fechainiRegi) {
        this.fechainiRegi = fechainiRegi;
    }

    public Date getFechafinRegi() {
        return fechafinRegi;
    }

    public void setFechafinRegi(Date fechafinRegi) {
        this.fechafinRegi = fechafinRegi;
    }

    public String getObservacionRegi() {
        return observacionRegi;
    }

    public void setObservacionRegi(String observacionRegi) {
        this.observacionRegi = observacionRegi;
    }

    public BigDecimal getConsultaRegi() {
        return consultaRegi;
    }

    public void setConsultaRegi(BigDecimal consultaRegi) {
        this.consultaRegi = consultaRegi;
    }

    @XmlTransient
    public Collection<Maeordenaten> getMaeordenatenCollection() {
        return maeordenatenCollection;
    }

    public void setMaeordenatenCollection(Collection<Maeordenaten> maeordenatenCollection) {
        this.maeordenatenCollection = maeordenatenCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabestaregistro getIdEstr() {
        return idEstr;
    }

    public void setIdEstr(Tabestaregistro idEstr) {
        this.idEstr = idEstr;
    }

    public Tabcobertura getIdCobe() {
        return idCobe;
    }

    public void setIdCobe(Tabcobertura idCobe) {
        this.idCobe = idCobe;
    }

    public Maetarifas getIdMtaf() {
        return idMtaf;
    }

    public void setIdMtaf(Maetarifas idMtaf) {
        this.idMtaf = idMtaf;
    }

    public Maeplanes getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Maeplanes idPlan) {
        this.idPlan = idPlan;
    }

    public Maepaciente getIdPaci() {
        return idPaci;
    }

    public void setIdPaci(Maepaciente idPaci) {
        this.idPaci = idPaci;
    }

    public Tabtipoatencion getIdTate() {
        return idTate;
    }

    public void setIdTate(Tabtipoatencion idTate) {
        this.idTate = idTate;
    }

    @XmlTransient
    public Collection<Dethoteleria> getDethoteleriaCollection() {
        return dethoteleriaCollection;
    }

    public void setDethoteleriaCollection(Collection<Dethoteleria> dethoteleriaCollection) {
        this.dethoteleriaCollection = dethoteleriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegi != null ? idRegi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeregistro)) {
            return false;
        }
        Maeregistro other = (Maeregistro) object;
        if ((this.idRegi == null && other.idRegi != null) || (this.idRegi != null && !this.idRegi.equals(other.idRegi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRegi.toString();
    }
    
}
