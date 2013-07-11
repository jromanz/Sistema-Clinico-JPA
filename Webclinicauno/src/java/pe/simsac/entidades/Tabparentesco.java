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
@Table(name = "tabparentesco", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabparentesco.findAll", query = "SELECT t FROM Tabparentesco t"),
    @NamedQuery(name = "Tabparentesco.findByIdTpar", query = "SELECT t FROM Tabparentesco t WHERE t.idTpar = :idTpar"),
    @NamedQuery(name = "Tabparentesco.findByNombreTpar", query = "SELECT t FROM Tabparentesco t WHERE t.nombreTpar = :nombreTpar")})
public class Tabparentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TPAR")
    private Integer idTpar;
    @Size(max = 20)
    @Column(name = "NOMBRE_TPAR")
    private String nombreTpar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTpar")
    private Collection<Maepaciente> maepacienteCollection;

    public Tabparentesco() {
    }

    public Tabparentesco(Integer idTpar) {
        this.idTpar = idTpar;
    }

    public Integer getIdTpar() {
        return idTpar;
    }

    public void setIdTpar(Integer idTpar) {
        this.idTpar = idTpar;
    }

    public String getNombreTpar() {
        return nombreTpar;
    }

    public void setNombreTpar(String nombreTpar) {
        this.nombreTpar = nombreTpar;
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
        hash += (idTpar != null ? idTpar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabparentesco)) {
            return false;
        }
        Tabparentesco other = (Tabparentesco) object;
        if ((this.idTpar == null && other.idTpar != null) || (this.idTpar != null && !this.idTpar.equals(other.idTpar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTpar;
    }
    
}
