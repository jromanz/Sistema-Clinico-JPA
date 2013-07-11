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
@Table(name = "tabestaregistro", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabestaregistro.findAll", query = "SELECT t FROM Tabestaregistro t"),
    @NamedQuery(name = "Tabestaregistro.findByIdEstr", query = "SELECT t FROM Tabestaregistro t WHERE t.idEstr = :idEstr"),
    @NamedQuery(name = "Tabestaregistro.findByNombreEstr", query = "SELECT t FROM Tabestaregistro t WHERE t.nombreEstr = :nombreEstr")})
public class Tabestaregistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTR")
    private Integer idEstr;
    @Size(max = 50)
    @Column(name = "NOMBRE_ESTR")
    private String nombreEstr;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstr")
    private Collection<Maeregistro> maeregistroCollection;

    public Tabestaregistro() {
    }

    public Tabestaregistro(Integer idEstr) {
        this.idEstr = idEstr;
    }

    public Integer getIdEstr() {
        return idEstr;
    }

    public void setIdEstr(Integer idEstr) {
        this.idEstr = idEstr;
    }

    public String getNombreEstr() {
        return nombreEstr;
    }

    public void setNombreEstr(String nombreEstr) {
        this.nombreEstr = nombreEstr;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstr != null ? idEstr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabestaregistro)) {
            return false;
        }
        Tabestaregistro other = (Tabestaregistro) object;
        if ((this.idEstr == null && other.idEstr != null) || (this.idEstr != null && !this.idEstr.equals(other.idEstr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreEstr;
    }
    
}
