/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "AFFECTATIONROLE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Affectationrole.findAll", query = "SELECT a FROM Affectationrole a")
   , @NamedQuery(name = "Affectationrole.findByDateaffectation", query = "SELECT a FROM Affectationrole a WHERE a.dateaffectation = :dateaffectation")
    , @NamedQuery(name = "Affectationrole.findByDateretrait", query = "SELECT a FROM Affectationrole a WHERE a.dateretrait = :dateretrait")
    , @NamedQuery(name = "Affectationrole.findByCreele", query = "SELECT a FROM Affectationrole a WHERE a.creele = :creele")
    , @NamedQuery(name = "Affectationrole.findByCreepar", query = "SELECT a FROM Affectationrole a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Affectationrole.findByModifiele", query = "SELECT a FROM Affectationrole a WHERE a.modifiele = :modifiele")
    , @NamedQuery(name = "Affectationrole.findByModifiepar", query = "SELECT a FROM Affectationrole a WHERE a.modifiepar = :modifiepar")})
public class Affectationrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATEAFFECTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaffectation;
    @Column(name = "DATERETRAIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretrait;
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
    @JoinColumn(name = "IDPROFIL", referencedColumnName = "IDPROFIL")
    @ManyToOne(optional = false)
    private Profil profil;
    @JoinColumn(name = "IDROLE", referencedColumnName = "IDROLE")
    @ManyToOne(optional = false)
    private Role role;

    public Affectationrole() {
    }

    public Date getDateretrait() {
        return dateretrait;
    }

    public void setDateretrait(Date dateretrait) {
        this.dateretrait = dateretrait;
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

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
    }

}
