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
@Table(name = "tabpreciotari", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabpreciotari.findAll", query = "SELECT t FROM Tabpreciotari t"),
    @NamedQuery(name = "Tabpreciotari.findByIdPrtar", query = "SELECT t FROM Tabpreciotari t WHERE t.idPrtar = :idPrtar"),
    @NamedQuery(name = "Tabpreciotari.findByPrecioPrtar", query = "SELECT t FROM Tabpreciotari t WHERE t.precioPrtar = :precioPrtar")})
public class Tabpreciotari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRTAR")
    private Integer idPrtar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRTAR")
    private BigDecimal precioPrtar;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Tabpreciotari() {
    }

    public Tabpreciotari(Integer idPrtar) {
        this.idPrtar = idPrtar;
    }

    public Integer getIdPrtar() {
        return idPrtar;
    }

    public void setIdPrtar(Integer idPrtar) {
        this.idPrtar = idPrtar;
    }

    public BigDecimal getPrecioPrtar() {
        return precioPrtar;
    }

    public void setPrecioPrtar(BigDecimal precioPrtar) {
        this.precioPrtar = precioPrtar;
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

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrtar != null ? idPrtar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabpreciotari)) {
            return false;
        }
        Tabpreciotari other = (Tabpreciotari) object;
        if ((this.idPrtar == null && other.idPrtar != null) || (this.idPrtar != null && !this.idPrtar.equals(other.idPrtar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPrtar.toString();
    }
    
}
