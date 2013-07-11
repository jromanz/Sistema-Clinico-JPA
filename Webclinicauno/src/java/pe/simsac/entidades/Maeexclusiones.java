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
@Table(name = "maeexclusiones", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeexclusiones.findAll", query = "SELECT m FROM Maeexclusiones m"),
    @NamedQuery(name = "Maeexclusiones.findByIdExcl", query = "SELECT m FROM Maeexclusiones m WHERE m.idExcl = :idExcl"),
    @NamedQuery(name = "Maeexclusiones.findByNombreExcl", query = "SELECT m FROM Maeexclusiones m WHERE m.nombreExcl = :nombreExcl")})
public class Maeexclusiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EXCL")
    private Integer idExcl;
    @Size(max = 200)
    @Column(name = "NOMBRE_EXCL")
    private String nombreExcl;
    @JoinColumn(name = "ID_ESPM", referencedColumnName = "ID_ESPM")
    @ManyToOne(optional = false)
    private Tabespmedica idEspm;
    @JoinColumn(name = "ID_POLI", referencedColumnName = "ID_POLI")
    @ManyToOne(optional = false)
    private Maepoliza idPoli;

    public Maeexclusiones() {
    }

    public Maeexclusiones(Integer idExcl) {
        this.idExcl = idExcl;
    }

    public Integer getIdExcl() {
        return idExcl;
    }

    public void setIdExcl(Integer idExcl) {
        this.idExcl = idExcl;
    }

    public String getNombreExcl() {
        return nombreExcl;
    }

    public void setNombreExcl(String nombreExcl) {
        this.nombreExcl = nombreExcl;
    }

    public Tabespmedica getIdEspm() {
        return idEspm;
    }

    public void setIdEspm(Tabespmedica idEspm) {
        this.idEspm = idEspm;
    }

    public Maepoliza getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(Maepoliza idPoli) {
        this.idPoli = idPoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExcl != null ? idExcl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeexclusiones)) {
            return false;
        }
        Maeexclusiones other = (Maeexclusiones) object;
        if ((this.idExcl == null && other.idExcl != null) || (this.idExcl != null && !this.idExcl.equals(other.idExcl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreExcl;
    }
    
}
