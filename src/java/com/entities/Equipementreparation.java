/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "EQUIPEMENTREPARATION", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Equipementreparation.findAll", query = "SELECT e FROM Equipementreparation e")
    , @NamedQuery(name = "Equipementreparation.findByIdreparation", query = "SELECT e FROM Equipementreparation e WHERE e.idreparation = :idreparation")
    , @NamedQuery(name = "Equipementreparation.findByDateretour", query = "SELECT e FROM Equipementreparation e WHERE e.dateretour = :dateretour")
    , @NamedQuery(name = "Equipementreparation.findByDescriptionreparation", query = "SELECT e FROM Equipementreparation e WHERE e.descriptionreparation = :descriptionreparation")
    , @NamedQuery(name = "Equipementreparation.findByCoutreparation", query = "SELECT e FROM Equipementreparation e WHERE e.coutreparation = :coutreparation")
    , @NamedQuery(name = "Equipementreparation.findByObservationreparation", query = "SELECT e FROM Equipementreparation e WHERE e.observationreparation = :observationreparation")
    , @NamedQuery(name = "Equipementreparation.findByRepare", query = "SELECT e FROM Equipementreparation e WHERE e.repare = :repare")
    , @NamedQuery(name = "Equipementreparation.findByIncorpore", query = "SELECT e FROM Equipementreparation e WHERE e.incorpore = :incorpore")
    , @NamedQuery(name = "Equipementreparation.findByCreele", query = "SELECT e FROM Equipementreparation e WHERE e.creele = :creele")
    , @NamedQuery(name = "Equipementreparation.findByCreepar", query = "SELECT e FROM Equipementreparation e WHERE e.creepar = :creepar")
    , @NamedQuery(name = "Equipementreparation.findByModifiele", query = "SELECT e FROM Equipementreparation e WHERE e.modifiele = :modifiele")
    , @NamedQuery(name = "Equipementreparation.findByModifiepar", query = "SELECT e FROM Equipementreparation e WHERE e.modifiepar = :modifiepar")})
public class Equipementreparation implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @Basic(optional = false)
    @Column(name = "IDREPARATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equiprepa_seq")
    @SequenceGenerator(
            name = "equiprepa_seq",
            sequenceName = "idreparation_seq",
            allocationSize = 1
    )
    private BigDecimal idreparation;
    
    @Column(name = "DATERETOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretour;
    @Size(max = 256)
    @Column(name = "DESCRIPTIONREPARATION")
    private String descriptionreparation;
    @Column(name = "COUTREPARATION")
    private BigInteger coutreparation;
    @Size(max = 256)
    @Column(name = "OBSERVATIONREPARATION")
    private String observationreparation;
    @Column(name = "REPARE")
    private String repare;
    @Column(name = "INCORPORE")
    private String incorpore;
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
    @JoinColumns({
        @JoinColumn(name = "IDEQUIP", referencedColumnName = "IDEQUIP")
        , @JoinColumn(name = "IDSORTIE", referencedColumnName = "IDSORTIE")
        , @JoinColumn(name = "IDEQUIPSORTI", referencedColumnName = "IDEQUIPSORTI")})
    @ManyToOne(optional = false)
    private Equipementsortis equipementsortis;
    @JoinColumn(name = "CODETYPEINT", referencedColumnName = "CODETYPEINT")
    @ManyToOne(optional = false)
    private Typeintervention codetypeint;

    public Equipementreparation() {
    }

    public Equipementreparation(Date dateretour) {
        this.dateretour = dateretour;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public String getDescriptionreparation() {
        return descriptionreparation;
    }

    public void setDescriptionreparation(String descriptionreparation) {
        this.descriptionreparation = descriptionreparation;
    }

    public BigInteger getCoutreparation() {
        return coutreparation;
    }

    public void setCoutreparation(BigInteger coutreparation) {
        this.coutreparation = coutreparation;
    }

    public String getObservationreparation() {
        return observationreparation;
    }

    public void setObservationreparation(String observationreparation) {
        this.observationreparation = observationreparation;
    }

    public String getRepare() {
        return repare;
    }

    public void setRepare(String repare) {
        this.repare = repare;
    }

    public String getIncorpore() {
        return incorpore;
    }

    public void setIncorpore(String incorpore) {
        this.incorpore = incorpore;
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

    public Equipementsortis getEquipementsortis() {
        return equipementsortis;
    }

    public void setEquipementsortis(Equipementsortis equipementsortis) {
        this.equipementsortis = equipementsortis;
    }

    public Typeintervention getCodetypeint() {
        return codetypeint;
    }

    public void setCodetypeint(Typeintervention codetypeint) {
        this.codetypeint = codetypeint;
    }

    public BigDecimal getIdreparation() {
        return idreparation;
    }

    public void setIdreparation(BigDecimal idreparation) {
        this.idreparation = idreparation;
    }

    @Override
    public String toString() {
        return "Equipementreparation{" + "idreparation=" + idreparation + '}';
    }

    
}
