/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maepersonal", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maepersonal.findAll", query = "SELECT m FROM Maepersonal m"),
    @NamedQuery(name = "Maepersonal.findByIdPers", query = "SELECT m FROM Maepersonal m WHERE m.idPers = :idPers"),
    @NamedQuery(name = "Maepersonal.findByCodigoPers", query = "SELECT m FROM Maepersonal m WHERE m.codigoPers = :codigoPers"),
    @NamedQuery(name = "Maepersonal.findByNombrePers", query = "SELECT m FROM Maepersonal m WHERE m.nombrePers = :nombrePers"),
    @NamedQuery(name = "Maepersonal.findByApepaternoPers", query = "SELECT m FROM Maepersonal m WHERE m.apepaternoPers = :apepaternoPers"),
    @NamedQuery(name = "Maepersonal.findByApematernoPers", query = "SELECT m FROM Maepersonal m WHERE m.apematernoPers = :apematernoPers"),
    @NamedQuery(name = "Maepersonal.findByCorreoPers", query = "SELECT m FROM Maepersonal m WHERE m.correoPers = :correoPers"),
    @NamedQuery(name = "Maepersonal.findByDireccionPers", query = "SELECT m FROM Maepersonal m WHERE m.direccionPers = :direccionPers"),
    @NamedQuery(name = "Maepersonal.findByNumerodocPers", query = "SELECT m FROM Maepersonal m WHERE m.numerodocPers = :numerodocPers")})
public class Maepersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERS")
    private Integer idPers;
    @Size(max = 20)
    @Column(name = "CODIGO_PERS")
    private String codigoPers;
    @Size(max = 45)
    @Column(name = "NOMBRE_PERS")
    private String nombrePers;
    @Size(max = 45)
    @Column(name = "APEPATERNO_PERS")
    private String apepaternoPers;
    @Size(max = 45)
    @Column(name = "APEMATERNO_PERS")
    private String apematernoPers;
    @Size(max = 45)
    @Column(name = "CORREO_PERS")
    private String correoPers;
    @Size(max = 100)
    @Column(name = "DIRECCION_PERS")
    private String direccionPers;
    @Size(max = 25)
    @Column(name = "NUMERODOC_PERS")
    private String numerodocPers;
    @JoinColumn(name = "ID_MEMP", referencedColumnName = "ID_MEMP")
    @ManyToOne(optional = false)
    private Maeempresa idMemp;
    @JoinColumn(name = "ID_TDOC", referencedColumnName = "ID_TDOC")
    @ManyToOne(optional = false)
    private Tabtipodocumento idTdoc;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;
    @JoinColumn(name = "ID_ESTC", referencedColumnName = "ID_ESTC")
    @ManyToOne(optional = false)
    private Tabestacivil idEstc;

    public Maepersonal() {
    }

    public Maepersonal(Integer idPers) {
        this.idPers = idPers;
    }

    public Integer getIdPers() {
        return idPers;
    }

    public void setIdPers(Integer idPers) {
        this.idPers = idPers;
    }

    public String getCodigoPers() {
        return codigoPers;
    }

    public void setCodigoPers(String codigoPers) {
        this.codigoPers = codigoPers;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public String getApepaternoPers() {
        return apepaternoPers;
    }

    public void setApepaternoPers(String apepaternoPers) {
        this.apepaternoPers = apepaternoPers;
    }

    public String getApematernoPers() {
        return apematernoPers;
    }

    public void setApematernoPers(String apematernoPers) {
        this.apematernoPers = apematernoPers;
    }

    public String getCorreoPers() {
        return correoPers;
    }

    public void setCorreoPers(String correoPers) {
        this.correoPers = correoPers;
    }

    public String getDireccionPers() {
        return direccionPers;
    }

    public void setDireccionPers(String direccionPers) {
        this.direccionPers = direccionPers;
    }

    public String getNumerodocPers() {
        return numerodocPers;
    }

    public void setNumerodocPers(String numerodocPers) {
        this.numerodocPers = numerodocPers;
    }

    public Maeempresa getIdMemp() {
        return idMemp;
    }

    public void setIdMemp(Maeempresa idMemp) {
        this.idMemp = idMemp;
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

    public Tabestacivil getIdEstc() {
        return idEstc;
    }

    public void setIdEstc(Tabestacivil idEstc) {
        this.idEstc = idEstc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPers != null ? idPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maepersonal)) {
            return false;
        }
        Maepersonal other = (Maepersonal) object;
        if ((this.idPers == null && other.idPers != null) || (this.idPers != null && !this.idPers.equals(other.idPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apepaternoPers+" "+apematernoPers+", "+nombrePers;
    }
    
}
