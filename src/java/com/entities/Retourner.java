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
@Table(name = "RETOURNER", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Retourner.findAll", query = "SELECT r FROM Retourner r")
    , @NamedQuery(name = "Retourner.findByIdretourner", query = "SELECT r FROM Retourner r WHERE r.idretourner = :idretourner")
    , @NamedQuery(name = "Retourner.findByLibelleretourner", query = "SELECT r FROM Retourner r WHERE r.libelleretourner = :libelleretourner")
    , @NamedQuery(name = "Retourner.findByDateretourner", query = "SELECT r FROM Retourner r WHERE r.dateretourner = :dateretourner")
    , @NamedQuery(name = "Retourner.findByPositioninitial", query = "SELECT r FROM Retourner r WHERE r.positioninitial = :positioninitial")
    , @NamedQuery(name = "Retourner.findByCreele", query = "SELECT r FROM Retourner r WHERE r.creele = :creele")
    , @NamedQuery(name = "Retourner.findByCreepar", query = "SELECT r FROM Retourner r WHERE r.creepar = :creepar")
    , @NamedQuery(name = "Retourner.findByModifiele", query = "SELECT r FROM Retourner r WHERE r.modifiele = :modifiele")
    , @NamedQuery(name = "Retourner.findByModifiepar", query = "SELECT r FROM Retourner r WHERE r.modifiepar = :modifiepar")})
public class Retourner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDRETOURNER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retourner_seq")
    @SequenceGenerator(
            name = "retourner_seq",
            sequenceName = "retourner_idretourner_seq",
            allocationSize = 1
    )
    private BigInteger idretourner;
    @Size(max = 30)
    @Column(name = "LIBELLERETOURNER")
    private String libelleretourner;
    @Column(name = "DATERETOURNER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretourner;
    @Size(max = 6)
    @Column(name = "POSITIONINITIAL")
    private String positioninitial;
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
    @JoinColumn(name = "IDTYPERETOUR", referencedColumnName = "IDTYPERETOUR")
    @ManyToOne(optional = false)
    private Typeretour idtyperetour;

    public Retourner() {
    }

    public String getLibelleretourner() {
        return libelleretourner;
    }

    public void setLibelleretourner(String libelleretourner) {
        this.libelleretourner = libelleretourner;
    }

    public Date getDateretourner() {
        return dateretourner;
    }

    public void setDateretourner(Date dateretourner) {
        this.dateretourner = dateretourner;
    }

    public String getPositioninitial() {
        return positioninitial;
    }

    public void setPositioninitial(String positioninitial) {
        this.positioninitial = positioninitial;
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

    public Typeretour getIdtyperetour() {
        return idtyperetour;
    }

    public void setIdtyperetour(Typeretour idtyperetour) {
        this.idtyperetour = idtyperetour;
    }

}
