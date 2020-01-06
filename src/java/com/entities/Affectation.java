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
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "AFFECTATION", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a")
   , @NamedQuery(name = "Affectation.findByIdaffectation", query = "SELECT a FROM Affectation a WHERE a.idbonaffectation = :idbonaffectation")
    , @NamedQuery(name = "Affectation.findByCodeequip", query = "SELECT a FROM Affectation a WHERE a.codeequip = :codeequip")
    , @NamedQuery(name = "Affectation.findByDatefin", query = "SELECT a FROM Affectation a WHERE a.datefin = :datefin")
    , @NamedQuery(name = "Affectation.findByStatut", query = "SELECT a FROM Affectation a WHERE a.statut = :statut")
    , @NamedQuery(name = "Affectation.findByDateaffectation", query = "SELECT a FROM Affectation a WHERE a.dateaffectation = :dateaffectation")
    , @NamedQuery(name = "Affectation.findByCreele", query = "SELECT a FROM Affectation a WHERE a.creele = :creele")
    , @NamedQuery(name = "Affectation.findByCreepar", query = "SELECT a FROM Affectation a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Affectation.findByModifiele", query = "SELECT a FROM Affectation a WHERE a.modifiele = :modifiele")
    , @NamedQuery(name = "Affectation.findByModifiepar", query = "SELECT a FROM Affectation a WHERE a.modifiepar = :modifiepar")})
public class Affectation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDAFFECTATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affectation_seq")
    @SequenceGenerator(
            name = "affectation_seq",
            sequenceName = "affectation_idaffectation_seq",
            allocationSize = 1
    )
    private BigDecimal idbonaffectation;
    @Size(max = 30)
    @Column(name = "CODEEQUIP")
    private String codeequip;
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @Column(name = "STATUT")
    private BigDecimal statut;
    @Column(name = "DATEAFFECTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaffectation;
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
    @JoinColumn(name = "IDEQUIP", referencedColumnName = "IDEQUIP")
    @ManyToOne(optional = false)
    private Equipement equipement;
    @JoinColumn(name = "IDPOSTE", referencedColumnName = "IDPOSTE")
    @ManyToOne(optional = false)
    private Postedetravail postedetravail;

    public Affectation() {
    }

    public String getCodeequip() {
        return codeequip;
    }

    public void setCodeequip(String codeequip) {
        this.codeequip = codeequip;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public BigDecimal getStatut() {
        return statut;
    }

    public void setStatut(BigDecimal statut) {
        this.statut = statut;
    }

    public Date getDateaffectation() {
        return dateaffectation;
    }

    public void setDateaffectation(Date dateaffectation) {
        this.dateaffectation = dateaffectation;
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

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Postedetravail getPostedetravail() {
        return postedetravail;
    }

    public void setPostedetravail(Postedetravail postedetravail) {
        this.postedetravail = postedetravail;
    }

    

    public BigDecimal getIdaffectation() {
        return idbonaffectation;
    }

    public void setIdaffectation(BigDecimal idbonaffectation) {
        this.idbonaffectation = idbonaffectation;
    }

}
