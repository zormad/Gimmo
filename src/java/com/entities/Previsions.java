/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
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

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "PREVISIONS", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Previsions.findAll", query = "SELECT p FROM Previsions p")
    , @NamedQuery(name = "Previsions.findByStructureAnnee", query = "SELECT p FROM Previsions p WHERE p.previsionsPK.codestructure = :codestructure AND p.previsionsPK.anneeprevision = :anneeprevision")
    , @NamedQuery(name = "Previsions.findByAnneeprevision", query = "SELECT p FROM Previsions p WHERE p.previsionsPK.anneeprevision = :anneeprevision")
    , @NamedQuery(name = "Previsions.findByQuantite", query = "SELECT p FROM Previsions p WHERE p.quantite = :quantite")
    , @NamedQuery(name = "Previsions.findByCreele", query = "SELECT p FROM Previsions p WHERE p.creele = :creele")
    , @NamedQuery(name = "Previsions.findByCreepar", query = "SELECT p FROM Previsions p WHERE p.creepar = :creepar")
    , @NamedQuery(name = "Previsions.findByModifiele", query = "SELECT p FROM Previsions p WHERE p.modifiele = :modifiele")
    , @NamedQuery(name = "Previsions.findByModifiepar", query = "SELECT p FROM Previsions p WHERE p.modifiepar = :modifiepar")})
public class Previsions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrevisionsPK previsionsPK;
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
    @JoinColumn(name = "CODEARTICLE", referencedColumnName = "CODEARTICLE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "CODESTRUCTURE", referencedColumnName = "CODESTRUCTURE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Structure structure;

    public Previsions() {
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

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public PrevisionsPK getPrevisionsPK() {
        return previsionsPK;
    }

    public void setPrevisionsPK(PrevisionsPK previsionsPK) {
        this.previsionsPK = previsionsPK;
    }

}
