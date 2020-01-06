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
@Table(name = "MARQUE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m")
    , @NamedQuery(name = "Marque.findByIdmarque", query = "SELECT m FROM Marque m WHERE m.idmarque = :idmarque")
    , @NamedQuery(name = "Marque.findByNommarque", query = "SELECT m FROM Marque m WHERE m.nommarque = :nommarque")
    , @NamedQuery(name = "Marque.findByCreele", query = "SELECT m FROM Marque m WHERE m.creele = :creele")
    , @NamedQuery(name = "Marque.findByCreepar", query = "SELECT m FROM Marque m WHERE m.creepar = :creepar")
    , @NamedQuery(name = "Marque.findByModifiele", query = "SELECT m FROM Marque m WHERE m.modifiele = :modifiele")
    , @NamedQuery(name = "Marque.findByModifiepar", query = "SELECT m FROM Marque m WHERE m.modifiepar = :modifiepar")})
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "IDMARQUE")
    private String idmarque;
    @Size(max = 15)
    @Column(name = "NOMMARQUE")
    private String nommarque;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @Size(max = 254)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarque")
    private Collection<Equipement> equipementCollection;

    public Marque() {
    }

    public Marque(String idmarque) {
        this.idmarque = idmarque;
    }

    public String getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(String idmarque) {
        this.idmarque = idmarque;
    }

    public String getNommarque() {
        return nommarque;
    }

    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarque != null ? idmarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.idmarque == null && other.idmarque != null) || (this.idmarque != null && !this.idmarque.equals(other.idmarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nommarque + "";
    }
    
}
