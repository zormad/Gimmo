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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "ARTICLE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByCodearticle", query = "SELECT a FROM Article a WHERE a.codearticle = :codearticle")
    , @NamedQuery(name = "Article.findByDesignation", query = "SELECT a FROM Article a WHERE a.designation = :designation")
    , @NamedQuery(name = "Article.findByCreele", query = "SELECT a FROM Article a WHERE a.creele = :creele")
    , @NamedQuery(name = "Article.findByCreepar", query = "SELECT a FROM Article a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Article.findByModifiele", query = "SELECT a FROM Article a WHERE a.modifiele = :modifiele")
    , @NamedQuery(name = "Article.delete", query = "DELETE FROM Article a WHERE a.codearticle = :id")
    , @NamedQuery(name = "Article.findType", query = "SELECT a FROM Article a WHERE a.codetype IN (SELECT t.codetype FROM Type t WHERE t.codetype=:code)")
     , @NamedQuery(name = "Article.findByModifiepar", query = "SELECT a FROM Article a WHERE a.modifiepar = :modifiepar")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEARTICLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "art_seq")
    @SequenceGenerator(
            name = "art_seq",
            sequenceName = "art_codearticle_seq",
            allocationSize = 20
    )
    private BigDecimal codearticle;
    @Size(max = 30)
    @Column(name = "DESIGNATION")
    private String designation;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codearticle")
    private Collection<Equipement> equipementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<Inventairemagasin> inventairemagasinCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
//    private Collection<Besoins> besoinsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<Previsions> previsionsCollection;
    @JoinColumn(name = "CODETYPE", referencedColumnName = "CODETYPE")
    @ManyToOne(optional = false)
    private Type codetype;

    public Article() {
    }

    public Article(BigDecimal codearticle) {
        this.codearticle = codearticle;
    }

    public BigDecimal getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(BigDecimal codearticle) {
        this.codearticle = codearticle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public Collection<Equipement> getEquipementCollection() {
        return equipementCollection;
    }

    public void setEquipementCollection(Collection<Equipement> equipementCollection) {
        this.equipementCollection = equipementCollection;
    }

    public Collection<Inventairemagasin> getInventairemagasinCollection() {
        return inventairemagasinCollection;
    }

    public void setInventairemagasinCollection(Collection<Inventairemagasin> inventairemagasinCollection) {
        this.inventairemagasinCollection = inventairemagasinCollection;
    }

//    public Collection<Besoins> getBesoinsCollection() {
//        return besoinsCollection;
//    }
//
//    public void setBesoinsCollection(Collection<Besoins> besoinsCollection) {
//        this.besoinsCollection = besoinsCollection;
//    }

    public Collection<Previsions> getPrevisionsCollection() {
        return previsionsCollection;
    }

    public void setPrevisionsCollection(Collection<Previsions> previsionsCollection) {
        this.previsionsCollection = previsionsCollection;
    }

    public Type getCodetype() {
        return codetype;
    }

    public void setCodetype(Type codetype) {
        this.codetype = codetype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codearticle != null ? codearticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.codearticle == null && other.codearticle != null) || (this.codearticle != null && !this.codearticle.equals(other.codearticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + designation + "";
    }

}
