/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "EQUIPEMENTSORTIS", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Equipementsortis.findAll", query = "SELECT e FROM Equipementsortis e")
   , @NamedQuery(name = "Equipementsortis.findByIdequipsorti", query = "SELECT e FROM Equipementsortis e WHERE e.idequipsorti = :idequipsorti")
    , @NamedQuery(name = "Equipementsortis.findBySortie", query = "SELECT e.equipement FROM Equipementsortis e WHERE e.sortie.idsortie = :idsortie")
    , @NamedQuery(name = "Equipementsortis.findByCreele", query = "SELECT e FROM Equipementsortis e WHERE e.creele = :creele")
    , @NamedQuery(name = "Equipementsortis.findByCreepar", query = "SELECT e FROM Equipementsortis e WHERE e.creepar = :creepar")
    , @NamedQuery(name = "Equipementsortis.findByModifiele", query = "SELECT e FROM Equipementsortis e WHERE e.modifiele = :modifiele")
    , @NamedQuery(name = "Equipementsortis.findByModifiepar", query = "SELECT e FROM Equipementsortis e WHERE e.modifiepar = :modifiepar")})
public class Equipementsortis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDEQUIPSORTI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipsorti_seq")
    @SequenceGenerator(
            name = "equipsorti_seq",
            sequenceName = "equipsorti_idequipsorti_seq",
            allocationSize = 1
    )
    private BigDecimal idequipsorti;
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
    @JoinColumn(name = "IDSORTIE", referencedColumnName = "IDSORTIE")
    @ManyToOne(optional = false)
    private Sortie sortie;
    @JoinColumn(name = "IDEQUIP", referencedColumnName = "IDEQUIP")
    @ManyToOne(optional = false)
    private Equipement equipement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipementsortis")
    private Collection<Equipementreparation> equipementreparationCollection;

    public Equipementsortis() {
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

    public Sortie getSortie() {
        return sortie;
    }

    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    public Collection<Equipementreparation> getEquipementreparationCollection() {
        return equipementreparationCollection;
    }

    public void setEquipementreparationCollection(Collection<Equipementreparation> equipementreparationCollection) {
        this.equipementreparationCollection = equipementreparationCollection;
    }

    public BigDecimal getIdequipsorti() {
        return idequipsorti;
    }

    public void setIdequipsorti(BigDecimal idequipsorti) {
        this.idequipsorti = idequipsorti;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }
    
}
