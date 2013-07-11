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
@Table(name = "tabestacivil", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabestacivil.findAll", query = "SELECT t FROM Tabestacivil t"),
    @NamedQuery(name = "Tabestacivil.findByIdEstc", query = "SELECT t FROM Tabestacivil t WHERE t.idEstc = :idEstc"),
    @NamedQuery(name = "Tabestacivil.findByNombreEstc", query = "SELECT t FROM Tabestacivil t WHERE t.nombreEstc = :nombreEstc")})
public class Tabestacivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTC")
    private Integer idEstc;
    @Size(max = 45)
    @Column(name = "NOMBRE_ESTC")
    private String nombreEstc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstc")
    private Collection<Maepersonal> maepersonalCollection;

    public Tabestacivil() {
    }

    public Tabestacivil(Integer idEstc) {
        this.idEstc = idEstc;
    }

    public Integer getIdEstc() {
        return idEstc;
    }

    public void setIdEstc(Integer idEstc) {
        this.idEstc = idEstc;
    }

    public String getNombreEstc() {
        return nombreEstc;
    }

    public void setNombreEstc(String nombreEstc) {
        this.nombreEstc = nombreEstc;
    }

    @XmlTransient
    public Collection<Maepersonal> getMaepersonalCollection() {
        return maepersonalCollection;
    }

    public void setMaepersonalCollection(Collection<Maepersonal> maepersonalCollection) {
        this.maepersonalCollection = maepersonalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstc != null ? idEstc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabestacivil)) {
            return false;
        }
        Tabestacivil other = (Tabestacivil) object;
        if ((this.idEstc == null && other.idEstc != null) || (this.idEstc != null && !this.idEstc.equals(other.idEstc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreEstc;
    }
    
}
