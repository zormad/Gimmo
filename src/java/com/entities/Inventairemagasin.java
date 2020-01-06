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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "INVENTAIREMAGASIN", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Inventairemagasin.findAll", query = "SELECT i FROM Inventairemagasin i")
   , @NamedQuery(name = "Inventairemagasin.findByIdinv", query = "SELECT i FROM Inventairemagasin i WHERE i.idinv = :idinv")
    , @NamedQuery(name = "Inventairemagasin.findByDateinv", query = "SELECT i FROM Inventairemagasin i WHERE i.dateinv = :dateinv")
    , @NamedQuery(name = "Inventairemagasin.findByQuantite", query = "SELECT i FROM Inventairemagasin i WHERE i.quantite = :quantite")
    , @NamedQuery(name = "Inventairemagasin.findByCreele", query = "SELECT i FROM Inventairemagasin i WHERE i.creele = :creele")
    , @NamedQuery(name = "Inventairemagasin.findByCreepar", query = "SELECT i FROM Inventairemagasin i WHERE i.creepar = :creepar")
    , @NamedQuery(name = "Inventairemagasin.findByModifiele", query = "SELECT i FROM Inventairemagasin i WHERE i.modifiele = :modifiele")
    , @NamedQuery(name = "Inventairemagasin.findByModifiepar", query = "SELECT i FROM Inventairemagasin i WHERE i.modifiepar = :modifiepar")})
public class Inventairemagasin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDINV")
    private BigInteger idinv;
    @Column(name = "DATEINV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinv;
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
    @JoinColumn(name = "CODEARTICLE", referencedColumnName = "CODEARTICLE")
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin magasin;

    public Inventairemagasin() {
    }

    
    public Date getDateinv() {
        return dateinv;
    }

    public void setDateinv(Date dateinv) {
        this.dateinv = dateinv;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public BigInteger getIdinv() {
        return idinv;
    }

    public void setIdinv(BigInteger idinv) {
        this.idinv = idinv;
    }

}
