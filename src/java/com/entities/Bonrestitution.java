/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "BONRESTITUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonrestitution.findAll", query = "SELECT b FROM Bonrestitution b")
    , @NamedQuery(name = "Bonrestitution.findByvaliderMagasin", query = "select b from Bonrestitution b where b.valider= :valider  and b.idcodemagasin in (select m from Magasin m where m.idcodemagasin =:magasin)")
    , @NamedQuery(name = "Bonrestitution.findByvaliderPoste", query = "select b from Bonrestitution b where b.valider= :valider and b.poste in (select p from Postedetravail p where p.idposte =:poste)")
    , @NamedQuery(name = "Bonrestitution.findByIdbonrestitution", query = "SELECT b FROM Bonrestitution b WHERE b.idbonrestitution = :idbonrestitution")
    , @NamedQuery(name = "Bonrestitution.findByLibellebonrestitution", query = "SELECT b FROM Bonrestitution b WHERE b.libellebonrestitution = :libellebonrestitution")
    , @NamedQuery(name = "Bonrestitution.findByCreele", query = "SELECT b FROM Bonrestitution b WHERE b.creele = :creele")
    , @NamedQuery(name = "Bonrestitution.findByCreepar", query = "SELECT b FROM Bonrestitution b WHERE b.creepar = :creepar")
    , @NamedQuery(name = "Bonrestitution.findByModifiepar", query = "SELECT b FROM Bonrestitution b WHERE b.modifiepar = :modifiepar")
    , @NamedQuery(name = "Bonrestitution.findByModifiele", query = "SELECT b FROM Bonrestitution b WHERE b.modifiele = :modifiele")})
public class Bonrestitution implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBONRESTITUTION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bonrestitution_seq")
    @SequenceGenerator(
            name = "bonrestitution_seq",
            sequenceName = "bonrestitution_id_seq",
            allocationSize = 1
    )
    private BigDecimal idbonrestitution;
    @Size(max = 100)
    @Column(name = "LIBELLEBONRESTITUTION")
    private String libellebonrestitution;
    @Column(name = "VALIDER")
    private String valider = "false";
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 30)
    @Column(name = "CREEPAR")
    private String creepar;
    @Size(max = 30)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin idcodemagasin;
    @JoinColumn(name = "IDPOSTE", referencedColumnName = "IDPOSTE")
    @ManyToOne(optional = false)
    private Postedetravail poste;

    public Bonrestitution() {
    }

    public Bonrestitution(BigDecimal idbonrestitution) {
        this.idbonrestitution = idbonrestitution;
    }

    public BigDecimal getIdbonrestitution() {
        return idbonrestitution;
    }

    public void setIdbonrestitution(BigDecimal idbonrestitution) {
        this.idbonrestitution = idbonrestitution;
    }

    public String getLibellebonrestitution() {
        return libellebonrestitution;
    }

    public void setLibellebonrestitution(String libellebonrestitution) {
        this.libellebonrestitution = libellebonrestitution;
    }

    public Date getCreele() {
        return creele;
    }

    public void setCreele(Date creele) {
        this.creele = creele;
    }

    public String getCreepar() {
        return creepar;
    }

    public void setCreepar(String creepar) {
        this.creepar = creepar;
    }

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Date getModifiele() {
        return modifiele;
    }

    public void setModifiele(Date modifiele) {
        this.modifiele = modifiele;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbonrestitution != null ? idbonrestitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonrestitution)) {
            return false;
        }
        Bonrestitution other = (Bonrestitution) object;
        if ((this.idbonrestitution == null && other.idbonrestitution != null) || (this.idbonrestitution != null && !this.idbonrestitution.equals(other.idbonrestitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Bonrestitution[ idbonrestitution=" + idbonrestitution + " ]";
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public Postedetravail getPoste() {
        return poste;
    }

    public void setPoste(Postedetravail poste) {
        this.poste = poste;
    }

    public Magasin getIdcodemagasin() {
        return idcodemagasin;
    }

    public void setIdcodemagasin(Magasin idcodemagasin) {
        this.idcodemagasin = idcodemagasin;
    }

}
