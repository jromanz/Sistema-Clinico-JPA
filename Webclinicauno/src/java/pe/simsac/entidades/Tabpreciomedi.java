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
@Table(name = "tabpreciomedi", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabpreciomedi.findAll", query = "SELECT t FROM Tabpreciomedi t"),
    @NamedQuery(name = "Tabpreciomedi.findByIdPrmed", query = "SELECT t FROM Tabpreciomedi t WHERE t.idPrmed = :idPrmed"),
    @NamedQuery(name = "Tabpreciomedi.findByPrecioPrmed", query = "SELECT t FROM Tabpreciomedi t WHERE t.precioPrmed = :precioPrmed")})
public class Tabpreciomedi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRMED")
    private Integer idPrmed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRMED")
    private BigDecimal precioPrmed;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;
    @JoinColumn(name = "ID_MMED", referencedColumnName = "ID_MMED")
    @ManyToOne(optional = false)
    private Maemedicos idMmed;

    public Tabpreciomedi() {
    }

    public Tabpreciomedi(Integer idPrmed) {
        this.idPrmed = idPrmed;
    }

    public Integer getIdPrmed() {
        return idPrmed;
    }

    public void setIdPrmed(Integer idPrmed) {
        this.idPrmed = idPrmed;
    }

    public BigDecimal getPrecioPrmed() {
        return precioPrmed;
    }

    public void setPrecioPrmed(BigDecimal precioPrmed) {
        this.precioPrmed = precioPrmed;
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

    public Maemedicos getIdMmed() {
        return idMmed;
    }

    public void setIdMmed(Maemedicos idMmed) {
        this.idMmed = idMmed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrmed != null ? idPrmed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabpreciomedi)) {
            return false;
        }
        Tabpreciomedi other = (Tabpreciomedi) object;
        if ((this.idPrmed == null && other.idPrmed != null) || (this.idPrmed != null && !this.idPrmed.equals(other.idPrmed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPrmed.toString();
    }
    
}
