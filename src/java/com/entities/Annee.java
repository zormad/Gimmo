/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "ANNEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annee.findAll", query = "SELECT a FROM Annee a")
    , @NamedQuery(name = "Annee.findByAnneeid", query = "SELECT a FROM Annee a WHERE a.anneeid = :anneeid")})
public class Annee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANNEEID")
    private Short anneeid;

    public Annee() {
    }

    public Annee(Short anneeid) {
        this.anneeid = anneeid;
    }

    public Short getAnneeid() {
        return anneeid;
    }

    public void setAnneeid(Short anneeid) {
        this.anneeid = anneeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anneeid != null ? anneeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annee)) {
            return false;
        }
        Annee other = (Annee) object;
        if ((this.anneeid == null && other.anneeid != null) || (this.anneeid != null && !this.anneeid.equals(other.anneeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Annee[ anneeid=" + anneeid + " ]";
    }
    
}
