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
@Table(name = "maepoliza", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maepoliza.findAll", query = "SELECT m FROM Maepoliza m"),
    @NamedQuery(name = "Maepoliza.findByIdPoli", query = "SELECT m FROM Maepoliza m WHERE m.idPoli = :idPoli"),
    @NamedQuery(name = "Maepoliza.findByCodigoPoli", query = "SELECT m FROM Maepoliza m WHERE m.codigoPoli = :codigoPoli"),
    @NamedQuery(name = "Maepoliza.findByFechainiPoli", query = "SELECT m FROM Maepoliza m WHERE m.fechainiPoli = :fechainiPoli"),
    @NamedQuery(name = "Maepoliza.findByFechafinPoli", query = "SELECT m FROM Maepoliza m WHERE m.fechafinPoli = :fechafinPoli")})
public class Maepoliza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POLI")
    private Integer idPoli;
    @Size(max = 45)
    @Column(name = "CODIGO_POLI")
    private String codigoPoli;
    @Column(name = "FECHAINI_POLI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiPoli;
    @Column(name = "FECHAFIN_POLI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinPoli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPcli")
    private Collection<Maepaciente> maepacienteCollection;
    @JoinColumn(name = "ID_PLAN", referencedColumnName = "ID_PLAN")
    @ManyToOne(optional = false)
    private Maeplanes idPlan;
    @JoinColumn(name = "ID_MCIA", referencedColumnName = "ID_MCIA")
    @ManyToOne(optional = false)
    private Maecompania idMcia;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPoli")
    private Collection<Maeexclusiones> maeexclusionesCollection;

    public Maepoliza() {
    }

    public Maepoliza(Integer idPoli) {
        this.idPoli = idPoli;
    }

    public Integer getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(Integer idPoli) {
        this.idPoli = idPoli;
    }

    public String getCodigoPoli() {
        return codigoPoli;
    }

    public void setCodigoPoli(String codigoPoli) {
        this.codigoPoli = codigoPoli;
    }

    public Date getFechainiPoli() {
        return fechainiPoli;
    }

    public void setFechainiPoli(Date fechainiPoli) {
        this.fechainiPoli = fechainiPoli;
    }

    public Date getFechafinPoli() {
        return fechafinPoli;
    }

    public void setFechafinPoli(Date fechafinPoli) {
        this.fechafinPoli = fechafinPoli;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
    }

    public Maeplanes getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Maeplanes idPlan) {
        this.idPlan = idPlan;
    }

    public Maecompania getIdMcia() {
        return idMcia;
    }

    public void setIdMcia(Maecompania idMcia) {
        this.idMcia = idMcia;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Maeexclusiones> getMaeexclusionesCollection() {
        return maeexclusionesCollection;
    }

    public void setMaeexclusionesCollection(Collection<Maeexclusiones> maeexclusionesCollection) {
        this.maeexclusionesCollection = maeexclusionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoli != null ? idPoli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maepoliza)) {
            return false;
        }
        Maepoliza other = (Maepoliza) object;
        if ((this.idPoli == null && other.idPoli != null) || (this.idPoli != null && !this.idPoli.equals(other.idPoli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoPoli;
    }
    
}
