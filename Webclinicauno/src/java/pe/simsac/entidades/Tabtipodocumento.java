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
@Table(name = "tabtipodocumento", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabtipodocumento.findAll", query = "SELECT t FROM Tabtipodocumento t"),
    @NamedQuery(name = "Tabtipodocumento.findByIdTdoc", query = "SELECT t FROM Tabtipodocumento t WHERE t.idTdoc = :idTdoc"),
    @NamedQuery(name = "Tabtipodocumento.findByNombreTdoc", query = "SELECT t FROM Tabtipodocumento t WHERE t.nombreTdoc = :nombreTdoc")})
public class Tabtipodocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TDOC")
    private Integer idTdoc;
    @Size(max = 50)
    @Column(name = "NOMBRE_TDOC")
    private String nombreTdoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTdoc")
    private Collection<Maemedicos> maemedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTdoc")
    private Collection<Maepaciente> maepacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTdoc")
    private Collection<Maepersonal> maepersonalCollection;

    public Tabtipodocumento() {
    }

    public Tabtipodocumento(Integer idTdoc) {
        this.idTdoc = idTdoc;
    }

    public Integer getIdTdoc() {
        return idTdoc;
    }

    public void setIdTdoc(Integer idTdoc) {
        this.idTdoc = idTdoc;
    }

    public String getNombreTdoc() {
        return nombreTdoc;
    }

    public void setNombreTdoc(String nombreTdoc) {
        this.nombreTdoc = nombreTdoc;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
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
        hash += (idTdoc != null ? idTdoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabtipodocumento)) {
            return false;
        }
        Tabtipodocumento other = (Tabtipodocumento) object;
        if ((this.idTdoc == null && other.idTdoc != null) || (this.idTdoc != null && !this.idTdoc.equals(other.idTdoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTdoc;
    }
    
}
