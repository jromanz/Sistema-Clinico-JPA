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
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maepaciente", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maepaciente.findAll", query = "SELECT m FROM Maepaciente m"),
    @NamedQuery(name = "Maepaciente.findByIdPaci", query = "SELECT m FROM Maepaciente m WHERE m.idPaci = :idPaci"),
    @NamedQuery(name = "Maepaciente.findByNumeroPaci", query = "SELECT m FROM Maepaciente m WHERE m.numeroPaci = :numeroPaci"),
    @NamedQuery(name = "Maepaciente.findByNombrePaci", query = "SELECT m FROM Maepaciente m WHERE m.nombrePaci = :nombrePaci"),
    @NamedQuery(name = "Maepaciente.findByApepaternoPaci", query = "SELECT m FROM Maepaciente m WHERE m.apepaternoPaci = :apepaternoPaci"),
    @NamedQuery(name = "Maepaciente.findByApematernoPaci", query = "SELECT m FROM Maepaciente m WHERE m.apematernoPaci = :apematernoPaci"),
    @NamedQuery(name = "Maepaciente.findByFechaingPaci", query = "SELECT m FROM Maepaciente m WHERE m.fechaingPaci = :fechaingPaci"),
    @NamedQuery(name = "Maepaciente.findByDireccionPaci", query = "SELECT m FROM Maepaciente m WHERE m.direccionPaci = :direccionPaci"),
    @NamedQuery(name = "Maepaciente.findByNumerotelPaci", query = "SELECT m FROM Maepaciente m WHERE m.numerotelPaci = :numerotelPaci"),
    @NamedQuery(name = "Maepaciente.findByCorreoelecPaci", query = "SELECT m FROM Maepaciente m WHERE m.correoelecPaci = :correoelecPaci"),
    @NamedQuery(name = "Maepaciente.findBySexoPaci", query = "SELECT m FROM Maepaciente m WHERE m.sexoPaci = :sexoPaci"),
    @NamedQuery(name = "Maepaciente.findByNumerodocPaci", query = "SELECT m FROM Maepaciente m WHERE m.numerodocPaci = :numerodocPaci"),
    @NamedQuery(name = "Maepaciente.findByApppatertitPaci", query = "SELECT m FROM Maepaciente m WHERE m.apppatertitPaci = :apppatertitPaci"),
    @NamedQuery(name = "Maepaciente.findByAppmatertitPaci", query = "SELECT m FROM Maepaciente m WHERE m.appmatertitPaci = :appmatertitPaci"),
    @NamedQuery(name = "Maepaciente.findByNombretitPaci", query = "SELECT m FROM Maepaciente m WHERE m.nombretitPaci = :nombretitPaci")})
public class Maepaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PACI")
    private Integer idPaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMERO_PACI")
    private String numeroPaci;
    @Size(max = 45)
    @Column(name = "NOMBRE_PACI")
    private String nombrePaci;
    @Size(max = 45)
    @Column(name = "APEPATERNO_PACI")
    private String apepaternoPaci;
    @Size(max = 45)
    @Column(name = "APEMATERNO_PACI")
    private String apematernoPaci;
    @Column(name = "FECHAING_PACI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPaci;
    @Size(max = 100)
    @Column(name = "DIRECCION_PACI")
    private String direccionPaci;
    @Size(max = 20)
    @Column(name = "NUMEROTEL_PACI")
    private String numerotelPaci;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Correo electrónico no válido usuario@dominio")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "CORREOELEC_PACI")
    private String correoelecPaci;
    @Column(name = "SEXO_PACI")
    private Integer sexoPaci;
    @Size(max = 20)
    @Column(name = "NUMERODOC_PACI")
    private String numerodocPaci;
    @Size(max = 45)
    @Column(name = "APPPATERTIT_PACI")
    private String apppatertitPaci;
    @Size(max = 45)
    @Column(name = "APPMATERTIT_PACI")
    private String appmatertitPaci;
    @Size(max = 45)
    @Column(name = "NOMBRETIT_PACI")
    private String nombretitPaci;
    @JoinColumn(name = "ID_PCLI", referencedColumnName = "ID_POLI")
    @ManyToOne(optional = false)
    private Maepoliza idPcli;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_CTRA", referencedColumnName = "ID_CTRA")
    @ManyToOne
    private Maecentrabajo idCtra;
    
    @OneToMany(mappedBy = "idTitu")
    private Collection<Maepaciente> maepacienteCollection;
    
    @JoinColumn(name = "ID_TITU", referencedColumnName = "ID_PACI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Maepaciente idTitu;
    
    @JoinColumn(name = "ID_TPAR", referencedColumnName = "ID_TPAR")
    @ManyToOne(optional = false)
    private Tabparentesco idTpar;
    @JoinColumn(name = "ID_CATP", referencedColumnName = "ID_CATP")
    @ManyToOne(optional = false)
    private Tabcategpaci idCatp;
    @JoinColumn(name = "ID_TDOC", referencedColumnName = "ID_TDOC")
    @ManyToOne(optional = false)
    private Tabtipodocumento idTdoc;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaci")
    private Collection<Maeregistro> maeregistroCollection;

    public Maepaciente() {
    }

    public Maepaciente(Integer idPaci) {
        this.idPaci = idPaci;
    }

    public Maepaciente(Integer idPaci, String numeroPaci) {
        this.idPaci = idPaci;
        this.numeroPaci = numeroPaci;
    }

    public Integer getIdPaci() {
        return idPaci;
    }

    public void setIdPaci(Integer idPaci) {
        this.idPaci = idPaci;
    }

    public String getNumeroPaci() {
        return numeroPaci;
    }

    public void setNumeroPaci(String numeroPaci) {
        this.numeroPaci = numeroPaci;
    }

    public String getNombrePaci() {
        return nombrePaci;
    }

    public void setNombrePaci(String nombrePaci) {
        this.nombrePaci = nombrePaci;
    }

    public String getApepaternoPaci() {
        return apepaternoPaci;
    }

    public void setApepaternoPaci(String apepaternoPaci) {
        this.apepaternoPaci = apepaternoPaci;
    }

    public String getApematernoPaci() {
        return apematernoPaci;
    }

    public void setApematernoPaci(String apematernoPaci) {
        this.apematernoPaci = apematernoPaci;
    }

    public Date getFechaingPaci() {
        return fechaingPaci;
    }

    public void setFechaingPaci(Date fechaingPaci) {
        this.fechaingPaci = fechaingPaci;
    }

    public String getDireccionPaci() {
        return direccionPaci;
    }

    public void setDireccionPaci(String direccionPaci) {
        this.direccionPaci = direccionPaci;
    }

    public String getNumerotelPaci() {
        return numerotelPaci;
    }

    public void setNumerotelPaci(String numerotelPaci) {
        this.numerotelPaci = numerotelPaci;
    }

    public String getCorreoelecPaci() {
        return correoelecPaci;
    }

    public void setCorreoelecPaci(String correoelecPaci) {
        this.correoelecPaci = correoelecPaci;
    }

    public Integer getSexoPaci() {
        return sexoPaci;
    }

    public void setSexoPaci(Integer sexoPaci) {
        this.sexoPaci = sexoPaci;
    }

    public String getNumerodocPaci() {
        return numerodocPaci;
    }

    public void setNumerodocPaci(String numerodocPaci) {
        this.numerodocPaci = numerodocPaci;
    }

    public String getApppatertitPaci() {
        return apppatertitPaci;
    }

    public void setApppatertitPaci(String apppatertitPaci) {
        this.apppatertitPaci = apppatertitPaci;
    }

    public String getAppmatertitPaci() {
        return appmatertitPaci;
    }

    public void setAppmatertitPaci(String appmatertitPaci) {
        this.appmatertitPaci = appmatertitPaci;
    }

    public String getNombretitPaci() {
        return nombretitPaci;
    }

    public void setNombretitPaci(String nombretitPaci) {
        this.nombretitPaci = nombretitPaci;
    }

    public Maepoliza getIdPcli() {
        return idPcli;
    }

    public void setIdPcli(Maepoliza idPcli) {
        this.idPcli = idPcli;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maecentrabajo getIdCtra() {
        return idCtra;
    }

    public void setIdCtra(Maecentrabajo idCtra) {
        this.idCtra = idCtra;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
    }

    public Maepaciente getIdTitu() {
        return idTitu;
    }

    public void setIdTitu(Maepaciente idTitu) {
        this.idTitu = idTitu;
    }

    public Tabparentesco getIdTpar() {
        return idTpar;
    }

    public void setIdTpar(Tabparentesco idTpar) {
        this.idTpar = idTpar;
    }

    public Tabcategpaci getIdCatp() {
        return idCatp;
    }

    public void setIdCatp(Tabcategpaci idCatp) {
        this.idCatp = idCatp;
    }

    public Tabtipodocumento getIdTdoc() {
        return idTdoc;
    }

    public void setIdTdoc(Tabtipodocumento idTdoc) {
        this.idTdoc = idTdoc;
    }

    public Tabubigeo getIdUbig() {
        return idUbig;
    }

    public void setIdUbig(Tabubigeo idUbig) {
        this.idUbig = idUbig;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaci != null ? idPaci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maepaciente)) {
            return false;
        }
        Maepaciente other = (Maepaciente) object;
        if ((this.idPaci == null && other.idPaci != null) || (this.idPaci != null && !this.idPaci.equals(other.idPaci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apepaternoPaci + " " + apematernoPaci + ", " + nombrePaci;
    }
}
