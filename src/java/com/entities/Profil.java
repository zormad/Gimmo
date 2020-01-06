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
@Table(name = "PROFIL", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p")
    , @NamedQuery(name = "Profil.findByIdprofil", query = "SELECT p FROM Profil p WHERE p.idprofil = :idprofil")
    , @NamedQuery(name = "Profil.findByLibelleprofil", query = "SELECT p FROM Profil p WHERE p.libelleprofil = :libelleprofil")
    , @NamedQuery(name = "Profil.findByCreele", query = "SELECT p FROM Profil p WHERE p.creele = :creele")
    , @NamedQuery(name = "Profil.findByCreepar", query = "SELECT p FROM Profil p WHERE p.creepar = :creepar")
    , @NamedQuery(name = "Profil.findByModifierle", query = "SELECT p FROM Profil p WHERE p.modifierle = :modifierle")
    , @NamedQuery(name = "Profil.findByModifiepar", query = "SELECT p FROM Profil p WHERE p.modifiepar = :modifiepar")})
public class Profil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPROFIL")
    private String idprofil;
    @Size(max = 30)
    @Column(name = "LIBELLEPROFIL")
    private String libelleprofil;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIERLE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifierle;
    @Size(max = 6)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofil")
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profil")
    private Collection<Affectationrole> affectationroleCollection;

    public Profil() {
    }

    public Profil(String idprofil) {
        this.idprofil = idprofil;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public String getLibelleprofil() {
        return libelleprofil;
    }

    public void setLibelleprofil(String libelleprofil) {
        this.libelleprofil = libelleprofil;
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

    public Date getModifierle() {
        return modifierle;
    }

    public void setModifierle(Date modifierle) {
        this.modifierle = modifierle;
    }

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    public Collection<Affectationrole> getAffectationroleCollection() {
        return affectationroleCollection;
    }

    public void setAffectationroleCollection(Collection<Affectationrole> affectationroleCollection) {
        this.affectationroleCollection = affectationroleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofil != null ? idprofil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.idprofil == null && other.idprofil != null) || (this.idprofil != null && !this.idprofil.equals(other.idprofil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Profil[ idprofil=" + idprofil + " ]";
    }
    
}
