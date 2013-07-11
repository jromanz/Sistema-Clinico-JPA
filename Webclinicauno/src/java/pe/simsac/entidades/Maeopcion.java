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
@Table(name = "maeopcion", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeopcion.findAll", query = "SELECT m FROM Maeopcion m"),
    @NamedQuery(name = "Maeopcion.findByIdOpci", query = "SELECT m FROM Maeopcion m WHERE m.idOpci = :idOpci"),
    @NamedQuery(name = "Maeopcion.findByNombreOpci", query = "SELECT m FROM Maeopcion m WHERE m.nombreOpci = :nombreOpci"),
    @NamedQuery(name = "Maeopcion.findByOp00Opci", query = "SELECT m FROM Maeopcion m WHERE m.op00Opci = :op00Opci")})
public class Maeopcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OPCI")
    private Integer idOpci;
    @Size(max = 20)
    @Column(name = "NOMBRE_OPCI")
    private String nombreOpci;
    @Column(name = "OP00_OPCI")
    private Integer op00Opci;
    @JoinColumn(name = "ID_PROG", referencedColumnName = "ID_PROG")
    @ManyToOne(optional = false)
    private Maeprograma idProg;

    public Maeopcion() {
    }

    public Maeopcion(Integer idOpci) {
        this.idOpci = idOpci;
    }

    public Integer getIdOpci() {
        return idOpci;
    }

    public void setIdOpci(Integer idOpci) {
        this.idOpci = idOpci;
    }

    public String getNombreOpci() {
        return nombreOpci;
    }

    public void setNombreOpci(String nombreOpci) {
        this.nombreOpci = nombreOpci;
    }

    public Integer getOp00Opci() {
        return op00Opci;
    }

    public void setOp00Opci(Integer op00Opci) {
        this.op00Opci = op00Opci;
    }

    public Maeprograma getIdProg() {
        return idProg;
    }

    public void setIdProg(Maeprograma idProg) {
        this.idProg = idProg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpci != null ? idOpci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeopcion)) {
            return false;
        }
        Maeopcion other = (Maeopcion) object;
        if ((this.idOpci == null && other.idOpci != null) || (this.idOpci != null && !this.idOpci.equals(other.idOpci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreOpci;
    }
    
}
