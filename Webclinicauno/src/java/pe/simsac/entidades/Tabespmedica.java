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
@Table(name = "tabespmedica", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabespmedica.findAll", query = "SELECT t FROM Tabespmedica t"),
    @NamedQuery(name = "Tabespmedica.findByIdEspm", query = "SELECT t FROM Tabespmedica t WHERE t.idEspm = :idEspm"),
    @NamedQuery(name = "Tabespmedica.findByNombreEspm", query = "SELECT t FROM Tabespmedica t WHERE t.nombreEspm = :nombreEspm")})
public class Tabespmedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESPM")
    private Integer idEspm;
    @Size(max = 45)
    @Column(name = "NOMBRE_ESPM")
    private String nombreEspm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspm")
    private Collection<Maemedicos> maemedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspm")
    private Collection<Tabprecioemed> tabprecioemedCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(mappedBy = "idEspm")
    private Collection<Maetarifario> maetarifarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspm")
    private Collection<Maeexclusiones> maeexclusionesCollection;

    public Tabespmedica() {
    }

    public Tabespmedica(Integer idEspm) {
        this.idEspm = idEspm;
    }

    public Integer getIdEspm() {
        return idEspm;
    }

    public void setIdEspm(Integer idEspm) {
        this.idEspm = idEspm;
    }

    public String getNombreEspm() {
        return nombreEspm;
    }

    public void setNombreEspm(String nombreEspm) {
        this.nombreEspm = nombreEspm;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    @XmlTransient
    public Collection<Tabprecioemed> getTabprecioemedCollection() {
        return tabprecioemedCollection;
    }

    public void setTabprecioemedCollection(Collection<Tabprecioemed> tabprecioemedCollection) {
        this.tabprecioemedCollection = tabprecioemedCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Maetarifario> getMaetarifarioCollection() {
        return maetarifarioCollection;
    }

    public void setMaetarifarioCollection(Collection<Maetarifario> maetarifarioCollection) {
        this.maetarifarioCollection = maetarifarioCollection;
    }

    @XmlTransient
    public Collection<Maeexclusiones> getMaeexclusionesCollection() {
        return maeexclusionesCollection;
    }

    public void setMaeexclusionesCollection(Collection<Maeexclusiones> maeexclusionesCollection) {
        this.maeexclusionesCollection = maeexclusionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspm != null ? idEspm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabespmedica)) {
            return false;
        }
        Tabespmedica other = (Tabespmedica) object;
        if ((this.idEspm == null && other.idEspm != null) || (this.idEspm != null && !this.idEspm.equals(other.idEspm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreEspm;
    }
    
}
