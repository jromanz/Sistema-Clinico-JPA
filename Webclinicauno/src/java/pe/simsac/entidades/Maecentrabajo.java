/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "maecentrabajo", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maecentrabajo.findAll", query = "SELECT m FROM Maecentrabajo m"),
    @NamedQuery(name = "Maecentrabajo.findByIdCtra", query = "SELECT m FROM Maecentrabajo m WHERE m.idCtra = :idCtra"),
    @NamedQuery(name = "Maecentrabajo.findByNumerorucCtra", query = "SELECT m FROM Maecentrabajo m WHERE m.numerorucCtra = :numerorucCtra"),
    @NamedQuery(name = "Maecentrabajo.findByNombreCtra", query = "SELECT m FROM Maecentrabajo m WHERE m.nombreCtra = :nombreCtra"),
    @NamedQuery(name = "Maecentrabajo.findByDireccionCtra", query = "SELECT m FROM Maecentrabajo m WHERE m.direccionCtra = :direccionCtra"),
    @NamedQuery(name = "Maecentrabajo.findByNumerotelCtra", query = "SELECT m FROM Maecentrabajo m WHERE m.numerotelCtra = :numerotelCtra")})
public class Maecentrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CTRA")
    private Integer idCtra;
    @Size(max = 11)
    @Column(name = "NUMERORUC_CTRA")
    private String numerorucCtra;
    @Size(max = 100)
    @Column(name = "NOMBRE_CTRA")
    private String nombreCtra;
    @Size(max = 100)
    @Column(name = "DIRECCION_CTRA")
    private String direccionCtra;
    @Size(max = 20)
    @Column(name = "NUMEROTEL_CTRA")
    private String numerotelCtra;
    @OneToMany(mappedBy = "idCtra")
    private Collection<Maepaciente> maepacienteCollection;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_UBIG", referencedColumnName = "ID_UBIG")
    @ManyToOne(optional = false)
    private Tabubigeo idUbig;

    public Maecentrabajo() {
    }

    public Maecentrabajo(Integer idCtra) {
        this.idCtra = idCtra;
    }

    public Integer getIdCtra() {
        return idCtra;
    }

    public void setIdCtra(Integer idCtra) {
        this.idCtra = idCtra;
    }

    public String getNumerorucCtra() {
        return numerorucCtra;
    }

    public void setNumerorucCtra(String numerorucCtra) {
        this.numerorucCtra = numerorucCtra;
    }

    public String getNombreCtra() {
        return nombreCtra;
    }

    public void setNombreCtra(String nombreCtra) {
        this.nombreCtra = nombreCtra;
    }

    public String getDireccionCtra() {
        return direccionCtra;
    }

    public void setDireccionCtra(String direccionCtra) {
        this.direccionCtra = direccionCtra;
    }

    public String getNumerotelCtra() {
        return numerotelCtra;
    }

    public void setNumerotelCtra(String numerotelCtra) {
        this.numerotelCtra = numerotelCtra;
    }

    @XmlTransient
    public Collection<Maepaciente> getMaepacienteCollection() {
        return maepacienteCollection;
    }

    public void setMaepacienteCollection(Collection<Maepaciente> maepacienteCollection) {
        this.maepacienteCollection = maepacienteCollection;
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
        hash += (idCtra != null ? idCtra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maecentrabajo)) {
            return false;
        }
        Maecentrabajo other = (Maecentrabajo) object;
        if ((this.idCtra == null && other.idCtra != null) || (this.idCtra != null && !this.idCtra.equals(other.idCtra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCtra;
    }
    
}
