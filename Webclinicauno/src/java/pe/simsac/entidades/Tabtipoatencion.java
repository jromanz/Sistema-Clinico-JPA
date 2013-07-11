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
@Table(name = "tabtipoatencion", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabtipoatencion.findAll", query = "SELECT t FROM Tabtipoatencion t"),
    @NamedQuery(name = "Tabtipoatencion.findByIdTate", query = "SELECT t FROM Tabtipoatencion t WHERE t.idTate = :idTate"),
    @NamedQuery(name = "Tabtipoatencion.findByNombreTate", query = "SELECT t FROM Tabtipoatencion t WHERE t.nombreTate = :nombreTate"),
    @NamedQuery(name = "Tabtipoatencion.findByFlgatencionTate", query = "SELECT t FROM Tabtipoatencion t WHERE t.flgatencionTate = :flgatencionTate")})
public class Tabtipoatencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TATE")
    private Integer idTate;
    @Size(max = 45)
    @Column(name = "NOMBRE_TATE")
    private String nombreTate;
    @Column(name = "FLGATENCION_TATE")
    private Character flgatencionTate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTate")
    private Collection<Maeregistro> maeregistroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTate")
    private Collection<Tabcobertura> tabcoberturaCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Tabtipoatencion() {
    }

    public Tabtipoatencion(Integer idTate) {
        this.idTate = idTate;
    }

    public Integer getIdTate() {
        return idTate;
    }

    public void setIdTate(Integer idTate) {
        this.idTate = idTate;
    }

    public String getNombreTate() {
        return nombreTate;
    }

    public void setNombreTate(String nombreTate) {
        this.nombreTate = nombreTate;
    }

    public Character getFlgatencionTate() {
        return flgatencionTate;
    }

    public void setFlgatencionTate(Character flgatencionTate) {
        this.flgatencionTate = flgatencionTate;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    @XmlTransient
    public Collection<Tabcobertura> getTabcoberturaCollection() {
        return tabcoberturaCollection;
    }

    public void setTabcoberturaCollection(Collection<Tabcobertura> tabcoberturaCollection) {
        this.tabcoberturaCollection = tabcoberturaCollection;
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
        hash += (idTate != null ? idTate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabtipoatencion)) {
            return false;
        }
        Tabtipoatencion other = (Tabtipoatencion) object;
        if ((this.idTate == null && other.idTate != null) || (this.idTate != null && !this.idTate.equals(other.idTate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTate;
    }
    
}
