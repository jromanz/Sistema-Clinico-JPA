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
@Table(name = "maemodulo", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maemodulo.findAll", query = "SELECT m FROM Maemodulo m"),
    @NamedQuery(name = "Maemodulo.findByIdModu", query = "SELECT m FROM Maemodulo m WHERE m.idModu = :idModu"),
    @NamedQuery(name = "Maemodulo.findByNombreModu", query = "SELECT m FROM Maemodulo m WHERE m.nombreModu = :nombreModu")})
public class Maemodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MODU")
    private Integer idModu;
    @Size(max = 30)
    @Column(name = "NOMBRE_MODU")
    private String nombreModu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModu")
    private Collection<Maeprograma> maeprogramaCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Maemodulo() {
    }

    public Maemodulo(Integer idModu) {
        this.idModu = idModu;
    }

    public Integer getIdModu() {
        return idModu;
    }

    public void setIdModu(Integer idModu) {
        this.idModu = idModu;
    }

    public String getNombreModu() {
        return nombreModu;
    }

    public void setNombreModu(String nombreModu) {
        this.nombreModu = nombreModu;
    }

    @XmlTransient
    public Collection<Maeprograma> getMaeprogramaCollection() {
        return maeprogramaCollection;
    }

    public void setMaeprogramaCollection(Collection<Maeprograma> maeprogramaCollection) {
        this.maeprogramaCollection = maeprogramaCollection;
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
        hash += (idModu != null ? idModu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maemodulo)) {
            return false;
        }
        Maemodulo other = (Maemodulo) object;
        if ((this.idModu == null && other.idModu != null) || (this.idModu != null && !this.idModu.equals(other.idModu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreModu;
    }
    
}
