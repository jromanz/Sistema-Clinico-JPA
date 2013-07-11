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
@Table(name = "maecompania", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maecompania.findAll", query = "SELECT m FROM Maecompania m"),
    @NamedQuery(name = "Maecompania.findByIdMcia", query = "SELECT m FROM Maecompania m WHERE m.idMcia = :idMcia"),
    @NamedQuery(name = "Maecompania.findByCodigoMcia", query = "SELECT m FROM Maecompania m WHERE m.codigoMcia = :codigoMcia"),
    @NamedQuery(name = "Maecompania.findByNombreMcia", query = "SELECT m FROM Maecompania m WHERE m.nombreMcia = :nombreMcia"),
    @NamedQuery(name = "Maecompania.findByDireccionMcia", query = "SELECT m FROM Maecompania m WHERE m.direccionMcia = :direccionMcia"),
    @NamedQuery(name = "Maecompania.findByNumerotelMcia", query = "SELECT m FROM Maecompania m WHERE m.numerotelMcia = :numerotelMcia"),
    @NamedQuery(name = "Maecompania.findByCorreoelecMcia", query = "SELECT m FROM Maecompania m WHERE m.correoelecMcia = :correoelecMcia"),
    @NamedQuery(name = "Maecompania.findByNombrecontMcia", query = "SELECT m FROM Maecompania m WHERE m.nombrecontMcia = :nombrecontMcia"),
    @NamedQuery(name = "Maecompania.findByFechaingMcia", query = "SELECT m FROM Maecompania m WHERE m.fechaingMcia = :fechaingMcia")})
public class Maecompania implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MCIA")
    private Integer idMcia;
    @Size(max = 20)
    @Column(name = "CODIGO_MCIA")
    private String codigoMcia;
    @Size(max = 45)
    @Column(name = "NOMBRE_MCIA")
    private String nombreMcia;
    @Size(max = 45)
    @Column(name = "DIRECCION_MCIA")
    private String direccionMcia;
    @Size(max = 20)
    @Column(name = "NUMEROTEL_MCIA")
    private String numerotelMcia;
    @Size(max = 45)
    @Column(name = "CORREOELEC_MCIA")
    private String correoelecMcia;
    @Size(max = 45)
    @Column(name = "NOMBRECONT_MCIA")
    private String nombrecontMcia;
    @Column(name = "FECHAING_MCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingMcia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMcia")
    private Collection<Maepoliza> maepolizaCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;

    public Maecompania() {
    }

    public Maecompania(Integer idMcia) {
        this.idMcia = idMcia;
    }

    public Integer getIdMcia() {
        return idMcia;
    }

    public void setIdMcia(Integer idMcia) {
        this.idMcia = idMcia;
    }

    public String getCodigoMcia() {
        return codigoMcia;
    }

    public void setCodigoMcia(String codigoMcia) {
        this.codigoMcia = codigoMcia;
    }

    public String getNombreMcia() {
        return nombreMcia;
    }

    public void setNombreMcia(String nombreMcia) {
        this.nombreMcia = nombreMcia;
    }

    public String getDireccionMcia() {
        return direccionMcia;
    }

    public void setDireccionMcia(String direccionMcia) {
        this.direccionMcia = direccionMcia;
    }

    public String getNumerotelMcia() {
        return numerotelMcia;
    }

    public void setNumerotelMcia(String numerotelMcia) {
        this.numerotelMcia = numerotelMcia;
    }

    public String getCorreoelecMcia() {
        return correoelecMcia;
    }

    public void setCorreoelecMcia(String correoelecMcia) {
        this.correoelecMcia = correoelecMcia;
    }

    public String getNombrecontMcia() {
        return nombrecontMcia;
    }

    public void setNombrecontMcia(String nombrecontMcia) {
        this.nombrecontMcia = nombrecontMcia;
    }

    public Date getFechaingMcia() {
        return fechaingMcia;
    }

    public void setFechaingMcia(Date fechaingMcia) {
        this.fechaingMcia = fechaingMcia;
    }

    @XmlTransient
    public Collection<Maepoliza> getMaepolizaCollection() {
        return maepolizaCollection;
    }

    public void setMaepolizaCollection(Collection<Maepoliza> maepolizaCollection) {
        this.maepolizaCollection = maepolizaCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabubigeo getIdUbig() {
        return idUbig;
    }

    public void setIdUbig(Tabubigeo idUbig) {
        this.idUbig = idUbig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMcia != null ? idMcia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maecompania)) {
            return false;
        }
        Maecompania other = (Maecompania) object;
        if ((this.idMcia == null && other.idMcia != null) || (this.idMcia != null && !this.idMcia.equals(other.idMcia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMcia;
    }
    
}
