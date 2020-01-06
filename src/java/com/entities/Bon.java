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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "BON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bon.findAll", query = "SELECT b FROM Bon b")
    , @NamedQuery(name = "Bon.findByvalider", query = "select b from Bon b where b.valider= :valider and b.idcodemagasin in (select m.idcodemagasin from Magasin m where m.idcodemagasin =:magasin)")
    , @NamedQuery(name = "Bon.findByNumbon", query = "SELECT b FROM Bon b WHERE b.numbon = :numbon")
    , @NamedQuery(name = "Bon.findByLibelle", query = "SELECT b FROM Bon b WHERE b.libelle = :libelle")})
public class Bon implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBON")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bon_seq")
    @SequenceGenerator(
            name = "bon_seq",
            sequenceName = "bon_numbon_seq",
            allocationSize = 1
    )
    private BigDecimal numbon;
    @Size(max = 40)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "VALIDER")
    private String valider="false";
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifierle;
    @Size(max = 6)
    @Column(name = "MODIFIEPAR")
    private String modifierpar;
    @JoinColumn(name = "IDSOURCE", referencedColumnName = "IDSOURCE")
    @ManyToOne(optional = false)
    private Sourcedefinancement idsource;
    @JoinColumn(name = "IDFOURNISSEUR", referencedColumnName = "IDFOURNISSEUR")
    @ManyToOne(optional = false)
    private Fournisseur idfournisseur;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin idcodemagasin;

    public Bon() {
    }

    public Bon(BigDecimal numbon) {
        this.numbon = numbon;
    }

    public BigDecimal getNumbon() {
        return numbon;
    }

    public void setNumbon(BigDecimal numbon) {
        this.numbon = numbon;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numbon != null ? numbon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bon)) {
            return false;
        }
        Bon other = (Bon) object;
        if ((this.numbon == null && other.numbon != null) || (this.numbon != null && !this.numbon.equals(other.numbon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Bon[ numbon=" + numbon + " ]";
    }

    public Sourcedefinancement getIdsource() {
        return idsource;
    }

    public Fournisseur getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Fournisseur idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public void setIdsource(Sourcedefinancement idsource) {
        this.idsource = idsource;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
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

    public Date getModifierle() {
        return modifierle;
    }

    public void setModifierle(Date modifierle) {
        this.modifierle = modifierle;
    }

    public String getModifierpar() {
        return modifierpar;
    }

    public void setModifierpar(String modifierpar) {
        this.modifierpar = modifierpar;
    }

    public Magasin getIdcodemagasin() {
        return idcodemagasin;
    }

    public void setIdcodemagasin(Magasin idcodemagasin) {
        this.idcodemagasin = idcodemagasin;
    }

}
