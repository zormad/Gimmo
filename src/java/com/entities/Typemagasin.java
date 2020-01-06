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
@Table(name = "TYPEMAGASIN", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Typemagasin.findAll", query = "SELECT t FROM Typemagasin t")
    , @NamedQuery(name = "Typemagasin.findByIdtypemag", query = "SELECT t FROM Typemagasin t WHERE t.idtypemag = :idtypemag")
    , @NamedQuery(name = "Typemagasin.findByLibelletypemag", query = "SELECT t FROM Typemagasin t WHERE t.libelletypemag = :libelletypemag")
    , @NamedQuery(name = "Typemagasin.findByCreele", query = "SELECT t FROM Typemagasin t WHERE t.creele = :creele")
    , @NamedQuery(name = "Typemagasin.findByCreepar", query = "SELECT t FROM Typemagasin t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Typemagasin.findByModifiele", query = "SELECT t FROM Typemagasin t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Typemagasin.findByModifiepar", query = "SELECT t FROM Typemagasin t WHERE t.modifiepar = :modifiepar")})
public class Typemagasin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDTYPEMAG")
    private String idtypemag;
    @Size(max = 254)
    @Column(name = "LIBELLETYPEMAG")
    private String libelletypemag;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypemag")
    private Collection<Magasin> magasinCollection;

    public Typemagasin() {
    }

    public Typemagasin(String idtypemag) {
        this.idtypemag = idtypemag;
    }

    public String getIdtypemag() {
        return idtypemag;
    }

    public void setIdtypemag(String idtypemag) {
        this.idtypemag = idtypemag;
    }

    public String getLibelletypemag() {
        return libelletypemag;
    }

    public void setLibelletypemag(String libelletypemag) {
        this.libelletypemag = libelletypemag;
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

    public Collection<Magasin> getMagasinCollection() {
        return magasinCollection;
    }

    public void setMagasinCollection(Collection<Magasin> magasinCollection) {
        this.magasinCollection = magasinCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypemag != null ? idtypemag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typemagasin)) {
            return false;
        }
        Typemagasin other = (Typemagasin) object;
        if ((this.idtypemag == null && other.idtypemag != null) || (this.idtypemag != null && !this.idtypemag.equals(other.idtypemag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Typemagasin[ idtypemag=" + idtypemag + " ]";
    }
    
}
