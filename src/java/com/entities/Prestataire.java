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
@Table(name = "PRESTATAIRE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Prestataire.findAll", query = "SELECT p FROM Prestataire p")
    , @NamedQuery(name = "Prestataire.findByIdprestataire", query = "SELECT p FROM Prestataire p WHERE p.idprestataire = :idprestataire")
    , @NamedQuery(name = "Prestataire.findByLibelleprestataire", query = "SELECT p FROM Prestataire p WHERE p.libelleprestataire = :libelleprestataire")
    , @NamedQuery(name = "Prestataire.findByTel", query = "SELECT p FROM Prestataire p WHERE p.tel = :tel")
    , @NamedQuery(name = "Prestataire.findByFax", query = "SELECT p FROM Prestataire p WHERE p.fax = :fax")
    , @NamedQuery(name = "Prestataire.findByAdresse", query = "SELECT p FROM Prestataire p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Prestataire.findByEmail", query = "SELECT p FROM Prestataire p WHERE p.email = :email")
    , @NamedQuery(name = "Prestataire.findByCreele", query = "SELECT p FROM Prestataire p WHERE p.creele = :creele")
    , @NamedQuery(name = "Prestataire.findByCreepar", query = "SELECT p FROM Prestataire p WHERE p.creepar = :creepar")
    , @NamedQuery(name = "Prestataire.findByModifiele", query = "SELECT p FROM Prestataire p WHERE p.modifiele = :modifiele")
    , @NamedQuery(name = "Prestataire.findByModifiepar", query = "SELECT p FROM Prestataire p WHERE p.modifiepar = :modifiepar")})
public class Prestataire implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRESTATAIRE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestat_seq")
    @SequenceGenerator(
            name = "prestat_seq",
            sequenceName = "prestat_idprestataire_seq",
            allocationSize = 20
    )
    private BigDecimal idprestataire;
    @Size(max = 45)
    @Column(name = "LIBELLEPRESTATAIRE")
    private String libelleprestataire;
    @Column(name = "TEL")
    private BigInteger tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 50)
    @Column(name = "ADRESSE")
    private String adresse;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
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
    @OneToMany(mappedBy = "idprestataire")
    private Collection<Sortie> sortieCollection;

    public Prestataire() {
    }

    public Prestataire(BigDecimal idprestataire) {
        this.idprestataire = idprestataire;
    }

    public BigDecimal getIdprestataire() {
        return idprestataire;
    }

    public void setIdprestataire(BigDecimal idprestataire) {
        this.idprestataire = idprestataire;
    }

    public String getLibelleprestataire() {
        return libelleprestataire;
    }

    public void setLibelleprestataire(String libelleprestataire) {
        this.libelleprestataire = libelleprestataire;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public Collection<Sortie> getSortieCollection() {
        return sortieCollection;
    }

    public void setSortieCollection(Collection<Sortie> sortieCollection) {
        this.sortieCollection = sortieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestataire != null ? idprestataire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestataire)) {
            return false;
        }
        Prestataire other = (Prestataire) object;
        if ((this.idprestataire == null && other.idprestataire != null) || (this.idprestataire != null && !this.idprestataire.equals(other.idprestataire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Prestataire[ idprestataire=" + idprestataire + " ]";
    }
    
}
