/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "CATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c")
    , @NamedQuery(name = "Categorie.findByIdcategorie", query = "SELECT c FROM Categorie c WHERE c.idcategorie = :idcategorie")
    , @NamedQuery(name = "Categorie.findByCreele", query = "SELECT c FROM Categorie c WHERE c.creele = :creele")
    , @NamedQuery(name = "Categorie.findByCreepar", query = "SELECT c FROM Categorie c WHERE c.creepar = :creepar")
    , @NamedQuery(name = "Categorie.findByModifierle", query = "SELECT c FROM Categorie c WHERE c.modifierle = :modifierle")
    , @NamedQuery(name = "Categorie.findByModifierpar", query = "SELECT c FROM Categorie c WHERE c.modifierpar = :modifierpar")
    , @NamedQuery(name = "Categorie.findByDescriptioncategorie", query = "SELECT c FROM Categorie c WHERE c.descriptioncategorie = :descriptioncategorie")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "IDCATEGORIE")
    private String idcategorie;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIERLE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifierle;
    @Size(max = 6)
    @Column(name = "MODIFIERPAR")
    private String modifierpar;
    @Size(max = 4)
    @Column(name = "DESCRIPTIONCATEGORIE")
    private String descriptioncategorie;

    public Categorie() {
    }

    public Categorie(String idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(String idcategorie) {
        this.idcategorie = idcategorie;
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

    public String getDescriptioncategorie() {
        return descriptioncategorie;
    }

    public void setDescriptioncategorie(String descriptioncategorie) {
        this.descriptioncategorie = descriptioncategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Categorie[ idcategorie=" + idcategorie + " ]";
    }
    
}
