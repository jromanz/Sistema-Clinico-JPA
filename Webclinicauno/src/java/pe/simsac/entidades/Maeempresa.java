/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeempresa", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeempresa.findAll", query = "SELECT m FROM Maeempresa m"),
    @NamedQuery(name = "Maeempresa.findByIdMemp", query = "SELECT m FROM Maeempresa m WHERE m.idMemp = :idMemp"),
    @NamedQuery(name = "Maeempresa.findByRucMemp", query = "SELECT m FROM Maeempresa m WHERE m.rucMemp = :rucMemp"),
    @NamedQuery(name = "Maeempresa.findByRazonsocMemp", query = "SELECT m FROM Maeempresa m WHERE m.razonsocMemp = :razonsocMemp"),
    @NamedQuery(name = "Maeempresa.findByDireccionMemp", query = "SELECT m FROM Maeempresa m WHERE m.direccionMemp = :direccionMemp"),
    @NamedQuery(name = "Maeempresa.findByBaseMemp", query = "SELECT m FROM Maeempresa m WHERE m.baseMemp = :baseMemp")})
public class Maeempresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEMP")
    private Integer idMemp;
    @Size(max = 11)
    @Column(name = "RUC_MEMP")
    private String rucMemp;
    @Size(max = 100)
    @Column(name = "RAZONSOC_MEMP")
    private String razonsocMemp;
    @Size(max = 100)
    @Column(name = "DIRECCION_MEMP")
    private String direccionMemp;
    @Size(max = 20)
    @Column(name = "BASE_MEMP")
    private String baseMemp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMemp")
    private Collection<Maepersonal> maepersonalCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Maeempresa() {
    }

    public Maeempresa(Integer idMemp) {
        this.idMemp = idMemp;
    }

    public Integer getIdMemp() {
        return idMemp;
    }

    public void setIdMemp(Integer idMemp) {
        this.idMemp = idMemp;
    }

    public String getRucMemp() {
        return rucMemp;
    }

    public void setRucMemp(String rucMemp) {
        this.rucMemp = rucMemp;
    }

    public String getRazonsocMemp() {
        return razonsocMemp;
    }

    public void setRazonsocMemp(String razonsocMemp) {
        this.razonsocMemp = razonsocMemp;
    }

    public String getDireccionMemp() {
        return direccionMemp;
    }

    public void setDireccionMemp(String direccionMemp) {
        this.direccionMemp = direccionMemp;
    }

    public String getBaseMemp() {
        return baseMemp;
    }

    public void setBaseMemp(String baseMemp) {
        this.baseMemp = baseMemp;
    }

    @XmlTransient
    public Collection<Maepersonal> getMaepersonalCollection() {
        return maepersonalCollection;
    }

    public void setMaepersonalCollection(Collection<Maepersonal> maepersonalCollection) {
        this.maepersonalCollection = maepersonalCollection;
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
        hash += (idMemp != null ? idMemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeempresa)) {
            return false;
        }
        Maeempresa other = (Maeempresa) object;
        if ((this.idMemp == null && other.idMemp != null) || (this.idMemp != null && !this.idMemp.equals(other.idMemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idMemp.toString();
    }
    
}
