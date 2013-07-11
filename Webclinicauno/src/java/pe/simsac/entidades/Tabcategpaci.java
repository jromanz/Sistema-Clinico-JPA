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
@Table(name = "tabcategpaci", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabcategpaci.findAll", query = "SELECT t FROM Tabcategpaci t"),
    @NamedQuery(name = "Tabcategpaci.findByIdCatp", query = "SELECT t FROM Tabcategpaci t WHERE t.idCatp = :idCatp"),
    @NamedQuery(name = "Tabcategpaci.findByNombreCatp", query = "SELECT t FROM Tabcategpaci t WHERE t.nombreCatp = :nombreCatp")})
public class Tabcategpaci implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATP")
    private Integer idCatp;
    @Size(max = 20)
    @Column(name = "NOMBRE_CATP")
    private String nombreCatp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatp")
    private Collection<Maepaciente> maepacienteCollection;

    public Tabcategpaci() {
    }

    public Tabcategpaci(Integer idCatp) {
        this.idCatp = idCatp;
    }

    public Integer getIdCatp() {
        return idCatp;
    }

    public void setIdCatp(Integer idCatp) {
        this.idCatp = idCatp;
    }

    public String getNombreCatp() {
        return nombreCatp;
    }

    public void setNombreCatp(String nombreCatp) {
        this.nombreCatp = nombreCatp;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatp != null ? idCatp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabcategpaci)) {
            return false;
        }
        Tabcategpaci other = (Tabcategpaci) object;
        if ((this.idCatp == null && other.idCatp != null) || (this.idCatp != null && !this.idCatp.equals(other.idCatp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCatp;
    }
    
}
