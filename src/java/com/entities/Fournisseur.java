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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "FOURNISSEUR", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
    , @NamedQuery(name = "Fournisseur.findByIdfournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur")
    , @NamedQuery(name = "Fournisseur.findByLibellefournisseur", query = "SELECT f FROM Fournisseur f WHERE f.libellefournisseur = :libellefournisseur")
    , @NamedQuery(name = "Fournisseur.findByAdresse", query = "SELECT f FROM Fournisseur f WHERE f.adresse = :adresse")
    , @NamedQuery(name = "Fournisseur.findByTel", query = "SELECT f FROM Fournisseur f WHERE f.tel = :tel")
    , @NamedQuery(name = "Fournisseur.findByFax", query = "SELECT f FROM Fournisseur f WHERE f.fax = :fax")
    , @NamedQuery(name = "Fournisseur.findByEmail", query = "SELECT f FROM Fournisseur f WHERE f.email = :email")
    , @NamedQuery(name = "Fournisseur.findByCreele", query = "SELECT f FROM Fournisseur f WHERE f.creele = :creele")
    , @NamedQuery(name = "Fournisseur.findByCreepar", query = "SELECT f FROM Fournisseur f WHERE f.creepar = :creepar")
    , @NamedQuery(name = "Fournisseur.findByModifiele", query = "SELECT f FROM Fournisseur f WHERE f.modifiele = :modifiele")
    , @NamedQuery(name = "Fournisseur.findByModifiepar", query = "SELECT f FROM Fournisseur f WHERE f.modifiepar = :modifiepar")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFOURNISSEUR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "four_seq")
    @SequenceGenerator(
            name = "four_seq",
            sequenceName = "four_idfournisseur_seq",
            allocationSize = 20
    )
    private BigDecimal idfournisseur;
    @Size(max = 30)
    @Column(name = "LIBELLEFOURNISSEUR")
    private String libellefournisseur;
    @Size(max = 30)
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "TEL")
    private BigInteger tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfournisseur")
    private Collection<Bon> bonCollection;

    public Fournisseur() {
    }

    public Fournisseur(BigDecimal idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public BigDecimal getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(BigDecimal idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public String getLibellefournisseur() {
        return libellefournisseur;
    }

    public void setLibellefournisseur(String libellefournisseur) {
        this.libellefournisseur = libellefournisseur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public BigInteger getTel() {
        return tel;
    }

    public void setTel(BigInteger tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Collection<Bon> getBonCollection() {
        return bonCollection;
    }

    public void setBonCollection(Collection<Bon> bonCollection) {
        this.bonCollection = bonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfournisseur != null ? idfournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idfournisseur == null && other.idfournisseur != null) || (this.idfournisseur != null && !this.idfournisseur.equals(other.idfournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Fournisseur[ idfournisseur=" + idfournisseur + " ]";
    }
    
}
