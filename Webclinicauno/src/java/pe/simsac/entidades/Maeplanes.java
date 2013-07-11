/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeplanes", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeplanes.findAll", query = "SELECT m FROM Maeplanes m"),
    @NamedQuery(name = "Maeplanes.findByIdPlan", query = "SELECT m FROM Maeplanes m WHERE m.idPlan = :idPlan"),
    @NamedQuery(name = "Maeplanes.findByNombrePlan", query = "SELECT m FROM Maeplanes m WHERE m.nombrePlan = :nombrePlan"),
    @NamedQuery(name = "Maeplanes.findByFechainiPlan", query = "SELECT m FROM Maeplanes m WHERE m.fechainiPlan = :fechainiPlan"),
    @NamedQuery(name = "Maeplanes.findByFechafinPlan", query = "SELECT m FROM Maeplanes m WHERE m.fechafinPlan = :fechafinPlan")})
public class Maeplanes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PLAN")
    private Integer idPlan;
    @Size(max = 100)
    @Column(name = "NOMBRE_PLAN")
    private String nombrePlan;
    @Column(name = "FECHAINI_PLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiPlan;
    @Column(name = "FECHAFIN_PLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    private Collection<Maeregistro> maeregistroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    private Collection<Tabcobertura> tabcoberturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    private Collection<Maepoliza> maepolizaCollection;
    @JoinColumn(name = "ID_MTAF", referencedColumnName = "ID_MTAF")
    @ManyToOne(optional = false)
    private Maetarifas idMtaf;

    public Maeplanes() {
    }

    public Maeplanes(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Date getFechainiPlan() {
        return fechainiPlan;
    }

    public void setFechainiPlan(Date fechainiPlan) {
        this.fechainiPlan = fechainiPlan;
    }

    public Date getFechafinPlan() {
        return fechafinPlan;
    }

    public void setFechafinPlan(Date fechafinPlan) {
        this.fechafinPlan = fechafinPlan;
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

    @XmlTransient
    public Collection<Maepoliza> getMaepolizaCollection() {
        return maepolizaCollection;
    }

    public void setMaepolizaCollection(Collection<Maepoliza> maepolizaCollection) {
        this.maepolizaCollection = maepolizaCollection;
    }

    public Maetarifas getIdMtaf() {
        return idMtaf;
    }

    public void setIdMtaf(Maetarifas idMtaf) {
        this.idMtaf = idMtaf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeplanes)) {
            return false;
        }
        Maeplanes other = (Maeplanes) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePlan;
    }
    
}
