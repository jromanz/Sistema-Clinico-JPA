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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simsac
 */
@Entity
@Table(name = "maepermiso", catalog = "mysql_17015_simdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maepermiso.findAll", query = "SELECT m FROM Maepermiso m"),
    @NamedQuery(name = "Maepermiso.findByIdPerm", query = "SELECT m FROM Maepermiso m WHERE m.idPerm = :idPerm"),
    @NamedQuery(name = "Maepermiso.findByOpc01", query = "SELECT m FROM Maepermiso m WHERE m.opc01 = :opc01"),
    @NamedQuery(name = "Maepermiso.findByOpc02", query = "SELECT m FROM Maepermiso m WHERE m.opc02 = :opc02"),
    @NamedQuery(name = "Maepermiso.findByOpc03", query = "SELECT m FROM Maepermiso m WHERE m.opc03 = :opc03"),
    @NamedQuery(name = "Maepermiso.findByOpc04", query = "SELECT m FROM Maepermiso m WHERE m.opc04 = :opc04"),
    @NamedQuery(name = "Maepermiso.findByOpc05", query = "SELECT m FROM Maepermiso m WHERE m.opc05 = :opc05"),
    @NamedQuery(name = "Maepermiso.findByOpc06", query = "SELECT m FROM Maepermiso m WHERE m.opc06 = :opc06"),
    @NamedQuery(name = "Maepermiso.findByOpc07", query = "SELECT m FROM Maepermiso m WHERE m.opc07 = :opc07"),
    @NamedQuery(name = "Maepermiso.findByOpc08", query = "SELECT m FROM Maepermiso m WHERE m.opc08 = :opc08"),
    @NamedQuery(name = "Maepermiso.findByOpc09", query = "SELECT m FROM Maepermiso m WHERE m.opc09 = :opc09"),
    @NamedQuery(name = "Maepermiso.findByOpc10", query = "SELECT m FROM Maepermiso m WHERE m.opc10 = :opc10")})
public class Maepermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERM")
    private Integer idPerm;
    @Column(name = "OPC01")
    private Boolean opc01;
    @Column(name = "OPC02")
    private Boolean opc02;
    @Column(name = "OPC03")
    private Boolean opc03;
    @Column(name = "OPC04")
    private Boolean opc04;
    @Column(name = "OPC05")
    private Boolean opc05;
    @Column(name = "OPC06")
    private Boolean opc06;
    @Column(name = "OPC07")
    private Boolean opc07;
    @Column(name = "OPC08")
    private Boolean opc08;
    @Column(name = "OPC09")
    private Boolean opc09;
    @Column(name = "OPC10")
    private Boolean opc10;
    @JoinColumn(name = "ID_TEST", referencedColumnName = "ID_TEST")
    @ManyToOne(optional = false)
    private Tabestado idTest;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(optional = false)
    private Maeroles idRole;
    @JoinColumn(name = "ID_PROG", referencedColumnName = "ID_PROG")
    @ManyToOne(optional = false)
    private Maeprograma idProg;

    public Maepermiso() {
    }

    public Maepermiso(Integer idPerm) {
        this.idPerm = idPerm;
    }

    public Integer getIdPerm() {
        return idPerm;
    }

    public void setIdPerm(Integer idPerm) {
        this.idPerm = idPerm;
    }

    public Boolean getOpc01() {
        return opc01;
    }

    public void setOpc01(Boolean opc01) {
        this.opc01 = opc01;
    }

    public Boolean getOpc02() {
        return opc02;
    }

    public void setOpc02(Boolean opc02) {
        this.opc02 = opc02;
    }

    public Boolean getOpc03() {
        return opc03;
    }

    public void setOpc03(Boolean opc03) {
        this.opc03 = opc03;
    }

    public Boolean getOpc04() {
        return opc04;
    }

    public void setOpc04(Boolean opc04) {
        this.opc04 = opc04;
    }

    public Boolean getOpc05() {
        return opc05;
    }

    public void setOpc05(Boolean opc05) {
        this.opc05 = opc05;
    }

    public Boolean getOpc06() {
        return opc06;
    }

    public void setOpc06(Boolean opc06) {
        this.opc06 = opc06;
    }

    public Boolean getOpc07() {
        return opc07;
    }

    public void setOpc07(Boolean opc07) {
        this.opc07 = opc07;
    }

    public Boolean getOpc08() {
        return opc08;
    }

    public void setOpc08(Boolean opc08) {
        this.opc08 = opc08;
    }

    public Boolean getOpc09() {
        return opc09;
    }

    public void setOpc09(Boolean opc09) {
        this.opc09 = opc09;
    }

    public Boolean getOpc10() {
        return opc10;
    }

    public void setOpc10(Boolean opc10) {
        this.opc10 = opc10;
    }

    public Tabestado getIdTest() {
        return idTest;
    }

    public void setIdTest(Tabestado idTest) {
        this.idTest = idTest;
    }

    public Maeroles getIdRole() {
        return idRole;
    }

    public void setIdRole(Maeroles idRole) {
        this.idRole = idRole;
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
        hash += (idPerm != null ? idPerm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maepermiso)) {
            return false;
        }
        Maepermiso other = (Maepermiso) object;
        if ((this.idPerm == null && other.idPerm != null) || (this.idPerm != null && !this.idPerm.equals(other.idPerm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPerm.toString();
    }
    
}
