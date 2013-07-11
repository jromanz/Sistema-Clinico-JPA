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
@Table(name = "tabcamas", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabcamas.findAll", query = "SELECT t FROM Tabcamas t"),
    @NamedQuery(name = "Tabcamas.findByIdCama", query = "SELECT t FROM Tabcamas t WHERE t.idCama = :idCama"),
    @NamedQuery(name = "Tabcamas.findByNombreCama", query = "SELECT t FROM Tabcamas t WHERE t.nombreCama = :nombreCama")})
public class Tabcamas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAMA")
    private Integer idCama;
    @Size(max = 5)
    @Column(name = "NOMBRE_CAMA")
    private String nombreCama;
    @JoinColumn(name = "ID_ESTC", referencedColumnName = "ID_ESTC")
    @ManyToOne(optional = false)
    private Tabestacama idEstc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCama")
    private Collection<Dethoteleria> dethoteleriaCollection;

    public Tabcamas() {
    }

    public Tabcamas(Integer idCama) {
        this.idCama = idCama;
    }

    public Integer getIdCama() {
        return idCama;
    }

    public void setIdCama(Integer idCama) {
        this.idCama = idCama;
    }

    public String getNombreCama() {
        return nombreCama;
    }

    public void setNombreCama(String nombreCama) {
        this.nombreCama = nombreCama;
    }

    public Tabestacama getIdEstc() {
        return idEstc;
    }

    public void setIdEstc(Tabestacama idEstc) {
        this.idEstc = idEstc;
    }

    @XmlTransient
    public Collection<Dethoteleria> getDethoteleriaCollection() {
        return dethoteleriaCollection;
    }

    public void setDethoteleriaCollection(Collection<Dethoteleria> dethoteleriaCollection) {
        this.dethoteleriaCollection = dethoteleriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCama != null ? idCama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabcamas)) {
            return false;
        }
        Tabcamas other = (Tabcamas) object;
        if ((this.idCama == null && other.idCama != null) || (this.idCama != null && !this.idCama.equals(other.idCama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCama;
    }
    
}
