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
@Table(name = "tabtipotarifario", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabtipotarifario.findAll", query = "SELECT t FROM Tabtipotarifario t"),
    @NamedQuery(name = "Tabtipotarifario.findByIdTtar", query = "SELECT t FROM Tabtipotarifario t WHERE t.idTtar = :idTtar"),
    @NamedQuery(name = "Tabtipotarifario.findByNombreTtar", query = "SELECT t FROM Tabtipotarifario t WHERE t.nombreTtar = :nombreTtar")})
public class Tabtipotarifario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TTAR")
    private Integer idTtar;
    @Size(max = 45)
    @Column(name = "NOMBRE_TTAR")
    private String nombreTtar;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTtar")
    private Collection<Maetarifario> maetarifarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTtar")
    private Collection<Tabfactortari> tabfactortariCollection;

    public Tabtipotarifario() {
    }

    public Tabtipotarifario(Integer idTtar) {
        this.idTtar = idTtar;
    }

    public Integer getIdTtar() {
        return idTtar;
    }

    public void setIdTtar(Integer idTtar) {
        this.idTtar = idTtar;
    }

    public String getNombreTtar() {
        return nombreTtar;
    }

    public void setNombreTtar(String nombreTtar) {
        this.nombreTtar = nombreTtar;
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
    public Collection<Tabfactortari> getTabfactortariCollection() {
        return tabfactortariCollection;
    }

    public void setTabfactortariCollection(Collection<Tabfactortari> tabfactortariCollection) {
        this.tabfactortariCollection = tabfactortariCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTtar != null ? idTtar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabtipotarifario)) {
            return false;
        }
        Tabtipotarifario other = (Tabtipotarifario) object;
        if ((this.idTtar == null && other.idTtar != null) || (this.idTtar != null && !this.idTtar.equals(other.idTtar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTtar;
    }
    
}
