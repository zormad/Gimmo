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
@Table(name = "ETAT", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Etat.findAll", query = "SELECT e FROM Etat e")
    , @NamedQuery(name = "Etat.findByIdetat", query = "SELECT e FROM Etat e WHERE e.idetat = :idetat")
    , @NamedQuery(name = "Etat.findByLibelleetat", query = "SELECT e FROM Etat e WHERE e.libelleetat = :libelleetat")
    , @NamedQuery(name = "Etat.findByCreele", query = "SELECT e FROM Etat e WHERE e.creele = :creele")
    , @NamedQuery(name = "Etat.findByCreepar", query = "SELECT e FROM Etat e WHERE e.creepar = :creepar")
    , @NamedQuery(name = "Etat.findByModifiele", query = "SELECT e FROM Etat e WHERE e.modifiele = :modifiele")
    , @NamedQuery(name = "Etat.findByModifiepar", query = "SELECT e FROM Etat e WHERE e.modifiepar = :modifiepar")})
public class Etat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IDETAT")
    private String idetat;
    @Size(max = 10)
    @Column(name = "LIBELLEETAT")
    private String libelleetat;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetat")
    private Collection<Equipement> equipementCollection;

    public Etat() {
    }

    public Etat(String idetat) {
        this.idetat = idetat;
    }

    public String getIdetat() {
        return idetat;
    }

    public void setIdetat(String idetat) {
        this.idetat = idetat;
    }

    public String getLibelleetat() {
        return libelleetat;
    }

    public void setLibelleetat(String libelleetat) {
        this.libelleetat = libelleetat;
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

    public Collection<Equipement> getEquipementCollection() {
        return equipementCollection;
    }

    public void setEquipementCollection(Collection<Equipement> equipementCollection) {
        this.equipementCollection = equipementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetat != null ? idetat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etat)) {
            return false;
        }
        Etat other = (Etat) object;
        if ((this.idetat == null && other.idetat != null) || (this.idetat != null && !this.idetat.equals(other.idetat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + libelleetat + "";
    }
    
}
