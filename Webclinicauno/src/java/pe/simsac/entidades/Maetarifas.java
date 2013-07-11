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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maetarifas", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maetarifas.findAll", query = "SELECT m FROM Maetarifas m"),
    @NamedQuery(name = "Maetarifas.findByIdMtaf", query = "SELECT m FROM Maetarifas m WHERE m.idMtaf = :idMtaf"),
    @NamedQuery(name = "Maetarifas.findByNombreMtaf", query = "SELECT m FROM Maetarifas m WHERE m.nombreMtaf = :nombreMtaf"),
    @NamedQuery(name = "Maetarifas.findByFlgciainteMtaf", query = "SELECT m FROM Maetarifas m WHERE m.flgciainteMtaf = :flgciainteMtaf")})
public class Maetarifas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MTAF")
    private Integer idMtaf;
    @Size(max = 45)
    @Column(name = "NOMBRE_MTAF")
    private String nombreMtaf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLGCIAINTE_MTAF")
    private boolean flgciainteMtaf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Tabpreciomedi> tabpreciomediCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Maeregistro> maeregistroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Tabprecioemed> tabprecioemedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Tabpreciotari> tabpreciotariCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Tabfactortari> tabfactortariCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Maeplanes> maeplanesCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtaf")
    private Collection<Tabpreciocmed> tabpreciocmedCollection;

    public Maetarifas() {
    }

    public Maetarifas(Integer idMtaf) {
        this.idMtaf = idMtaf;
    }

    public Maetarifas(Integer idMtaf, boolean flgciainteMtaf) {
        this.idMtaf = idMtaf;
        this.flgciainteMtaf = flgciainteMtaf;
    }

    public Integer getIdMtaf() {
        return idMtaf;
    }

    public void setIdMtaf(Integer idMtaf) {
        this.idMtaf = idMtaf;
    }

    public String getNombreMtaf() {
        return nombreMtaf;
    }

    public void setNombreMtaf(String nombreMtaf) {
        this.nombreMtaf = nombreMtaf;
    }

    public boolean getFlgciainteMtaf() {
        return flgciainteMtaf;
    }

    public void setFlgciainteMtaf(boolean flgciainteMtaf) {
        this.flgciainteMtaf = flgciainteMtaf;
    }

    @XmlTransient
    public Collection<Tabpreciomedi> getTabpreciomediCollection() {
        return tabpreciomediCollection;
    }

    public void setTabpreciomediCollection(Collection<Tabpreciomedi> tabpreciomediCollection) {
        this.tabpreciomediCollection = tabpreciomediCollection;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    @XmlTransient
    public Collection<Tabprecioemed> getTabprecioemedCollection() {
        return tabprecioemedCollection;
    }

    public void setTabprecioemedCollection(Collection<Tabprecioemed> tabprecioemedCollection) {
        this.tabprecioemedCollection = tabprecioemedCollection;
    }

    @XmlTransient
    public Collection<Tabpreciotari> getTabpreciotariCollection() {
        return tabpreciotariCollection;
    }

    public void setTabpreciotariCollection(Collection<Tabpreciotari> tabpreciotariCollection) {
        this.tabpreciotariCollection = tabpreciotariCollection;
    }

    @XmlTransient
    public Collection<Tabfactortari> getTabfactortariCollection() {
        return tabfactortariCollection;
    }

    public void setTabfactortariCollection(Collection<Tabfactortari> tabfactortariCollection) {
        this.tabfactortariCollection = tabfactortariCollection;
    }

    @XmlTransient
    public Collection<Maeplanes> getMaeplanesCollection() {
        return maeplanesCollection;
    }

    public void setMaeplanesCollection(Collection<Maeplanes> maeplanesCollection) {
        this.maeplanesCollection = maeplanesCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Tabpreciocmed> getTabpreciocmedCollection() {
        return tabpreciocmedCollection;
    }

    public void setTabpreciocmedCollection(Collection<Tabpreciocmed> tabpreciocmedCollection) {
        this.tabpreciocmedCollection = tabpreciocmedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMtaf != null ? idMtaf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maetarifas)) {
            return false;
        }
        Maetarifas other = (Maetarifas) object;
        if ((this.idMtaf == null && other.idMtaf != null) || (this.idMtaf != null && !this.idMtaf.equals(other.idMtaf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMtaf;
    }
    
}
