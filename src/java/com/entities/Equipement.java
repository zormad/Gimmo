/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "EQUIPEMENT", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Equipement.findAll", query = "SELECT e FROM Equipement e")
    ,@NamedQuery(name = "Equipement.findAllActif", query = "SELECT e FROM Equipement e WHERE e.statut = :statut")
    , @NamedQuery(name = "Equipement.findByIdequip", query = "SELECT e FROM Equipement e WHERE e.idequip = :idequip")
    , @NamedQuery(name = "Equipement.findByDateacqui", query = "SELECT e FROM Equipement e WHERE e.dateacqui = :dateacqui")
    , @NamedQuery(name = "Equipement.findByCoutacqui", query = "SELECT e FROM Equipement e WHERE e.coutacqui = :coutacqui")
    , @NamedQuery(name = "Equipement.findByCoutcomptablenette", query = "SELECT e FROM Equipement e WHERE e.coutcomptablenette = :coutcomptablenette")
    , @NamedQuery(name = "Equipement.findByStatut", query = "SELECT e FROM Equipement e WHERE e.statut = :statut")
    , @NamedQuery(name = "Equipement.findByCreele", query = "SELECT e FROM Equipement e WHERE e.creele = :creele")
    , @NamedQuery(name = "Equipement.findByCreepar", query = "SELECT e FROM Equipement e WHERE e.creepar = :creepar")
    , @NamedQuery(name = "Equipement.findByModifiele", query = "SELECT e FROM Equipement e WHERE e.modifiele = :modifiele")
    , @NamedQuery(name = "Equipement.findByBon", query = "SELECT e FROM Equipement e WHERE e.bon in(SELECT b FROM Bon b WHERE b.numbon =:bon)")
    , @NamedQuery(name = "Equipement.findByBondotation", query = "SELECT e FROM Equipement e WHERE e.bondotation in(SELECT b FROM Bondotation b WHERE b.idbondotation =:idbondotation)")
    , @NamedQuery(name = "Equipement.findByBonaffectation", query = "SELECT e FROM Equipement e WHERE e.bonaffectation in(SELECT b FROM Bonaffectation b WHERE b.idbonaffectation =:idbonaffectation)")
    , @NamedQuery(name = "Equipement.findByBonrestitution", query = "SELECT e FROM Equipement e WHERE e.bonrestitution in(SELECT b FROM Bonrestitution b WHERE b.idbonrestitution =:idbonrestitution)")
    , @NamedQuery(name = "Equipement.findByMagasinActuel", query = "SELECT e FROM Equipement e WHERE e.magasinActuel.idcodemagasin in(SELECT m.idcodemagasin FROM Magasin m WHERE m.idcodemagasin =:magasin) and e.bon in(SELECT b FROM Bon b where b.valider = :valider)")
    , @NamedQuery(name = "Equipement.findByPosteActuel", query = "SELECT e FROM Equipement e WHERE e.posteActuel.idposte in(SELECT p.idposte FROM Postedetravail p WHERE p.idposte =:poste)")
    , @NamedQuery(name = "Equipement.findByModifiepar", query = "SELECT e FROM Equipement e WHERE e.modifiepar = :modifiepar")})
public class Equipement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEQUIP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equip_seq")
    @SequenceGenerator(
            name = "equip_seq",
            sequenceName = "equip_idequipement_seq",
            allocationSize = 1
    )
    private BigDecimal idequip;
    @Column(name = "DATEACQUI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacqui;
    @Column(name = "COUTACQUI")
    private BigInteger coutacqui;
    @Column(name = "COUTCOMPTABLENETTE")
    private BigInteger coutcomptablenette;
    @Size(max = 10)
    @Column(name = "STATUT")
    private String statut;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @Size(max = 254)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipement")
    private Collection<Affectation> affectationCollection;
    @JoinColumn(name = "CODEARTICLE", referencedColumnName = "CODEARTICLE")
    @ManyToOne(optional = false)
    private Article codearticle;
    @JoinColumn(name = "IDETAT", referencedColumnName = "IDETAT")
    @ManyToOne(optional = false)
    private Etat idetat;
    @JoinColumn(name = "IDMARQUE", referencedColumnName = "IDMARQUE")
    @ManyToOne(optional = false)
    private Marque idmarque;
    @JoinColumn(name = "NUMBON", referencedColumnName = "NUMBON")
    @ManyToOne(optional = true)
    private Bon bon;
    @JoinColumn(name = "IDBONAFFECTATION", referencedColumnName = "IDBONAFFECTATION")
    @ManyToOne(optional = true)
    private Bonaffectation bonaffectation;
    @JoinColumn(name = "IDBONDOTATION", referencedColumnName = "IDBONDOTATION")
    @ManyToOne(optional = true)
    private Bondotation bondotation;
    @JoinColumn(name = "IDBONRESTITUTION", referencedColumnName = "IDBONRESTITUTION")
    @ManyToOne(fetch=FetchType.LAZY,optional = true)
    private Bonrestitution bonrestitution;
    //Ajout
    @JoinColumn(name = "magasinActuel", referencedColumnName = "idcodemagasin")
    @ManyToOne(optional = true)
    private Magasin magasinActuel;
    @JoinColumn(name = "magasinEntre", referencedColumnName = "idcodemagasin")
    @ManyToOne(optional = false)
    private Magasin magasinEntre;
    @JoinColumn(name = "posteActuel", referencedColumnName = "idposte")
    @ManyToOne(optional = true)
    private Postedetravail posteActuel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipement")
    private Collection<Retourner> retournerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipement")
    private Collection<Dotation> dotationCollection;

    public Equipement() {
    }

    public Equipement(BigDecimal idequip) {
        this.idequip = idequip;
    }

    public BigDecimal getIdequip() {
        return idequip;
    }

    public void setIdequip(BigDecimal idequip) {
        this.idequip = idequip;
    }

    public Date getDateacqui() {
        return dateacqui;
    }

    public void setDateacqui(Date dateacqui) {
        this.dateacqui = dateacqui;
    }

    public BigInteger getCoutacqui() {
        return coutacqui;
    }

    public void setCoutacqui(BigInteger coutacqui) {
        this.coutacqui = coutacqui;
    }

    public BigInteger getCoutcomptablenette() {
        return coutcomptablenette;
    }

    public void setCoutcomptablenette(BigInteger coutcomptablenette) {
        this.coutcomptablenette = coutcomptablenette;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
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

    public Collection<Affectation> getAffectationCollection() {
        return affectationCollection;
    }

    public void setAffectationCollection(Collection<Affectation> affectationCollection) {
        this.affectationCollection = affectationCollection;
    }

    public Article getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(Article codearticle) {
        this.codearticle = codearticle;
    }

    public Etat getIdetat() {
        return idetat;
    }

    public void setIdetat(Etat idetat) {
        this.idetat = idetat;
    }

    public Marque getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Marque idmarque) {
        this.idmarque = idmarque;
    }

    public Bon getBon() {
        return bon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    public Collection<Retourner> getRetournerCollection() {
        return retournerCollection;
    }

    public void setRetournerCollection(Collection<Retourner> retournerCollection) {
        this.retournerCollection = retournerCollection;
    }

    public Collection<Dotation> getDotationCollection() {
        return dotationCollection;
    }

    public void setDotationCollection(Collection<Dotation> dotationCollection) {
        this.dotationCollection = dotationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequip != null ? idequip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipement)) {
            return false;
        }
        Equipement other = (Equipement) object;
        if ((this.idequip == null && other.idequip != null) || (this.idequip != null && !this.idequip.equals(other.idequip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Equipement[ idequip=" + idequip + " ]";
    }

    public Magasin getMagasinActuel() {
        return magasinActuel;
    }

    public void setMagasinActuel(Magasin magasinActuel) {
        this.magasinActuel = magasinActuel;
    }

    public Magasin getMagasinEntre() {
        return magasinEntre;
    }

    public void setMagasinEntre(Magasin magasinEntre) {
        this.magasinEntre = magasinEntre;
    }

    public Postedetravail getPosteActuel() {
        return posteActuel;
    }

    public void setPosteActuel(Postedetravail posteActuel) {
        this.posteActuel = posteActuel;
    }

    public Bonaffectation getBonaffectation() {
        return bonaffectation;
    }

    public void setBonaffectation(Bonaffectation bonaffectation) {
        this.bonaffectation = bonaffectation;
    }

    public Bondotation getBondotation() {
        return bondotation;
    }

    public void setBondotation(Bondotation bondotation) {
        this.bondotation = bondotation;
    }

    public Bonrestitution getBonrestitution() {
        return bonrestitution;
    }

    public void setBonrestitution(Bonrestitution bonrestitution) {
        this.bonrestitution = bonrestitution;
    }

}
