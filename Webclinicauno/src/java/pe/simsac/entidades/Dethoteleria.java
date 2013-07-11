/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "dethoteleria", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dethoteleria.findAll", query = "SELECT d FROM Dethoteleria d"),
    @NamedQuery(name = "Dethoteleria.findByIdHote", query = "SELECT d FROM Dethoteleria d WHERE d.idHote = :idHote"),
    @NamedQuery(name = "Dethoteleria.findByFechaHote", query = "SELECT d FROM Dethoteleria d WHERE d.fechaHote = :fechaHote")})
public class Dethoteleria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HOTE")
    private Integer idHote;
    @Column(name = "FECHA_HOTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHote;
    @JoinColumn(name = "ID_REGI", referencedColumnName = "ID_REGI")
    @ManyToOne(optional = false)
    private Maeregistro idRegi;
    @JoinColumn(name = "ID_CAMA", referencedColumnName = "ID_CAMA")
    @ManyToOne(optional = false)
    private Tabcamas idCama;
    @JoinColumn(name = "ID_MTAR", referencedColumnName = "ID_MTAR")
    @ManyToOne(optional = false)
    private Maetarifario idMtar;

    public Dethoteleria() {
    }

    public Dethoteleria(Integer idHote) {
        this.idHote = idHote;
    }

    public Integer getIdHote() {
        return idHote;
    }

    public void setIdHote(Integer idHote) {
        this.idHote = idHote;
    }

    public Date getFechaHote() {
        return fechaHote;
    }

    public void setFechaHote(Date fechaHote) {
        this.fechaHote = fechaHote;
    }

    public Maeregistro getIdRegi() {
        return idRegi;
    }

    public void setIdRegi(Maeregistro idRegi) {
        this.idRegi = idRegi;
    }

    public Tabcamas getIdCama() {
        return idCama;
    }

    public void setIdCama(Tabcamas idCama) {
        this.idCama = idCama;
    }

    public Maetarifario getIdMtar() {
        return idMtar;
    }

    public void setIdMtar(Maetarifario idMtar) {
        this.idMtar = idMtar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHote != null ? idHote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dethoteleria)) {
            return false;
        }
        Dethoteleria other = (Dethoteleria) object;
        if ((this.idHote == null && other.idHote != null) || (this.idHote != null && !this.idHote.equals(other.idHote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idHote.toString();
    }
    
}
