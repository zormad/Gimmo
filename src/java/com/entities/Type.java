/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TYPE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t")
    , @NamedQuery(name = "Type.findByCodetype", query = "SELECT t FROM Type t WHERE t.codetype = :codetype")
    , @NamedQuery(name = "Type.findByNomtype", query = "SELECT t FROM Type t WHERE t.nomtype = :nomtype")
    , @NamedQuery(name = "Type.findByCreele", query = "SELECT t FROM Type t WHERE t.creele = :creele")
    , @NamedQuery(name = "Type.findByCreepar", query = "SELECT t FROM Type t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Type.findFamille", query = "SELECT t FROM Type t WHERE t.codefamille IN (SELECT f.codefamille FROM Famille f WHERE f.codefamille=:code)")
    , @NamedQuery(name = "Type.findByModifiele", query = "SELECT t FROM Type t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Type.delete", query = "DELETE FROM Type t WHERE t.codetype = :id")
    , @NamedQuery(name = "Type.findByModifiepar", query = "SELECT t FROM Type t WHERE t.modifiepar = :modifiepar")})
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODETYPE")
    private String codetype;
    @Size(max = 30)
    @Column(name = "NOMTYPE")
    private String nomtype;
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
    @JoinColumn(name = "CODEFAMILLE", referencedColumnName = "CODEFAMILLE")
    @ManyToOne(optional = false)
    private Famille codefamille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codetype")
    private Collection<Article> articleCollection;

    public Type() {
    }

    public Type(String codetype) {
        this.codetype = codetype;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
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

    public Famille getCodefamille() {
        return codefamille;
    }

    public void setCodefamille(Famille codefamille) {
        this.codefamille = codefamille;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codetype != null ? codetype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.codetype == null && other.codetype != null) || (this.codetype != null && !this.codetype.equals(other.codetype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Type[ codetype=" + codetype + " ]";
    }

}
