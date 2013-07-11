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
@Table(name = "tabmoneda", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabmoneda.findAll", query = "SELECT t FROM Tabmoneda t"),
    @NamedQuery(name = "Tabmoneda.findByIdMone", query = "SELECT t FROM Tabmoneda t WHERE t.idMone = :idMone"),
    @NamedQuery(name = "Tabmoneda.findByNombreMone", query = "SELECT t FROM Tabmoneda t WHERE t.nombreMone = :nombreMone"),
    @NamedQuery(name = "Tabmoneda.findByNomenglaMone", query = "SELECT t FROM Tabmoneda t WHERE t.nomenglaMone = :nomenglaMone")})
public class Tabmoneda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MONE")
    private Integer idMone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOMBRE_MONE")
    private String nombreMone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "NOMENGLA_MONE")
    private String nomenglaMone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMone")
    private Collection<Tabcobertura> tabcoberturaCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;

    public Tabmoneda() {
    }

    public Tabmoneda(Integer idMone) {
        this.idMone = idMone;
    }

    public Tabmoneda(Integer idMone, String nombreMone, String nomenglaMone) {
        this.idMone = idMone;
        this.nombreMone = nombreMone;
        this.nomenglaMone = nomenglaMone;
    }

    public Integer getIdMone() {
        return idMone;
    }

    public void setIdMone(Integer idMone) {
        this.idMone = idMone;
    }

    public String getNombreMone() {
        return nombreMone;
    }

    public void setNombreMone(String nombreMone) {
        this.nombreMone = nombreMone;
    }

    public String getNomenglaMone() {
        return nomenglaMone;
    }

    public void setNomenglaMone(String nomenglaMone) {
        this.nomenglaMone = nomenglaMone;
    }

    @XmlTransient
    public Collection<Tabcobertura> getTabcoberturaCollection() {
        return tabcoberturaCollection;
    }

    public void setTabcoberturaCollection(Collection<Tabcobertura> tabcoberturaCollection) {
        this.tabcoberturaCollection = tabcoberturaCollection;
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
        hash += (idMone != null ? idMone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabmoneda)) {
            return false;
        }
        Tabmoneda other = (Tabmoneda) object;
        if ((this.idMone == null && other.idMone != null) || (this.idMone != null && !this.idMone.equals(other.idMone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMone;
    }
    
}
