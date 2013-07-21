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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "tabestado", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabestado.findAll", query = "SELECT t FROM Tabestado t"),
    @NamedQuery(name = "Tabestado.findByIdTest", query = "SELECT t FROM Tabestado t WHERE t.idTest = :idTest"),
    @NamedQuery(name = "Tabestado.findByNombreTest", query = "SELECT t FROM Tabestado t WHERE t.nombreTest = :nombreTest")})
public class Tabestado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TEST")
    private Integer idTest;
    @Size(max = 45)
    @Column(name = "NOMBRE_TEST")
    private String nombreTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maeprograma> maeprogramaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabpreciomedi> tabpreciomediCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maemedicos> maemedicosCollection;
    @OneToMany(mappedBy = "idTest")
    private Collection<Maeordenaten> maeordenatenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maepaciente> maepacienteCollection;
    @OneToMany(mappedBy = "idTest")
    private Collection<Tabestaregistro> tabestaregistroCollection;
    @OneToMany(mappedBy = "idTest")
    private Collection<Maeregistro> maeregistroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maepermiso> maepermisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabformpago> tabformpagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabcobertura> tabcoberturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabservicio> tabservicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabprecioemed> tabprecioemedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maemodulo> maemoduloCollection;
    @OneToMany(mappedBy = "idTest")
    private Collection<Maeordenserv> maeordenservCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maepoliza> maepolizaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabespmedica> tabespmedicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabpreciotari> tabpreciotariCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabtipotarifario> tabtipotarifarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maeroles> maerolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maetarifario> maetarifarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maecentrabajo> maecentrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabfactortari> tabfactortariCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabmoneda> tabmonedaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabtipoatencion> tabtipoatencionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maecompania> maecompaniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maetarifas> maetarifasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maeempresa> maeempresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maeciamedica> maeciamedicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Tabpreciocmed> tabpreciocmedCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTest")
    private Collection<Maeusurio> maeusurioCollection;

    public Collection<Maeusurio> getMaeusurioCollection() {
        return maeusurioCollection;
    }

    public void setMaeusurioCollection(Collection<Maeusurio> maeusurioCollection) {
        this.maeusurioCollection = maeusurioCollection;
    }
    
    public Tabestado() {
    }

    public Tabestado(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getNombreTest() {
        return nombreTest;
    }

    public void setNombreTest(String nombreTest) {
        this.nombreTest = nombreTest;
    }

    @XmlTransient
    public Collection<Maeprograma> getMaeprogramaCollection() {
        return maeprogramaCollection;
    }

    public void setMaeprogramaCollection(Collection<Maeprograma> maeprogramaCollection) {
        this.maeprogramaCollection = maeprogramaCollection;
    }

    @XmlTransient
    public Collection<Tabpreciomedi> getTabpreciomediCollection() {
        return tabpreciomediCollection;
    }

    public void setTabpreciomediCollection(Collection<Tabpreciomedi> tabpreciomediCollection) {
        this.tabpreciomediCollection = tabpreciomediCollection;
    }

    @XmlTransient
    public Collection<Maemedicos> getMaemedicosCollection() {
        return maemedicosCollection;
    }

    public void setMaemedicosCollection(Collection<Maemedicos> maemedicosCollection) {
        this.maemedicosCollection = maemedicosCollection;
    }

    @XmlTransient
    public Collection<Maeordenaten> getMaeordenatenCollection() {
        return maeordenatenCollection;
    }

    public void setMaeordenatenCollection(Collection<Maeordenaten> maeordenatenCollection) {
        this.maeordenatenCollection = maeordenatenCollection;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
    }

    @XmlTransient
    public Collection<Tabestaregistro> getTabestaregistroCollection() {
        return tabestaregistroCollection;
    }

    public void setTabestaregistroCollection(Collection<Tabestaregistro> tabestaregistroCollection) {
        this.tabestaregistroCollection = tabestaregistroCollection;
    }

    @XmlTransient
    public Collection<Maeregistro> getMaeregistroCollection() {
        return maeregistroCollection;
    }

    public void setMaeregistroCollection(Collection<Maeregistro> maeregistroCollection) {
        this.maeregistroCollection = maeregistroCollection;
    }

    @XmlTransient
    public Collection<Maepermiso> getMaepermisoCollection() {
        return maepermisoCollection;
    }

    public void setMaepermisoCollection(Collection<Maepermiso> maepermisoCollection) {
        this.maepermisoCollection = maepermisoCollection;
    }

    @XmlTransient
    public Collection<Tabformpago> getTabformpagoCollection() {
        return tabformpagoCollection;
    }

    public void setTabformpagoCollection(Collection<Tabformpago> tabformpagoCollection) {
        this.tabformpagoCollection = tabformpagoCollection;
    }

    @XmlTransient
    public Collection<Tabcobertura> getTabcoberturaCollection() {
        return tabcoberturaCollection;
    }

    public void setTabcoberturaCollection(Collection<Tabcobertura> tabcoberturaCollection) {
        this.tabcoberturaCollection = tabcoberturaCollection;
    }

    @XmlTransient
    public Collection<Tabservicio> getTabservicioCollection() {
        return tabservicioCollection;
    }

    public void setTabservicioCollection(Collection<Tabservicio> tabservicioCollection) {
        this.tabservicioCollection = tabservicioCollection;
    }

    @XmlTransient
    public Collection<Tabprecioemed> getTabprecioemedCollection() {
        return tabprecioemedCollection;
    }

    public void setTabprecioemedCollection(Collection<Tabprecioemed> tabprecioemedCollection) {
        this.tabprecioemedCollection = tabprecioemedCollection;
    }

    @XmlTransient
    public Collection<Maemodulo> getMaemoduloCollection() {
        return maemoduloCollection;
    }

    public void setMaemoduloCollection(Collection<Maemodulo> maemoduloCollection) {
        this.maemoduloCollection = maemoduloCollection;
    }

    @XmlTransient
    public Collection<Maeordenserv> getMaeordenservCollection() {
        return maeordenservCollection;
    }

    public void setMaeordenservCollection(Collection<Maeordenserv> maeordenservCollection) {
        this.maeordenservCollection = maeordenservCollection;
    }

    @XmlTransient
    public Collection<Maepoliza> getMaepolizaCollection() {
        return maepolizaCollection;
    }

    public void setMaepolizaCollection(Collection<Maepoliza> maepolizaCollection) {
        this.maepolizaCollection = maepolizaCollection;
    }

    @XmlTransient
    public Collection<Tabespmedica> getTabespmedicaCollection() {
        return tabespmedicaCollection;
    }

    public void setTabespmedicaCollection(Collection<Tabespmedica> tabespmedicaCollection) {
        this.tabespmedicaCollection = tabespmedicaCollection;
    }

    @XmlTransient
    public Collection<Tabpreciotari> getTabpreciotariCollection() {
        return tabpreciotariCollection;
    }

    public void setTabpreciotariCollection(Collection<Tabpreciotari> tabpreciotariCollection) {
        this.tabpreciotariCollection = tabpreciotariCollection;
    }

    @XmlTransient
    public Collection<Tabtipotarifario> getTabtipotarifarioCollection() {
        return tabtipotarifarioCollection;
    }

    public void setTabtipotarifarioCollection(Collection<Tabtipotarifario> tabtipotarifarioCollection) {
        this.tabtipotarifarioCollection = tabtipotarifarioCollection;
    }

    @XmlTransient
    public Collection<Maeroles> getMaerolesCollection() {
        return maerolesCollection;
    }

    public void setMaerolesCollection(Collection<Maeroles> maerolesCollection) {
        this.maerolesCollection = maerolesCollection;
    }

    @XmlTransient
    public Collection<Maetarifario> getMaetarifarioCollection() {
        return maetarifarioCollection;
    }

    public void setMaetarifarioCollection(Collection<Maetarifario> maetarifarioCollection) {
        this.maetarifarioCollection = maetarifarioCollection;
    }

    @XmlTransient
    public Collection<Maecentrabajo> getMaecentrabajoCollection() {
        return maecentrabajoCollection;
    }

    public void setMaecentrabajoCollection(Collection<Maecentrabajo> maecentrabajoCollection) {
        this.maecentrabajoCollection = maecentrabajoCollection;
    }

    @XmlTransient
    public Collection<Tabfactortari> getTabfactortariCollection() {
        return tabfactortariCollection;
    }

    public void setTabfactortariCollection(Collection<Tabfactortari> tabfactortariCollection) {
        this.tabfactortariCollection = tabfactortariCollection;
    }

    @XmlTransient
    public Collection<Tabmoneda> getTabmonedaCollection() {
        return tabmonedaCollection;
    }

    public void setTabmonedaCollection(Collection<Tabmoneda> tabmonedaCollection) {
        this.tabmonedaCollection = tabmonedaCollection;
    }

    @XmlTransient
    public Collection<Tabtipoatencion> getTabtipoatencionCollection() {
        return tabtipoatencionCollection;
    }

    public void setTabtipoatencionCollection(Collection<Tabtipoatencion> tabtipoatencionCollection) {
        this.tabtipoatencionCollection = tabtipoatencionCollection;
    }

    @XmlTransient
    public Collection<Maecompania> getMaecompaniaCollection() {
        return maecompaniaCollection;
    }

    public void setMaecompaniaCollection(Collection<Maecompania> maecompaniaCollection) {
        this.maecompaniaCollection = maecompaniaCollection;
    }

    @XmlTransient
    public Collection<Maetarifas> getMaetarifasCollection() {
        return maetarifasCollection;
    }

    public void setMaetarifasCollection(Collection<Maetarifas> maetarifasCollection) {
        this.maetarifasCollection = maetarifasCollection;
    }

    @XmlTransient
    public Collection<Maeempresa> getMaeempresaCollection() {
        return maeempresaCollection;
    }

    public void setMaeempresaCollection(Collection<Maeempresa> maeempresaCollection) {
        this.maeempresaCollection = maeempresaCollection;
    }

    @XmlTransient
    public Collection<Maeciamedica> getMaeciamedicaCollection() {
        return maeciamedicaCollection;
    }

    public void setMaeciamedicaCollection(Collection<Maeciamedica> maeciamedicaCollection) {
        this.maeciamedicaCollection = maeciamedicaCollection;
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
        hash += (idTest != null ? idTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabestado)) {
            return false;
        }
        Tabestado other = (Tabestado) object;
        if ((this.idTest == null && other.idTest != null) || (this.idTest != null && !this.idTest.equals(other.idTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTest;
    }
    
}
