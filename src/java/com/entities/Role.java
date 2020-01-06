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
@Table(name = "ROLE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIdrole", query = "SELECT r FROM Role r WHERE r.idrole = :idrole")
    , @NamedQuery(name = "Role.findByLibellerole", query = "SELECT r FROM Role r WHERE r.libellerole = :libellerole")
    , @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")
    , @NamedQuery(name = "Role.findByCreele", query = "SELECT r FROM Role r WHERE r.creele = :creele")
    , @NamedQuery(name = "Role.findByCreepar", query = "SELECT r FROM Role r WHERE r.creepar = :creepar")
    , @NamedQuery(name = "Role.findByModifiele", query = "SELECT r FROM Role r WHERE r.modifiele = :modifiele")
    , @NamedQuery(name = "Role.findByModifiepar", query = "SELECT r FROM Role r WHERE r.modifiepar = :modifiepar")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDROLE")
    private String idrole;
    @Size(max = 30)
    @Column(name = "LIBELLEROLE")
    private String libellerole;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<Affectationrole> affectationroleCollection;

    public Role() {
    }

    public Role(String idrole) {
        this.idrole = idrole;
    }

    public String getIdrole() {
        return idrole;
    }

    public void setIdrole(String idrole) {
        this.idrole = idrole;
    }

    public String getLibellerole() {
        return libellerole;
    }

    public void setLibellerole(String libellerole) {
        this.libellerole = libellerole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Collection<Affectationrole> getAffectationroleCollection() {
        return affectationroleCollection;
    }

    public void setAffectationroleCollection(Collection<Affectationrole> affectationroleCollection) {
        this.affectationroleCollection = affectationroleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Role[ idrole=" + idrole + " ]";
    }
    
}
