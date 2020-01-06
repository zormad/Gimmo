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
@Table(name = "BONAFFECTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonaffectation.findAll", query = "SELECT b FROM Bonaffectation b")
    , @NamedQuery(name = "Bonaffectation.findByIdbonaffectation", query = "SELECT b FROM Bonaffectation b WHERE b.idbonaffectation = :idbonaffectation")
    , @NamedQuery(name = "Bonaffectation.findByvalider", query = "select b from Bonaffectation b where b.valider= :valider and b.poste in(select p from Postedetravail p WHERE p.idposte= :poste)")
    , @NamedQuery(name = "Bonaffectation.findByLibellebonaffectation", query = "SELECT b FROM Bonaffectation b WHERE b.libellebonaffectation = :libellebonaffectation")
    , @NamedQuery(name = "Bonaffectation.findByCreele", query = "SELECT b FROM Bonaffectation b WHERE b.creele = :creele")
    , @NamedQuery(name = "Bonaffectation.findByCreepar", query = "SELECT b FROM Bonaffectation b WHERE b.creepar = :creepar")
    , @NamedQuery(name = "Bonaffectation.findByModifiepar", query = "SELECT b FROM Bonaffectation b WHERE b.modifiepar = :modifiepar")
    , @NamedQuery(name = "Bonaffectation.findByModifiele", query = "SELECT b FROM Bonaffectation b WHERE b.modifiele = :modifiele")})
public class Bonaffectation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBONAFFECTATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bonaffectation_seq")
    @SequenceGenerator(
            name = "bonaffectation_seq",
            sequenceName = "bonaffectation_id_seq",
            allocationSize = 1
    )
    private BigDecimal idbonaffectation;
    @Size(max = 100)
    @Column(name = "LIBELLEBONAFFECTATION")
    private String libellebonaffectation;
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
    @JoinColumn(name = "IDPOSTE", referencedColumnName = "IDPOSTE")
    @ManyToOne(optional = false)
    private Postedetravail poste;

    public Bonaffectation() {
    }

    public Bonaffectation(BigDecimal idbonaffectation) {
        this.idbonaffectation = idbonaffectation;
    }

    public BigDecimal getIdbonaffectation() {
        return idbonaffectation;
    }

    public void setIdbonaffectation(BigDecimal idbonaffectation) {
        this.idbonaffectation = idbonaffectation;
    }

    public String getLibellebonaffectation() {
        return libellebonaffectation;
    }

    public void setLibellebonaffectation(String libellebonaffectation) {
        this.libellebonaffectation = libellebonaffectation;
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
        hash += (idbonaffectation != null ? idbonaffectation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonaffectation)) {
            return false;
        }
        Bonaffectation other = (Bonaffectation) object;
        if ((this.idbonaffectation == null && other.idbonaffectation != null) || (this.idbonaffectation != null && !this.idbonaffectation.equals(other.idbonaffectation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Bonaffectation[ idbonaffectation=" + idbonaffectation + " ]";
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

}
