/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "AFFECTATIONUTILISATEUR", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Affectationutilisateur.findAll", query = "SELECT a FROM Affectationutilisateur a")
    , @NamedQuery(name = "Affectationutilisateur.findByDateaffectation", query = "SELECT a FROM Affectationutilisateur a WHERE a.dateaffectation = :dateaffectation")
    , @NamedQuery(name = "Affectationutilisateur.findByDatefin", query = "SELECT a FROM Affectationutilisateur a WHERE a.datefin = :datefin")
    , @NamedQuery(name = "Affectationutilisateur.findByStatut", query = "SELECT a FROM Affectationutilisateur a WHERE a.statut = :statut")
    , @NamedQuery(name = "Affectationutilisateur.findByCreele", query = "SELECT a FROM Affectationutilisateur a WHERE a.creele = :creele")
    , @NamedQuery(name = "Affectationutilisateur.findByCreepar", query = "SELECT a FROM Affectationutilisateur a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Affectationutilisateur.findByModifiele", query = "SELECT a FROM Affectationutilisateur a WHERE a.modifiele = :modifiele")
    , @NamedQuery(name = "Affectationutilisateur.findByModifiepar", query = "SELECT a FROM Affectationutilisateur a WHERE a.modifiepar = :modifiepar")})
public class Affectationutilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATEAFFECTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaffectation;
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @Column(name = "STATUT")
    private BigInteger statut;
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
    @JoinColumn(name = "IDAGENT", referencedColumnName = "IDAGENT")
    @ManyToOne(optional = false)
    private Agent agent;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Affectationutilisateur() {
    }
    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public BigInteger getStatut() {
        return statut;
    }

    public void setStatut(BigInteger statut) {
        this.statut = statut;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
    }
    
}
