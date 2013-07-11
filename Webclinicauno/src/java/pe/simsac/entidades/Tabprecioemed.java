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
@Table(name = "tabprecioemed", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabprecioemed.findAll", query = "SELECT t FROM Tabprecioemed t"),
    @NamedQuery(name = "Tabprecioemed.findByIdPreme", query = "SELECT t FROM Tabprecioemed t WHERE t.idPreme = :idPreme"),
    @NamedQuery(name = "Tabprecioemed.findByPrecioPreme", query = "SELECT t FROM Tabprecioemed t WHERE t.precioPreme = :precioPreme")})
public class Tabprecioemed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREME")
    private Integer idPreme;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PREME")
    private BigDecimal precioPreme;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_ESPM", referencedColumnName = "ID_ESPM")
    @ManyToOne(optional = false)
    private Tabespmedica idEspm;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;

    public Tabprecioemed() {
    }

    public Tabprecioemed(Integer idPreme) {
        this.idPreme = idPreme;
    }

    public Integer getIdPreme() {
        return idPreme;
    }

    public void setIdPreme(Integer idPreme) {
        this.idPreme = idPreme;
    }

    public BigDecimal getPrecioPreme() {
        return precioPreme;
    }

    public void setPrecioPreme(BigDecimal precioPreme) {
        this.precioPreme = precioPreme;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabespmedica getIdEspm() {
        return idEspm;
    }

    public void setIdEspm(Tabespmedica idEspm) {
        this.idEspm = idEspm;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreme != null ? idPreme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabprecioemed)) {
            return false;
        }
        Tabprecioemed other = (Tabprecioemed) object;
        if ((this.idPreme == null && other.idPreme != null) || (this.idPreme != null && !this.idPreme.equals(other.idPreme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPreme.toString();
    }
    
}
