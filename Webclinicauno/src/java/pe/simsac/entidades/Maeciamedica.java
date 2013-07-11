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
@Table(name = "maeciamedica", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeciamedica.findAll", query = "SELECT m FROM Maeciamedica m"),
    @NamedQuery(name = "Maeciamedica.findByIdCmed", query = "SELECT m FROM Maeciamedica m WHERE m.idCmed = :idCmed"),
    @NamedQuery(name = "Maeciamedica.findByNombreCmed", query = "SELECT m FROM Maeciamedica m WHERE m.nombreCmed = :nombreCmed"),
    @NamedQuery(name = "Maeciamedica.findByNumerorucCmed", query = "SELECT m FROM Maeciamedica m WHERE m.numerorucCmed = :numerorucCmed"),
    @NamedQuery(name = "Maeciamedica.findByDireccionCmed", query = "SELECT m FROM Maeciamedica m WHERE m.direccionCmed = :direccionCmed"),
    @NamedQuery(name = "Maeciamedica.findByNumerotelCmed", query = "SELECT m FROM Maeciamedica m WHERE m.numerotelCmed = :numerotelCmed"),
    @NamedQuery(name = "Maeciamedica.findByCorreoelecCmed", query = "SELECT m FROM Maeciamedica m WHERE m.correoelecCmed = :correoelecCmed"),
    @NamedQuery(name = "Maeciamedica.findByFechaingCmed", query = "SELECT m FROM Maeciamedica m WHERE m.fechaingCmed = :fechaingCmed")})
public class Maeciamedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CMED")
    private Integer idCmed;
    @Size(max = 45)
    @Column(name = "NOMBRE_CMED")
    private String nombreCmed;
    @Size(max = 11)
    @Column(name = "NUMERORUC_CMED")
    private String numerorucCmed;
    @Size(max = 100)
    @Column(name = "DIRECCION_CMED")
    private String direccionCmed;
    @Size(max = 45)
    @Column(name = "NUMEROTEL_CMED")
    private String numerotelCmed;
    @Size(max = 45)
    @Column(name = "CORREOELEC_CMED")
    private String correoelecCmed;
    @Column(name = "FECHAING_CMED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingCmed;
    @OneToMany(mappedBy = "idCmed")
    private Collection<Maemedicos> maemedicosCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_FPAG", referencedColumnName = "ID_FPAG")
    @ManyToOne(optional = false)
    private Tabformpago idFpag;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCmed")
    private Collection<Tabpreciocmed> tabpreciocmedCollection;

    public Maeciamedica() {
    }

    public Maeciamedica(Integer idCmed) {
        this.idCmed = idCmed;
    }

    public Integer getIdCmed() {
        return idCmed;
    }

    public void setIdCmed(Integer idCmed) {
        this.idCmed = idCmed;
    }

    public String getNombreCmed() {
        return nombreCmed;
    }

    public void setNombreCmed(String nombreCmed) {
        this.nombreCmed = nombreCmed;
    }

    public String getNumerorucCmed() {
        return numerorucCmed;
    }

    public void setNumerorucCmed(String numerorucCmed) {
        this.numerorucCmed = numerorucCmed;
    }

    public String getDireccionCmed() {
        return direccionCmed;
    }

    public void setDireccionCmed(String direccionCmed) {
        this.direccionCmed = direccionCmed;
    }

    public String getNumerotelCmed() {
        return numerotelCmed;
    }

    public void setNumerotelCmed(String numerotelCmed) {
        this.numerotelCmed = numerotelCmed;
    }

    public String getCorreoelecCmed() {
        return correoelecCmed;
    }

    public void setCorreoelecCmed(String correoelecCmed) {
        this.correoelecCmed = correoelecCmed;
    }

    public Date getFechaingCmed() {
        return fechaingCmed;
    }

    public void setFechaingCmed(Date fechaingCmed) {
        this.fechaingCmed = fechaingCmed;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Tabformpago getIdFpag() {
        return idFpag;
    }

    public void setIdFpag(Tabformpago idFpag) {
        this.idFpag = idFpag;
    }

    public Tabubigeo getIdUbig() {
        return idUbig;
    }

    public void setIdUbig(Tabubigeo idUbig) {
        this.idUbig = idUbig;
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
        hash += (idCmed != null ? idCmed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeciamedica)) {
            return false;
        }
        Maeciamedica other = (Maeciamedica) object;
        if ((this.idCmed == null && other.idCmed != null) || (this.idCmed != null && !this.idCmed.equals(other.idCmed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCmed;
    }
    
}
