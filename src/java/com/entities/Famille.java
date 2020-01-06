/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
@Table(name = "FAMILLE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findByCodefamille", query = "SELECT f FROM Famille f WHERE f.codefamille = :codefamille")
    , @NamedQuery(name = "Famille.findByNomfamille", query = "SELECT f FROM Famille f WHERE f.nomfamille = :nomfamille")
    , @NamedQuery(name = "Famille.findByCreele", query = "SELECT f FROM Famille f WHERE f.creele = :creele")
    , @NamedQuery(name = "Famille.findByCreepar", query = "SELECT f FROM Famille f WHERE f.creepar = :creepar")
    , @NamedQuery(name = "Famille.findByModifiele", query = "SELECT f FROM Famille f WHERE f.modifiele = :modifiele")
    , @NamedQuery(name = "Famille.delete", query = "DELETE FROM Famille f WHERE f.codefamille = :id")
    , @NamedQuery(name = "Famille.findByGroupe", query = "SELECT f FROM Famille f WHERE f.idgroupe IN(SELECT g.idgroupe FROM Groupe g WHERE g.idgroupe=:code)")
    , @NamedQuery(name = "Famille.findByModifiepar", query = "SELECT f FROM Famille f WHERE f.modifiepar = :modifiepar")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODEFAMILLE")
    private String codefamille;
    @Size(max = 30)
    @Column(name = "NOMFAMILLE")
    private String nomfamille;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codefamille")
    private List<Type> typeCollection;
    @JoinColumn(name = "IDGROUPE", referencedColumnName = "IDGROUPE")
    @ManyToOne(optional = false)
    private Groupe idgroupe;

    public Famille() {
    }

    public Famille(String codefamille) {
        this.codefamille = codefamille;
    }

    public String getCodefamille() {
        return codefamille;
    }

    public void setCodefamille(String codefamille) {
        this.codefamille = codefamille;
    }

    public String getNomfamille() {
        return nomfamille;
    }

    public void setNomfamille(String nomfamille) {
        this.nomfamille = nomfamille;
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

    public Collection<Type> getTypeCollection() {
        return typeCollection;
    }

    public void setTypeCollection(List<Type> typeCollection) {
        this.typeCollection = (List<Type>) typeCollection;
    }

    public Groupe getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Groupe idgroupe) {
        this.idgroupe = idgroupe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codefamille != null ? codefamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.codefamille == null && other.codefamille != null) || (this.codefamille != null && !this.codefamille.equals(other.codefamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Famille[ codefamille=" + codefamille + " ]";
    }

}
