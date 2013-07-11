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
@Table(name = "tabfactortari", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabfactortari.findAll", query = "SELECT t FROM Tabfactortari t"),
    @NamedQuery(name = "Tabfactortari.findByIdFtari", query = "SELECT t FROM Tabfactortari t WHERE t.idFtari = :idFtari"),
    @NamedQuery(name = "Tabfactortari.findByFactorFtari", query = "SELECT t FROM Tabfactortari t WHERE t.factorFtari = :factorFtari")})
public class Tabfactortari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FTARI")
    private Integer idFtari;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTOR_FTARI")
    private BigDecimal factorFtari;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;
    @JoinColumn(name = "ID_TTAR", referencedColumnName = "ID_TTAR")
    @ManyToOne(optional = false)
    private Tabtipotarifario idTtar;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Tabfactortari() {
    }

    public Tabfactortari(Integer idFtari) {
        this.idFtari = idFtari;
    }

    public Integer getIdFtari() {
        return idFtari;
    }

    public void setIdFtari(Integer idFtari) {
        this.idFtari = idFtari;
    }

    public BigDecimal getFactorFtari() {
        return factorFtari;
    }

    public void setFactorFtari(BigDecimal factorFtari) {
        this.factorFtari = factorFtari;
    }

    public Maetarifas getIdMtaf() {
        return idMtaf;
    }

    public void setIdMtaf(Maetarifas idMtaf) {
        this.idMtaf = idMtaf;
    }

    public Tabtipotarifario getIdTtar() {
        return idTtar;
    }

    public void setIdTtar(Tabtipotarifario idTtar) {
        this.idTtar = idTtar;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFtari != null ? idFtari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabfactortari)) {
            return false;
        }
        Tabfactortari other = (Tabfactortari) object;
        if ((this.idFtari == null && other.idFtari != null) || (this.idFtari != null && !this.idFtari.equals(other.idFtari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idFtari.toString();
    }
    
}
