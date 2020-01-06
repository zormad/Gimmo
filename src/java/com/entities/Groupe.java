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
@Table(name = "GROUPE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g")
    , @NamedQuery(name = "Groupe.findByIdgroupe", query = "SELECT g FROM Groupe g WHERE g.idgroupe = :idgroupe")
    , @NamedQuery(name = "Groupe.findByNomgroupe", query = "SELECT g FROM Groupe g WHERE g.nomgroupe = :nomgroupe")
    , @NamedQuery(name = "Groupe.findByCreele", query = "SELECT g FROM Groupe g WHERE g.creele = :creele")
    , @NamedQuery(name = "Groupe.findByCreepar", query = "SELECT g FROM Groupe g WHERE g.creepar = :creepar")
    , @NamedQuery(name = "Groupe.findByModifiele", query = "SELECT g FROM Groupe g WHERE g.modifiele = :modifiele")
    , @NamedQuery(name = "Groupe.findByModifiepar", query = "SELECT g FROM Groupe g WHERE g.modifiepar = :modifiepar")})
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDGROUPE")
    private String idgroupe;
    @Size(max = 254)
    @Column(name = "NOMGROUPE")
    private String nomgroupe;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @Size(max = 254)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgroupe")
    private Collection<Famille> familleCollection;

    public Groupe() {
    }

    public Groupe(String idgroupe) {
        this.idgroupe = idgroupe;
    }

    public String getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(String idgroupe) {
        this.idgroupe = idgroupe;
    }

    public String getNomgroupe() {
        return nomgroupe;
    }

    public void setNomgroupe(String nomgroupe) {
        this.nomgroupe = nomgroupe;
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

    public Collection<Famille> getFamilleCollection() {
        return familleCollection;
    }

    public void setFamilleCollection(Collection<Famille> familleCollection) {
        this.familleCollection = familleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroupe != null ? idgroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idgroupe == null && other.idgroupe != null) || (this.idgroupe != null && !this.idgroupe.equals(other.idgroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Groupe[ idgroupe=" + idgroupe + " ]";
    }
    
}
