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
@Table(name = "OCCUPATION", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o")
    , @NamedQuery(name = "Occupation.findByDatedebut", query = "SELECT o FROM Occupation o WHERE o.datedebut = :datedebut")
    , @NamedQuery(name = "Occupation.findByStatut", query = "SELECT o FROM Occupation o WHERE o.statut = :statut")
    , @NamedQuery(name = "Occupation.findByDatefin", query = "SELECT o FROM Occupation o WHERE o.datefin = :datefin")
    , @NamedQuery(name = "Occupation.findByCreele", query = "SELECT o FROM Occupation o WHERE o.creele = :creele")
    , @NamedQuery(name = "Occupation.findByCreepar", query = "SELECT o FROM Occupation o WHERE o.creepar = :creepar")
    , @NamedQuery(name = "Occupation.findByModifiele", query = "SELECT o FROM Occupation o WHERE o.modifiele = :modifiele")
    , @NamedQuery(name = "Occupation.findByModifiepar", query = "SELECT o FROM Occupation o WHERE o.modifiepar = :modifiepar")})
public class Occupation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @Basic(optional = false)
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "STATUT")
    private BigInteger statut;
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
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
    @JoinColumn(name = "IDPOSTE", referencedColumnName = "IDPOSTE")
    @ManyToOne(optional = false)
    private Postedetravail postedetravail;

    public Occupation() {
    }
    public BigInteger getStatut() {
        return statut;
    }

    public void setStatut(BigInteger statut) {
        this.statut = statut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
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

    public Postedetravail getPostedetravail() {
        return postedetravail;
    }

    public void setPostedetravail(Postedetravail postedetravail) {
        this.postedetravail = postedetravail;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    
}
