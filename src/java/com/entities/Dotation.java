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

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "DOTATION", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Dotation.findAll", query = "SELECT d FROM Dotation d")
    , @NamedQuery(name = "Dotation.findByIddotation", query = "SELECT d FROM Dotation d WHERE d.iddotation = :iddotation")
    , @NamedQuery(name = "Dotation.findByCodeequip", query = "SELECT d FROM Dotation d WHERE d.codeequip = :codeequip")
    , @NamedQuery(name = "Dotation.findByDatedotation", query = "SELECT d FROM Dotation d WHERE d.datedotation = :datedotation")
    , @NamedQuery(name = "Dotation.findByCreele", query = "SELECT d FROM Dotation d WHERE d.creele = :creele")
    , @NamedQuery(name = "Dotation.findByCreepar", query = "SELECT d FROM Dotation d WHERE d.creepar = :creepar")
    , @NamedQuery(name = "Dotation.findByModifiele", query = "SELECT d FROM Dotation d WHERE d.modifiele = :modifiele")
    , @NamedQuery(name = "Dotation.findByModifiepar", query = "SELECT d FROM Dotation d WHERE d.modifiepar = :modifiepar")})
public class Dotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDOTATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dotation_seq")
    @SequenceGenerator(
            name = "dotation_seq",
            sequenceName = "dotation_iddotation_seq",
            allocationSize = 1
    )
    private BigDecimal iddotation;

    @Size(max = 30)
    @Column(name = "CODEEQUIP")
    private String codeequip;
    @Column(name = "DATEDOTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedotation;
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
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin magasin;

    public Dotation() {
    }

    public String getCodeequip() {
        return codeequip;
    }

    public void setCodeequip(String codeequip) {
        this.codeequip = codeequip;
    }

    public Date getDatedotation() {
        return datedotation;
    }

    public void setDatedotation(Date datedotation) {
        this.datedotation = datedotation;
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

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public void setIddotation(BigDecimal iddotation) {
        this.iddotation = iddotation;
    }

    public BigDecimal getIddotation() {
        return iddotation;
    }

}
