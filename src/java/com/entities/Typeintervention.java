/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "TYPEINTERVENTION", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Typeintervention.findAll", query = "SELECT t FROM Typeintervention t")
    , @NamedQuery(name = "Typeintervention.findByCodetypeint", query = "SELECT t FROM Typeintervention t WHERE t.codetypeint = :codetypeint")
    , @NamedQuery(name = "Typeintervention.findByLibelletypeint", query = "SELECT t FROM Typeintervention t WHERE t.libelletypeint = :libelletypeint")
    , @NamedQuery(name = "Typeintervention.findByCreele", query = "SELECT t FROM Typeintervention t WHERE t.creele = :creele")
    , @NamedQuery(name = "Typeintervention.findByCreepar", query = "SELECT t FROM Typeintervention t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Typeintervention.findByModifiele", query = "SELECT t FROM Typeintervention t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Typeintervention.findByModifiepar", query = "SELECT t FROM Typeintervention t WHERE t.modifiepar = :modifiepar")})
public class Typeintervention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODETYPEINT")
    private String codetypeint;
    @Size(max = 30)
    @Column(name = "LIBELLETYPEINT")
    private String libelletypeint;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @Size(max = 6)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codetypeint")
    private Collection<Equipementreparation> equipementreparationCollection;

    public Typeintervention() {
    }

    public Typeintervention(String codetypeint) {
        this.codetypeint = codetypeint;
    }

    public String getCodetypeint() {
        return codetypeint;
    }

    public void setCodetypeint(String codetypeint) {
        this.codetypeint = codetypeint;
    }

    public String getLibelletypeint() {
        return libelletypeint;
    }

    public void setLibelletypeint(String libelletypeint) {
        this.libelletypeint = libelletypeint;
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

    public Date getModifiele() {
        return modifiele;
    }

    public void setModifiele(Date modifiele) {
        this.modifiele = modifiele;
    }

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Collection<Equipementreparation> getEquipementreparationCollection() {
        return equipementreparationCollection;
    }

    public void setEquipementreparationCollection(Collection<Equipementreparation> equipementreparationCollection) {
        this.equipementreparationCollection = equipementreparationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codetypeint != null ? codetypeint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeintervention)) {
            return false;
        }
        Typeintervention other = (Typeintervention) object;
        if ((this.codetypeint == null && other.codetypeint != null) || (this.codetypeint != null && !this.codetypeint.equals(other.codetypeint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Typeintervention[ codetypeint=" + codetypeint + " ]";
    }
    
}
