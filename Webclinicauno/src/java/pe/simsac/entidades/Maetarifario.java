/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maetarifario", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maetarifario.findAll", query = "SELECT m FROM Maetarifario m"),
    @NamedQuery(name = "Maetarifario.findByIdMtar", query = "SELECT m FROM Maetarifario m WHERE m.idMtar = :idMtar"),
    @NamedQuery(name = "Maetarifario.findByCodsegusnMtar", query = "SELECT m FROM Maetarifario m WHERE m.codsegusnMtar = :codsegusnMtar"),
    @NamedQuery(name = "Maetarifario.findByCodsegusMtar", query = "SELECT m FROM Maetarifario m WHERE m.codsegusMtar = :codsegusMtar"),
    @NamedQuery(name = "Maetarifario.findByFlgtituloMtar", query = "SELECT m FROM Maetarifario m WHERE m.flgtituloMtar = :flgtituloMtar"),
    @NamedQuery(name = "Maetarifario.findByNombreMtar", query = "SELECT m FROM Maetarifario m WHERE m.nombreMtar = :nombreMtar"),
    @NamedQuery(name = "Maetarifario.findByUnidadMtar", query = "SELECT m FROM Maetarifario m WHERE m.unidadMtar = :unidadMtar"),
    @NamedQuery(name = "Maetarifario.findByAyudantiaMtar", query = "SELECT m FROM Maetarifario m WHERE m.ayudantiaMtar = :ayudantiaMtar"),
    @NamedQuery(name = "Maetarifario.findByInstrumentistaMtar", query = "SELECT m FROM Maetarifario m WHERE m.instrumentistaMtar = :instrumentistaMtar"),
    @NamedQuery(name = "Maetarifario.findByDiashospitalMtar", query = "SELECT m FROM Maetarifario m WHERE m.diashospitalMtar = :diashospitalMtar"),
    @NamedQuery(name = "Maetarifario.findBySexoMtar", query = "SELECT m FROM Maetarifario m WHERE m.sexoMtar = :sexoMtar"),
    @NamedQuery(name = "Maetarifario.findByEdadminMtar", query = "SELECT m FROM Maetarifario m WHERE m.edadminMtar = :edadminMtar"),
    @NamedQuery(name = "Maetarifario.findByEdadmaxMtar", query = "SELECT m FROM Maetarifario m WHERE m.edadmaxMtar = :edadmaxMtar")})
public class Maetarifario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MTAR")
    private Integer idMtar;
    @Size(max = 10)
    @Column(name = "CODSEGUSN_MTAR")
    private String codsegusnMtar;
    @Size(max = 10)
    @Column(name = "CODSEGUS_MTAR")
    private String codsegusMtar;
    @Column(name = "FLGTITULO_MTAR")
    private Boolean flgtituloMtar;
    @Size(max = 250)
    @Column(name = "NOMBRE_MTAR")
    private String nombreMtar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNIDAD_MTAR")
    private BigDecimal unidadMtar;
    @Column(name = "AYUDANTIA_MTAR")
    private Integer ayudantiaMtar;
    @Column(name = "INSTRUMENTISTA_MTAR")
    private Integer instrumentistaMtar;
    @Column(name = "DIASHOSPITAL_MTAR")
    private Integer diashospitalMtar;
    @Column(name = "SEXO_MTAR")
    private Integer sexoMtar;
    @Column(name = "EDADMIN_MTAR")
    private Integer edadminMtar;
    @Column(name = "EDADMAX_MTAR")
    private Integer edadmaxMtar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Tabpreciomedi> tabpreciomediCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Detordenserv> detordenservCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsulMtar")
    private Collection<Tabcobertura> tabcoberturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Tabprecioemed> tabprecioemedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Tabpreciotari> tabpreciotariCollection;
    @JoinColumn(name = "ID_ESPM", referencedColumnName = "ID_ESPM")
    @ManyToOne
    private Tabespmedica idEspm;
    @JoinColumn(name = "ID_SERV", referencedColumnName = "ID_SERV")
    @ManyToOne(optional = false)
    private Tabservicio idServ;
    @JoinColumn(name = "ID_TTAR", referencedColumnName = "ID_TTAR")
    @ManyToOne(optional = false)
    private Tabtipotarifario idTtar;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Dethoteleria> dethoteleriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMtar")
    private Collection<Tabpreciocmed> tabpreciocmedCollection;

    public Maetarifario() {
    }

    public Maetarifario(Integer idMtar) {
        this.idMtar = idMtar;
    }

    public Integer getIdMtar() {
        return idMtar;
    }

    public void setIdMtar(Integer idMtar) {
        this.idMtar = idMtar;
    }

    public String getCodsegusnMtar() {
        return codsegusnMtar;
    }

    public void setCodsegusnMtar(String codsegusnMtar) {
        this.codsegusnMtar = codsegusnMtar;
    }

    public String getCodsegusMtar() {
        return codsegusMtar;
    }

    public void setCodsegusMtar(String codsegusMtar) {
        this.codsegusMtar = codsegusMtar;
    }

    public Boolean getFlgtituloMtar() {
        return flgtituloMtar;
    }

    public void setFlgtituloMtar(Boolean flgtituloMtar) {
        this.flgtituloMtar = flgtituloMtar;
    }

    public String getNombreMtar() {
        return nombreMtar;
    }

    public void setNombreMtar(String nombreMtar) {
        this.nombreMtar = nombreMtar;
    }

    public BigDecimal getUnidadMtar() {
        return unidadMtar;
    }

    public void setUnidadMtar(BigDecimal unidadMtar) {
        this.unidadMtar = unidadMtar;
    }

    public Integer getAyudantiaMtar() {
        return ayudantiaMtar;
    }

    public void setAyudantiaMtar(Integer ayudantiaMtar) {
        this.ayudantiaMtar = ayudantiaMtar;
    }

    public Integer getInstrumentistaMtar() {
        return instrumentistaMtar;
    }

    public void setInstrumentistaMtar(Integer instrumentistaMtar) {
        this.instrumentistaMtar = instrumentistaMtar;
    }

    public Integer getDiashospitalMtar() {
        return diashospitalMtar;
    }

    public void setDiashospitalMtar(Integer diashospitalMtar) {
        this.diashospitalMtar = diashospitalMtar;
    }

    public Integer getSexoMtar() {
        return sexoMtar;
    }

    public void setSexoMtar(Integer sexoMtar) {
        this.sexoMtar = sexoMtar;
    }

    public Integer getEdadminMtar() {
        return edadminMtar;
    }

    public void setEdadminMtar(Integer edadminMtar) {
        this.edadminMtar = edadminMtar;
    }

    public Integer getEdadmaxMtar() {
        return edadmaxMtar;
    }

    public void setEdadmaxMtar(Integer edadmaxMtar) {
        this.edadmaxMtar = edadmaxMtar;
    }

    @XmlTransient
    public Collection<Tabpreciomedi> getTabpreciomediCollection() {
        return tabpreciomediCollection;
    }

    public void setTabpreciomediCollection(Collection<Tabpreciomedi> tabpreciomediCollection) {
        this.tabpreciomediCollection = tabpreciomediCollection;
    }

    @XmlTransient
    public Collection<Detordenserv> getDetordenservCollection() {
        return detordenservCollection;
    }

    public void setDetordenservCollection(Collection<Detordenserv> detordenservCollection) {
        this.detordenservCollection = detordenservCollection;
    }

    @XmlTransient
    public Collection<Tabcobertura> getTabcoberturaCollection() {
        return tabcoberturaCollection;
    }

    public void setTabcoberturaCollection(Collection<Tabcobertura> tabcoberturaCollection) {
        this.tabcoberturaCollection = tabcoberturaCollection;
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

    public Tabespmedica getIdEspm() {
        return idEspm;
    }

    public void setIdEspm(Tabespmedica idEspm) {
        this.idEspm = idEspm;
    }

    public Tabservicio getIdServ() {
        return idServ;
    }

    public void setIdServ(Tabservicio idServ) {
        this.idServ = idServ;
    }

    public Tabtipotarifario getIdTtar() {
        return idTtar;
    }

    public void setIdTtar(Tabtipotarifario idTtar) {
        this.idTtar = idTtar;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public Collection<Dethoteleria> getDethoteleriaCollection() {
        return dethoteleriaCollection;
    }

    public void setDethoteleriaCollection(Collection<Dethoteleria> dethoteleriaCollection) {
        this.dethoteleriaCollection = dethoteleriaCollection;
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
        hash += (idMtar != null ? idMtar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maetarifario)) {
            return false;
        }
        Maetarifario other = (Maetarifario) object;
        if ((this.idMtar == null && other.idMtar != null) || (this.idMtar != null && !this.idMtar.equals(other.idMtar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMtar;
    }
    
}
