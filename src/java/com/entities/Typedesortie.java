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
@Table(name = "TYPEDESORTIE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Typedesortie.findAll", query = "SELECT t FROM Typedesortie t")
    , @NamedQuery(name = "Typedesortie.findByIdtypesortie", query = "SELECT t FROM Typedesortie t WHERE t.idtypesortie = :idtypesortie")
    , @NamedQuery(name = "Typedesortie.findByLibelletypesortie", query = "SELECT t FROM Typedesortie t WHERE t.libelletypesortie = :libelletypesortie")
    , @NamedQuery(name = "Typedesortie.findByCreele", query = "SELECT t FROM Typedesortie t WHERE t.creele = :creele")
    , @NamedQuery(name = "Typedesortie.findByCreepar", query = "SELECT t FROM Typedesortie t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Typedesortie.findByModifiele", query = "SELECT t FROM Typedesortie t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Typedesortie.findByModifiepar", query = "SELECT t FROM Typedesortie t WHERE t.modifiepar = :modifiepar")})
public class Typedesortie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDTYPESORTIE")
    private String idtypesortie;
    @Size(max = 254)
    @Column(name = "LIBELLETYPESORTIE")
    private String libelletypesortie;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypesortie")
    private Collection<Sortie> sortieCollection;

    public Typedesortie() {
    }

    public Typedesortie(String idtypesortie) {
        this.idtypesortie = idtypesortie;
    }

    public String getIdtypesortie() {
        return idtypesortie;
    }

    public void setIdtypesortie(String idtypesortie) {
        this.idtypesortie = idtypesortie;
    }

    public String getLibelletypesortie() {
        return libelletypesortie;
    }

    public void setLibelletypesortie(String libelletypesortie) {
        this.libelletypesortie = libelletypesortie;
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

    public Collection<Sortie> getSortieCollection() {
        return sortieCollection;
    }

    public void setSortieCollection(Collection<Sortie> sortieCollection) {
        this.sortieCollection = sortieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypesortie != null ? idtypesortie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typedesortie)) {
            return false;
        }
        Typedesortie other = (Typedesortie) object;
        if ((this.idtypesortie == null && other.idtypesortie != null) || (this.idtypesortie != null && !this.idtypesortie.equals(other.idtypesortie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Typedesortie[ idtypesortie=" + idtypesortie + " ]";
    }
    
}
