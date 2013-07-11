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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "tabpreciocmed", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabpreciocmed.findAll", query = "SELECT t FROM Tabpreciocmed t"),
    @NamedQuery(name = "Tabpreciocmed.findByIdPrcme", query = "SELECT t FROM Tabpreciocmed t WHERE t.idPrcme = :idPrcme"),
    @NamedQuery(name = "Tabpreciocmed.findByPrecioPrcme", query = "SELECT t FROM Tabpreciocmed t WHERE t.precioPrcme = :precioPrcme")})
public class Tabpreciocmed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRCME")
    private Integer idPrcme;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRCME")
    private BigDecimal precioPrcme;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;
    @JoinColumn(name = "ID_CMED", referencedColumnName = "ID_CMED")
    @ManyToOne(optional = false)
    private Maeciamedica idCmed;

    public Tabpreciocmed() {
    }

    public Tabpreciocmed(Integer idPrcme) {
        this.idPrcme = idPrcme;
    }

    public Integer getIdPrcme() {
        return idPrcme;
    }

    public void setIdPrcme(Integer idPrcme) {
        this.idPrcme = idPrcme;
    }

    public BigDecimal getPrecioPrcme() {
        return precioPrcme;
    }

    public void setPrecioPrcme(BigDecimal precioPrcme) {
        this.precioPrcme = precioPrcme;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maetarifario getIdMtar() {
        return idMtar;
    }

    public void setIdMtar(Maetarifario idMtar) {
        this.idMtar = idMtar;
    }

    public Maetarifas getIdMtaf() {
        return idMtaf;
    }

    public void setIdMtaf(Maetarifas idMtaf) {
        this.idMtaf = idMtaf;
    }

    public Maeciamedica getIdCmed() {
        return idCmed;
    }

    public void setIdCmed(Maeciamedica idCmed) {
        this.idCmed = idCmed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrcme != null ? idPrcme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabpreciocmed)) {
            return false;
        }
        Tabpreciocmed other = (Tabpreciocmed) object;
        if ((this.idPrcme == null && other.idPrcme != null) || (this.idPrcme != null && !this.idPrcme.equals(other.idPrcme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPrcme.toString();
    }
    
}
