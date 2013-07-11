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
@Table(name = "tabservicio", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabservicio.findAll", query = "SELECT t FROM Tabservicio t"),
    @NamedQuery(name = "Tabservicio.findByIdServ", query = "SELECT t FROM Tabservicio t WHERE t.idServ = :idServ"),
    @NamedQuery(name = "Tabservicio.findByNombreServ", query = "SELECT t FROM Tabservicio t WHERE t.nombreServ = :nombreServ")})
public class Tabservicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERV")
    private Integer idServ;
    @Size(max = 45)
    @Column(name = "NOMBRE_SERV")
    private String nombreServ;
    @JoinColumn(name = "ID_MMED", referencedColumnName = "ID_MMED")
    @ManyToOne(optional = false)
    private Maemedicos idMmed;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServ")
    private Collection<Maeordenserv> maeordenservCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServ")
    private Collection<Maetarifario> maetarifarioCollection;

    public Tabservicio() {
    }

    public Tabservicio(Integer idServ) {
        this.idServ = idServ;
    }

    public Integer getIdServ() {
        return idServ;
    }

    public void setIdServ(Integer idServ) {
        this.idServ = idServ;
    }

    public String getNombreServ() {
        return nombreServ;
    }

    public void setNombreServ(String nombreServ) {
        this.nombreServ = nombreServ;
    }

    public Maemedicos getIdMmed() {
        return idMmed;
    }

    public void setIdMmed(Maemedicos idMmed) {
        this.idMmed = idMmed;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Maeordenserv> getMaeordenservCollection() {
        return maeordenservCollection;
    }

    public void setMaeordenservCollection(Collection<Maeordenserv> maeordenservCollection) {
        this.maeordenservCollection = maeordenservCollection;
    }

    @XmlTransient
    public Collection<Maetarifario> getMaetarifarioCollection() {
        return maetarifarioCollection;
    }

    public void setMaetarifarioCollection(Collection<Maetarifario> maetarifarioCollection) {
        this.maetarifarioCollection = maetarifarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServ != null ? idServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabservicio)) {
            return false;
        }
        Tabservicio other = (Tabservicio) object;
        if ((this.idServ == null && other.idServ != null) || (this.idServ != null && !this.idServ.equals(other.idServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreServ;
    }
    
}
