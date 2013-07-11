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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeprograma", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeprograma.findAll", query = "SELECT m FROM Maeprograma m"),
    @NamedQuery(name = "Maeprograma.findByIdProg", query = "SELECT m FROM Maeprograma m WHERE m.idProg = :idProg"),
    @NamedQuery(name = "Maeprograma.findByNombreProg", query = "SELECT m FROM Maeprograma m WHERE m.nombreProg = :nombreProg"),
    @NamedQuery(name = "Maeprograma.findByFlgventanaProg", query = "SELECT m FROM Maeprograma m WHERE m.flgventanaProg = :flgventanaProg"),
    @NamedQuery(name = "Maeprograma.findByObjetoProg", query = "SELECT m FROM Maeprograma m WHERE m.objetoProg = :objetoProg"),
    @NamedQuery(name = "Maeprograma.findByIconoProg", query = "SELECT m FROM Maeprograma m WHERE m.iconoProg = :iconoProg")})
public class Maeprograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROG")
    private Integer idProg;
    @Size(max = 45)
    @Column(name = "NOMBRE_PROG")
    private String nombreProg;
    @Column(name = "FLGVENTANA_PROG")
    private Boolean flgventanaProg;
    @Size(max = 200)
    @Column(name = "OBJETO_PROG")
    private String objetoProg;
    @Size(max = 200)
    @Column(name = "ICONO_PROG")
    private String iconoProg;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_MODU", referencedColumnName = "ID_MODU")
    @ManyToOne(optional = false)
    private Maemodulo idModu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPadre")
    private Collection<Maeprograma> maeprogramaCollection;
    @JoinColumn(name = "ID_PADRE", referencedColumnName = "ID_PROG")
    @ManyToOne(optional = false)
    private Maeprograma idPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProg")
    private Collection<Maeopcion> maeopcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProg")
    private Collection<Maepermiso> maepermisoCollection;

    public Maeprograma() {
    }

    public Maeprograma(Integer idProg) {
        this.idProg = idProg;
    }

    public Integer getIdProg() {
        return idProg;
    }

    public void setIdProg(Integer idProg) {
        this.idProg = idProg;
    }

    public String getNombreProg() {
        return nombreProg;
    }

    public void setNombreProg(String nombreProg) {
        this.nombreProg = nombreProg;
    }

    public Boolean getFlgventanaProg() {
        return flgventanaProg;
    }

    public void setFlgventanaProg(Boolean flgventanaProg) {
        this.flgventanaProg = flgventanaProg;
    }

    public String getObjetoProg() {
        return objetoProg;
    }

    public void setObjetoProg(String objetoProg) {
        this.objetoProg = objetoProg;
    }

    public String getIconoProg() {
        return iconoProg;
    }

    public void setIconoProg(String iconoProg) {
        this.iconoProg = iconoProg;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maemodulo getIdModu() {
        return idModu;
    }

    public void setIdModu(Maemodulo idModu) {
        this.idModu = idModu;
    }

    @XmlTransient
    public Collection<Maeprograma> getMaeprogramaCollection() {
        return maeprogramaCollection;
    }

    public void setMaeprogramaCollection(Collection<Maeprograma> maeprogramaCollection) {
        this.maeprogramaCollection = maeprogramaCollection;
    }

    public Maeprograma getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Maeprograma idPadre) {
        this.idPadre = idPadre;
    }

    @XmlTransient
    public Collection<Maeopcion> getMaeopcionCollection() {
        return maeopcionCollection;
    }

    public void setMaeopcionCollection(Collection<Maeopcion> maeopcionCollection) {
        this.maeopcionCollection = maeopcionCollection;
    }

    @XmlTransient
    public Collection<Maepermiso> getMaepermisoCollection() {
        return maepermisoCollection;
    }

    public void setMaepermisoCollection(Collection<Maepermiso> maepermisoCollection) {
        this.maepermisoCollection = maepermisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProg != null ? idProg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeprograma)) {
            return false;
        }
        Maeprograma other = (Maeprograma) object;
        if ((this.idProg == null && other.idProg != null) || (this.idProg != null && !this.idProg.equals(other.idProg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreProg;
    }
    
}
