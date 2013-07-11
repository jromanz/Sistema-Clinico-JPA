/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.simsac.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maeusurio", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maeusurio.findAll", query = "SELECT m FROM Maeusurio m"),
    @NamedQuery(name = "Maeusurio.findByIdUsua", query = "SELECT m FROM Maeusurio m WHERE m.idUsua = :idUsua"),
    @NamedQuery(name = "Maeusurio.findByLoginUsua", query = "SELECT m FROM Maeusurio m WHERE m.loginUsua = :loginUsua"),
    @NamedQuery(name = "Maeusurio.findByIdTest", query = "SELECT m FROM Maeusurio m WHERE m.idTest = :idTest"),
    @NamedQuery(name = "Maeusurio.findByIdPers", query = "SELECT m FROM Maeusurio m WHERE m.idPers = :idPers"),
    @NamedQuery(name = "Maeusurio.findByFechainicioUsua", query = "SELECT m FROM Maeusurio m WHERE m.fechainicioUsua = :fechainicioUsua"),
    @NamedQuery(name = "Maeusurio.findByFechafinUsua", query = "SELECT m FROM Maeusurio m WHERE m.fechafinUsua = :fechafinUsua"),
    @NamedQuery(name = "Maeusurio.findByClaveUsua", query = "SELECT m FROM Maeusurio m WHERE m.claveUsua = :claveUsua"),
    @NamedQuery(name = "Maeusurio.findByIdRole", query = "SELECT m FROM Maeusurio m WHERE m.idRole = :idRole")})
public class Maeusurio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUA")
    private Integer idUsua;
    @Size(max = 20)
    @Column(name = "LOGIN_USUA")
    private String loginUsua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TEST")
    private int idTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS")
    private int idPers;
    @Column(name = "FECHAINICIO_USUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicioUsua;
    @Column(name = "FECHAFIN_USUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinUsua;
    @Size(max = 100)
    @Column(name = "CLAVE_USUA")
    private String claveUsua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROLE")
    private int idRole;

    public Maeusurio() {
    }

    public Maeusurio(Integer idUsua) {
        this.idUsua = idUsua;
    }

    public Maeusurio(Integer idUsua, int idTest, int idPers, int idRole) {
        this.idUsua = idUsua;
        this.idTest = idTest;
        this.idPers = idPers;
        this.idRole = idRole;
    }

    public Integer getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(Integer idUsua) {
        this.idUsua = idUsua;
    }

    public String getLoginUsua() {
        return loginUsua;
    }

    public void setLoginUsua(String loginUsua) {
        this.loginUsua = loginUsua;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdPers() {
        return idPers;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public Date getFechainicioUsua() {
        return fechainicioUsua;
    }

    public void setFechainicioUsua(Date fechainicioUsua) {
        this.fechainicioUsua = fechainicioUsua;
    }

    public Date getFechafinUsua() {
        return fechafinUsua;
    }

    public void setFechafinUsua(Date fechafinUsua) {
        this.fechafinUsua = fechafinUsua;
    }

    public String getClaveUsua() {
        return claveUsua;
    }

    public void setClaveUsua(String claveUsua) {
        this.claveUsua = claveUsua;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsua != null ? idUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maeusurio)) {
            return false;
        }
        Maeusurio other = (Maeusurio) object;
        if ((this.idUsua == null && other.idUsua != null) || (this.idUsua != null && !this.idUsua.equals(other.idUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return loginUsua;
    }
    
}
