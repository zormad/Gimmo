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
@Table(name = "TYPERETOUR", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Typeretour.findAll", query = "SELECT t FROM Typeretour t")
    , @NamedQuery(name = "Typeretour.findByIdtyperetour", query = "SELECT t FROM Typeretour t WHERE t.idtyperetour = :idtyperetour")
    , @NamedQuery(name = "Typeretour.delete", query = "DELETE FROM Typeretour t WHERE t.idtyperetour = :id")
     , @NamedQuery(name = "Typeretour.findByLibelletyperetour", query = "SELECT t FROM Typeretour t WHERE t.libelletyperetour = :libelletyperetour")
    , @NamedQuery(name = "Typeretour.findByCreele", query = "SELECT t FROM Typeretour t WHERE t.creele = :creele")
    , @NamedQuery(name = "Typeretour.findByCreepar", query = "SELECT t FROM Typeretour t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Typeretour.findByModifiele", query = "SELECT t FROM Typeretour t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Typeretour.findByModifiepar", query = "SELECT t FROM Typeretour t WHERE t.modifiepar = :modifiepar")})
public class Typeretour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDTYPERETOUR")
    private String idtyperetour;
    @Size(max = 30)
    @Column(name = "LIBELLETYPERETOUR")
    private String libelletyperetour;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtyperetour")
    private Collection<Retourner> retournerCollection;

    public Typeretour() {
    }

    public Typeretour(String idtyperetour) {
        this.idtyperetour = idtyperetour;
    }

    public String getIdtyperetour() {
        return idtyperetour;
    }

    public void setIdtyperetour(String idtyperetour) {
        this.idtyperetour = idtyperetour;
    }

    public String getLibelletyperetour() {
        return libelletyperetour;
    }

    public void setLibelletyperetour(String libelletyperetour) {
        this.libelletyperetour = libelletyperetour;
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

    public Collection<Retourner> getRetournerCollection() {
        return retournerCollection;
    }

    public void setRetournerCollection(Collection<Retourner> retournerCollection) {
        this.retournerCollection = retournerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtyperetour != null ? idtyperetour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeretour)) {
            return false;
        }
        Typeretour other = (Typeretour) object;
        if ((this.idtyperetour == null && other.idtyperetour != null) || (this.idtyperetour != null && !this.idtyperetour.equals(other.idtyperetour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Typeretour[ idtyperetour=" + idtyperetour + " ]";
    }
    
}
