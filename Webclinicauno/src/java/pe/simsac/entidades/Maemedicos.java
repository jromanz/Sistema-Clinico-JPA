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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maemedicos", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maemedicos.findAll", query = "SELECT m FROM Maemedicos m"),
    @NamedQuery(name = "Maemedicos.findByIdMmed", query = "SELECT m FROM Maemedicos m WHERE m.idMmed = :idMmed"),
    @NamedQuery(name = "Maemedicos.findByNombreMmed", query = "SELECT m FROM Maemedicos m WHERE m.nombreMmed = :nombreMmed"),
    @NamedQuery(name = "Maemedicos.findByApepaternoMmed", query = "SELECT m FROM Maemedicos m WHERE m.apepaternoMmed = :apepaternoMmed"),
    @NamedQuery(name = "Maemedicos.findByApematernoMmed", query = "SELECT m FROM Maemedicos m WHERE m.apematernoMmed = :apematernoMmed"),
    @NamedQuery(name = "Maemedicos.findByDireccionMmed", query = "SELECT m FROM Maemedicos m WHERE m.direccionMmed = :direccionMmed"),
    @NamedQuery(name = "Maemedicos.findByNumerodocMmed", query = "SELECT m FROM Maemedicos m WHERE m.numerodocMmed = :numerodocMmed"),
    @NamedQuery(name = "Maemedicos.findByNumerorucMmed", query = "SELECT m FROM Maemedicos m WHERE m.numerorucMmed = :numerorucMmed"),
    @NamedQuery(name = "Maemedicos.findByNumerocolegMmed", query = "SELECT m FROM Maemedicos m WHERE m.numerocolegMmed = :numerocolegMmed"),
    @NamedQuery(name = "Maemedicos.findByNumeroespecMmed", query = "SELECT m FROM Maemedicos m WHERE m.numeroespecMmed = :numeroespecMmed"),
    @NamedQuery(name = "Maemedicos.findByNumerotelMmed", query = "SELECT m FROM Maemedicos m WHERE m.numerotelMmed = :numerotelMmed"),
    @NamedQuery(name = "Maemedicos.findByCorreoelecMmed", query = "SELECT m FROM Maemedicos m WHERE m.correoelecMmed = :correoelecMmed"),
    @NamedQuery(name = "Maemedicos.findByFechanacMmed", query = "SELECT m FROM Maemedicos m WHERE m.fechanacMmed = :fechanacMmed"),
    @NamedQuery(name = "Maemedicos.findByFechaingMmed", query = "SELECT m FROM Maemedicos m WHERE m.fechaingMmed = :fechaingMmed"),
    @NamedQuery(name = "Maemedicos.findByNumeroconsMmed", query = "SELECT m FROM Maemedicos m WHERE m.numeroconsMmed = :numeroconsMmed")})
public class Maemedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MMED")
    private Integer idMmed;
    @Size(max = 45)
    @Column(name = "NOMBRE_MMED")
    private String nombreMmed;
    @Size(max = 45)
    @Column(name = "APEPATERNO_MMED")
    private String apepaternoMmed;
    @Size(max = 45)
    @Column(name = "APEMATERNO_MMED")
    private String apematernoMmed;
    @Size(max = 100)
    @Column(name = "DIRECCION_MMED")
    private String direccionMmed;
    @Size(max = 20)
    @Column(name = "NUMERODOC_MMED")
    private String numerodocMmed;
    @Size(max = 11)
    @Column(name = "NUMERORUC_MMED")
    private String numerorucMmed;
    @Size(max = 10)
    @Column(name = "NUMEROCOLEG_MMED")
    private String numerocolegMmed;
    @Size(max = 10)
    @Column(name = "NUMEROESPEC_MMED")
    private String numeroespecMmed;
    @Size(max = 45)
    @Column(name = "NUMEROTEL_MMED")
    private String numerotelMmed;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Correo electrónico no válido usuario@dominio")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "CORREOELEC_MMED")
    private String correoelecMmed;
    @Column(name = "FECHANAC_MMED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacMmed;
    @Column(name = "FECHAING_MMED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingMmed;
    @Size(max = 10)
    @Column(name = "NUMEROCONS_MMED")
    private String numeroconsMmed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMmed")
    private Collection<Tabpreciomedi> tabpreciomediCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_CMED", referencedColumnName = "ID_CMED")
    @ManyToOne
    private Maeciamedica idCmed;
    @JoinColumn(name = "ID_FPAG", referencedColumnName = "ID_FPAG")
    @ManyToOne(optional = false)
    private Tabformpago idFpag;
    @JoinColumn(name = "ID_ESPM", referencedColumnName = "ID_ESPM")
    @ManyToOne(optional = false)
    private Tabespmedica idEspm;
    @JoinColumn(name = "ID_TDOC", referencedColumnName = "ID_TDOC")
    @ManyToOne(optional = false)
    private Tabtipodocumento idTdoc;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMmed")
    private Collection<Maeordenaten> maeordenatenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMmed")
    private Collection<Tabservicio> tabservicioCollection;

    public Maemedicos() {
    }

    public Maemedicos(Integer idMmed) {
        this.idMmed = idMmed;
    }

    public Integer getIdMmed() {
        return idMmed;
    }

    public void setIdMmed(Integer idMmed) {
        this.idMmed = idMmed;
    }

    public String getNombreMmed() {
        return nombreMmed;
    }

    public void setNombreMmed(String nombreMmed) {
        this.nombreMmed = nombreMmed;
    }

    public String getApepaternoMmed() {
        return apepaternoMmed;
    }

    public void setApepaternoMmed(String apepaternoMmed) {
        this.apepaternoMmed = apepaternoMmed;
    }

    public String getApematernoMmed() {
        return apematernoMmed;
    }

    public void setApematernoMmed(String apematernoMmed) {
        this.apematernoMmed = apematernoMmed;
    }

    public String getDireccionMmed() {
        return direccionMmed;
    }

    public void setDireccionMmed(String direccionMmed) {
        this.direccionMmed = direccionMmed;
    }

    public String getNumerodocMmed() {
        return numerodocMmed;
    }

    public void setNumerodocMmed(String numerodocMmed) {
        this.numerodocMmed = numerodocMmed;
    }

    public String getNumerorucMmed() {
        return numerorucMmed;
    }

    public void setNumerorucMmed(String numerorucMmed) {
        this.numerorucMmed = numerorucMmed;
    }

    public String getNumerocolegMmed() {
        return numerocolegMmed;
    }

    public void setNumerocolegMmed(String numerocolegMmed) {
        this.numerocolegMmed = numerocolegMmed;
    }

    public String getNumeroespecMmed() {
        return numeroespecMmed;
    }

    public void setNumeroespecMmed(String numeroespecMmed) {
        this.numeroespecMmed = numeroespecMmed;
    }

    public String getNumerotelMmed() {
        return numerotelMmed;
    }

    public void setNumerotelMmed(String numerotelMmed) {
        this.numerotelMmed = numerotelMmed;
    }

    public String getCorreoelecMmed() {
        return correoelecMmed;
    }

    public void setCorreoelecMmed(String correoelecMmed) {
        this.correoelecMmed = correoelecMmed;
    }

    public Date getFechanacMmed() {
        return fechanacMmed;
    }

    public void setFechanacMmed(Date fechanacMmed) {
        this.fechanacMmed = fechanacMmed;
    }

    public Date getFechaingMmed() {
        return fechaingMmed;
    }

    public void setFechaingMmed(Date fechaingMmed) {
        this.fechaingMmed = fechaingMmed;
    }

    public String getNumeroconsMmed() {
        return numeroconsMmed;
    }

    public void setNumeroconsMmed(String numeroconsMmed) {
        this.numeroconsMmed = numeroconsMmed;
    }

    @XmlTransient
    public Collection<Tabpreciomedi> getTabpreciomediCollection() {
        return tabpreciomediCollection;
    }

    public void setTabpreciomediCollection(Collection<Tabpreciomedi> tabpreciomediCollection) {
        this.tabpreciomediCollection = tabpreciomediCollection;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maeciamedica getIdCmed() {
        return idCmed;
    }

    public void setIdCmed(Maeciamedica idCmed) {
        this.idCmed = idCmed;
    }

    public Tabformpago getIdFpag() {
        return idFpag;
    }

    public void setIdFpag(Tabformpago idFpag) {
        this.idFpag = idFpag;
    }

    public Tabespmedica getIdEspm() {
        return idEspm;
    }

    public void setIdEspm(Tabespmedica idEspm) {
        this.idEspm = idEspm;
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
    public Collection<Maeordenaten> getMaeordenatenCollection() {
        return maeordenatenCollection;
    }

    public void setMaeordenatenCollection(Collection<Maeordenaten> maeordenatenCollection) {
        this.maeordenatenCollection = maeordenatenCollection;
    }

    @XmlTransient
    public Collection<Tabservicio> getTabservicioCollection() {
        return tabservicioCollection;
    }

    public void setTabservicioCollection(Collection<Tabservicio> tabservicioCollection) {
        this.tabservicioCollection = tabservicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMmed != null ? idMmed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maemedicos)) {
            return false;
        }
        Maemedicos other = (Maemedicos) object;
        if ((this.idMmed == null && other.idMmed != null) || (this.idMmed != null && !this.idMmed.equals(other.idMmed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMmed;
    }
}
