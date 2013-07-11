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
@Table(name = "tabformpago", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabformpago.findAll", query = "SELECT t FROM Tabformpago t"),
    @NamedQuery(name = "Tabformpago.findByIdFpag", query = "SELECT t FROM Tabformpago t WHERE t.idFpag = :idFpag"),
    @NamedQuery(name = "Tabformpago.findByNombreFpag", query = "SELECT t FROM Tabformpago t WHERE t.nombreFpag = :nombreFpag"),
    @NamedQuery(name = "Tabformpago.findByNumerodiasFpag", query = "SELECT t FROM Tabformpago t WHERE t.numerodiasFpag = :numerodiasFpag")})
public class Tabformpago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FPAG")
    private Integer idFpag;
    @Size(max = 20)
    @Column(name = "NOMBRE_FPAG")
    private String nombreFpag;
    @Column(name = "NUMERODIAS_FPAG")
    private Integer numerodiasFpag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFpag")
    private Collection<Maemedicos> maemedicosCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFpag")
    private Collection<Maeciamedica> maeciamedicaCollection;

    public Tabformpago() {
    }

    public Tabformpago(Integer idFpag) {
        this.idFpag = idFpag;
    }

    public Integer getIdFpag() {
        return idFpag;
    }

    public void setIdFpag(Integer idFpag) {
        this.idFpag = idFpag;
    }

    public String getNombreFpag() {
        return nombreFpag;
    }

    public void setNombreFpag(String nombreFpag) {
        this.nombreFpag = nombreFpag;
    }

    public Integer getNumerodiasFpag() {
        return numerodiasFpag;
    }

    public void setNumerodiasFpag(Integer numerodiasFpag) {
        this.numerodiasFpag = numerodiasFpag;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Maeciamedica> getMaeciamedicaCollection() {
        return maeciamedicaCollection;
    }

    public void setMaeciamedicaCollection(Collection<Maeciamedica> maeciamedicaCollection) {
        this.maeciamedicaCollection = maeciamedicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFpag != null ? idFpag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabformpago)) {
            return false;
        }
        Tabformpago other = (Tabformpago) object;
        if ((this.idFpag == null && other.idFpag != null) || (this.idFpag != null && !this.idFpag.equals(other.idFpag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreFpag;
    }
    
}
