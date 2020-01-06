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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "BESOINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besoins.findAll", query = "SELECT b FROM Besoins b")
    , @NamedQuery(name = "Besoins.findByServiceAnnee", query = "SELECT b FROM Besoins b WHERE b.besoinsPK.codeservice = :codeservice AND b.besoinsPK.anneebesoin = :anneebesoin")
    , @NamedQuery(name = "Besoins.findByCodeservice", query = "SELECT b FROM Besoins b WHERE b.besoinsPK.codeservice = :codeservice")
    , @NamedQuery(name = "Besoins.findByCodearticle", query = "SELECT b FROM Besoins b WHERE b.besoinsPK.codearticle = :codearticle")
    , @NamedQuery(name = "Besoins.findByAnneebesoin", query = "SELECT b FROM Besoins b WHERE b.besoinsPK.anneebesoin = :anneebesoin")
    , @NamedQuery(name = "Besoins.findByQuantite", query = "SELECT b FROM Besoins b WHERE b.quantite = :quantite")
    , @NamedQuery(name = "Besoins.findByCreele", query = "SELECT b FROM Besoins b WHERE b.creele = :creele")
    , @NamedQuery(name = "Besoins.findByCreepar", query = "SELECT b FROM Besoins b WHERE b.creepar = :creepar")
    , @NamedQuery(name = "Besoins.findByModifiele", query = "SELECT b FROM Besoins b WHERE b.modifiele = :modifiele")
    , @NamedQuery(name = "Besoins.findByModifiepar", query = "SELECT b FROM Besoins b WHERE b.modifiepar = :modifiepar")})
public class Besoins implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BesoinsPK besoinsPK;
    @Column(name = "QUANTITE")
    private BigInteger quantite;
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
    @JoinColumn(name = "CODEARTICLE", referencedColumnName = "CODEARTICLE",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Article article;
   // @Id
    @JoinColumn(name = "CODESERVICE", referencedColumnName = "CODESERVICE",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Service service;

    public Besoins() {
    }

    public Besoins(BesoinsPK besoinsPK) {
        this.besoinsPK = besoinsPK;
    }

    public Besoins(String codeservice, BigDecimal codearticle, short anneebesoin) {
        this.besoinsPK = new BesoinsPK(codeservice, codearticle, anneebesoin);
    }

    public BesoinsPK getBesoinsPK() {
        return besoinsPK;
    }

    public void setBesoinsPK(BesoinsPK besoinsPK) {
        this.besoinsPK = besoinsPK;
    }

    public BigInteger getQuantite() {
        return quantite;
    }

    public void setQuantite(BigInteger quantite) {
        this.quantite = quantite;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (besoinsPK != null ? besoinsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Besoins)) {
            return false;
        }
        Besoins other = (Besoins) object;
        if ((this.besoinsPK == null && other.besoinsPK != null) || (this.besoinsPK != null && !this.besoinsPK.equals(other.besoinsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Besoins[ besoinsPK=" + besoinsPK + " ]";
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
}
