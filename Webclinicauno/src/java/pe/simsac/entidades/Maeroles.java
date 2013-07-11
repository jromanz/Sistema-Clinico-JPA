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
@Table(name = "maeroles", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeroles.findAll", query = "SELECT m FROM Maeroles m"),
    @NamedQuery(name = "Maeroles.findByIdRole", query = "SELECT m FROM Maeroles m WHERE m.idRole = :idRole"),
    @NamedQuery(name = "Maeroles.findByNombreRole", query = "SELECT m FROM Maeroles m WHERE m.nombreRole = :nombreRole")})
public class Maeroles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROLE")
    private Integer idRole;
    @Size(max = 45)
    @Column(name = "NOMBRE_ROLE")
    private String nombreRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private Collection<Maepermiso> maepermisoCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Maeroles() {
    }

    public Maeroles(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    @XmlTransient
    public Collection<Maepermiso> getMaepermisoCollection() {
        return maepermisoCollection;
    }

    public void setMaepermisoCollection(Collection<Maepermiso> maepermisoCollection) {
        this.maepermisoCollection = maepermisoCollection;
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
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeroles)) {
            return false;
        }
        Maeroles other = (Maeroles) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreRole;
    }
    
}
