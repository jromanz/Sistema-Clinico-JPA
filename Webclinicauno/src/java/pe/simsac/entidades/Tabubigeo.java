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
@Table(name = "tabubigeo", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabubigeo.findAll", query = "SELECT t FROM Tabubigeo t"),
    @NamedQuery(name = "Tabubigeo.findByIdUbig", query = "SELECT t FROM Tabubigeo t WHERE t.idUbig = :idUbig"),
    @NamedQuery(name = "Tabubigeo.findByCodigoUbig", query = "SELECT t FROM Tabubigeo t WHERE t.codigoUbig = :codigoUbig"),
    @NamedQuery(name = "Tabubigeo.findByCoddptoUbig", query = "SELECT t FROM Tabubigeo t WHERE t.coddptoUbig = :coddptoUbig"),
    @NamedQuery(name = "Tabubigeo.findByCodprovUbig", query = "SELECT t FROM Tabubigeo t WHERE t.codprovUbig = :codprovUbig"),
    @NamedQuery(name = "Tabubigeo.findByCoddistUbig", query = "SELECT t FROM Tabubigeo t WHERE t.coddistUbig = :coddistUbig"),
    @NamedQuery(name = "Tabubigeo.findByNombreUbig", query = "SELECT t FROM Tabubigeo t WHERE t.nombreUbig = :nombreUbig")})
public class Tabubigeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UBIG")
    private Integer idUbig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODIGO_UBIG")
    private String codigoUbig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODDPTO_UBIG")
    private String coddptoUbig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODPROV_UBIG")
    private String codprovUbig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODDIST_UBIG")
    private String coddistUbig;
    @Size(max = 100)
    @Column(name = "NOMBRE_UBIG")
    private String nombreUbig;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maemedicos> maemedicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maepaciente> maepacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maepersonal> maepersonalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maecentrabajo> maecentrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maecompania> maecompaniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbig")
    private Collection<Maeciamedica> maeciamedicaCollection;

   
    public Tabubigeo() {
    }

    public Tabubigeo(Integer idUbig) {
        this.idUbig = idUbig;
    }

    public Tabubigeo(Integer idUbig, String codigoUbig, String coddptoUbig, String codprovUbig, String coddistUbig) {
        this.idUbig = idUbig;
        this.codigoUbig = codigoUbig;
        this.coddptoUbig = coddptoUbig;
        this.codprovUbig = codprovUbig;
        this.coddistUbig = coddistUbig;
    }

    public Integer getIdUbig() {
        return idUbig;
    }

    public void setIdUbig(Integer idUbig) {
        this.idUbig = idUbig;
    }

    public String getCodigoUbig() {
        return codigoUbig;
    }

    public void setCodigoUbig(String codigoUbig) {
        this.codigoUbig = codigoUbig;
    }

    public String getCoddptoUbig() {
        return coddptoUbig;
    }

    public void setCoddptoUbig(String coddptoUbig) {
        this.coddptoUbig = coddptoUbig;
    }

    public String getCodprovUbig() {
        return codprovUbig;
    }

    public void setCodprovUbig(String codprovUbig) {
        this.codprovUbig = codprovUbig;
    }

    public String getCoddistUbig() {
        return coddistUbig;
    }

    public void setCoddistUbig(String coddistUbig) {
        this.coddistUbig = coddistUbig;
    }

    public String getNombreUbig() {
        return nombreUbig;
    }

    public void setNombreUbig(String nombreUbig) {
        this.nombreUbig = nombreUbig;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
    }

    @XmlTransient
    public Collection<Maepersonal> getMaepersonalCollection() {
        return maepersonalCollection;
    }

    public void setMaepersonalCollection(Collection<Maepersonal> maepersonalCollection) {
        this.maepersonalCollection = maepersonalCollection;
    }

    @XmlTransient
    public Collection<Maecentrabajo> getMaecentrabajoCollection() {
        return maecentrabajoCollection;
    }

    public void setMaecentrabajoCollection(Collection<Maecentrabajo> maecentrabajoCollection) {
        this.maecentrabajoCollection = maecentrabajoCollection;
    }

    @XmlTransient
    public Collection<Maecompania> getMaecompaniaCollection() {
        return maecompaniaCollection;
    }

    public void setMaecompaniaCollection(Collection<Maecompania> maecompaniaCollection) {
        this.maecompaniaCollection = maecompaniaCollection;
    }

    @XmlTransient
    public Collection<Maeciamedica> getMaeciamedicaCollection() {
        return maeciamedicaCollection;
    }

    public void setMaeciamedicaCollection(Collection<Maeciamedica> maeciamedicaCollection) {
        this.maeciamedicaCollection = maeciamedicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbig != null ? idUbig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabubigeo)) {
            return false;
        }
        Tabubigeo other = (Tabubigeo) object;
        if ((this.idUbig == null && other.idUbig != null) || (this.idUbig != null && !this.idUbig.equals(other.idUbig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUbig;
    }
    
}
