/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "tabcobertura", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabcobertura.findAll", query = "SELECT t FROM Tabcobertura t"),
    @NamedQuery(name = "Tabcobertura.findByIdCobe", query = "SELECT t FROM Tabcobertura t WHERE t.idCobe = :idCobe"),
    @NamedQuery(name = "Tabcobertura.findByConsultaCobe", query = "SELECT t FROM Tabcobertura t WHERE t.consultaCobe = :consultaCobe"),
    @NamedQuery(name = "Tabcobertura.findByDeducibleCobe", query = "SELECT t FROM Tabcobertura t WHERE t.deducibleCobe = :deducibleCobe"),
    @NamedQuery(name = "Tabcobertura.findByCoaseguroCobe", query = "SELECT t FROM Tabcobertura t WHERE t.coaseguroCobe = :coaseguroCobe"),
    @NamedQuery(name = "Tabcobertura.findByCoasegfarmCobe", query = "SELECT t FROM Tabcobertura t WHERE t.coasegfarmCobe = :coasegfarmCobe"),
    @NamedQuery(name = "Tabcobertura.findByDscfarmCobe", query = "SELECT t FROM Tabcobertura t WHERE t.dscfarmCobe = :dscfarmCobe"),
    @NamedQuery(name = "Tabcobertura.findByDiasvigenciaCobe", query = "SELECT t FROM Tabcobertura t WHERE t.diasvigenciaCobe = :diasvigenciaCobe"),
    @NamedQuery(name = "Tabcobertura.findByFlgvigconsultaCobe", query = "SELECT t FROM Tabcobertura t WHERE t.flgvigconsultaCobe = :flgvigconsultaCobe")})
public class Tabcobertura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COBE")
    private Integer idCobe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CONSULTA_COBE")
    private BigDecimal consultaCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEDUCIBLE_COBE")
    private BigDecimal deducibleCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COASEGURO_COBE")
    private BigDecimal coaseguroCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COASEGFARM_COBE")
    private BigDecimal coasegfarmCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DSCFARM_COBE")
    private BigDecimal dscfarmCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIASVIGENCIA_COBE")
    private int diasvigenciaCobe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLGVIGCONSULTA_COBE")
    private boolean flgvigconsultaCobe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCobe")
    private Collection<Maeregistro> maeregistroCollection;
    @JoinColumn(name = "ID_TATE", referencedColumnName = "ID_TATE")
    @ManyToOne(optional = false)
    private Tabtipoatencion idTate;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_MONE", referencedColumnName = "ID_MONE")
    @ManyToOne(optional = false)
    private Tabmoneda idMone;
    @JoinColumn(name = "IDCONSUL_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idconsulMtar;
    @JoinColumn(name = "ID_PLAN", referencedColumnName = "ID_PLAN")
    @ManyToOne(optional = false)
    private Maeplanes idPlan;

    public Tabcobertura() {
    }

    public Tabcobertura(Integer idCobe) {
        this.idCobe = idCobe;
    }

    public Tabcobertura(Integer idCobe, BigDecimal deducibleCobe, BigDecimal coaseguroCobe, BigDecimal coasegfarmCobe, BigDecimal dscfarmCobe, int diasvigenciaCobe, boolean flgvigconsultaCobe) {
        this.idCobe = idCobe;
        this.deducibleCobe = deducibleCobe;
        this.coaseguroCobe = coaseguroCobe;
        this.coasegfarmCobe = coasegfarmCobe;
        this.dscfarmCobe = dscfarmCobe;
        this.diasvigenciaCobe = diasvigenciaCobe;
        this.flgvigconsultaCobe = flgvigconsultaCobe;
    }

    public Integer getIdCobe() {
        return idCobe;
    }

    public void setIdCobe(Integer idCobe) {
        this.idCobe = idCobe;
    }

    public BigDecimal getConsultaCobe() {
        return consultaCobe;
    }

    public void setConsultaCobe(BigDecimal consultaCobe) {
        this.consultaCobe = consultaCobe;
    }

    public BigDecimal getDeducibleCobe() {
        return deducibleCobe;
    }

    public void setDeducibleCobe(BigDecimal deducibleCobe) {
        this.deducibleCobe = deducibleCobe;
    }

    public BigDecimal getCoaseguroCobe() {
        return coaseguroCobe;
    }

    public void setCoaseguroCobe(BigDecimal coaseguroCobe) {
        this.coaseguroCobe = coaseguroCobe;
    }

    public BigDecimal getCoasegfarmCobe() {
        return coasegfarmCobe;
    }

    public void setCoasegfarmCobe(BigDecimal coasegfarmCobe) {
        this.coasegfarmCobe = coasegfarmCobe;
    }

    public BigDecimal getDscfarmCobe() {
        return dscfarmCobe;
    }

    public void setDscfarmCobe(BigDecimal dscfarmCobe) {
        this.dscfarmCobe = dscfarmCobe;
    }

    public int getDiasvigenciaCobe() {
        return diasvigenciaCobe;
    }

    public void setDiasvigenciaCobe(int diasvigenciaCobe) {
        this.diasvigenciaCobe = diasvigenciaCobe;
    }

    public boolean getFlgvigconsultaCobe() {
        return flgvigconsultaCobe;
    }

    public void setFlgvigconsultaCobe(boolean flgvigconsultaCobe) {
        this.flgvigconsultaCobe = flgvigconsultaCobe;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    public Tabtipoatencion getIdTate() {
        return idTate;
    }

    public void setIdTate(Tabtipoatencion idTate) {
        this.idTate = idTate;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabmoneda getIdMone() {
        return idMone;
    }

    public void setIdMone(Tabmoneda idMone) {
        this.idMone = idMone;
    }

    public Maetarifario getIdconsulMtar() {
        return idconsulMtar;
    }

    public void setIdconsulMtar(Maetarifario idconsulMtar) {
        this.idconsulMtar = idconsulMtar;
    }

    public Maeplanes getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Maeplanes idPlan) {
        this.idPlan = idPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobe != null ? idCobe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabcobertura)) {
            return false;
        }
        Tabcobertura other = (Tabcobertura) object;
        if ((this.idCobe == null && other.idCobe != null) || (this.idCobe != null && !this.idCobe.equals(other.idCobe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCobe.toString();
    }
    
}
