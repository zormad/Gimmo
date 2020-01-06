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
@Table(name = "TYPESTRUCTURE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Typestructure.findAll", query = "SELECT t FROM Typestructure t")
    , @NamedQuery(name = "Typestructure.findByIdtypestruct", query = "SELECT t FROM Typestructure t WHERE t.idtypestruct = :idtypestruct")
    , @NamedQuery(name = "Typestructure.findByLibelletypestruct", query = "SELECT t FROM Typestructure t WHERE t.libelletypestruct = :libelletypestruct")
    , @NamedQuery(name = "Typestructure.findByCreele", query = "SELECT t FROM Typestructure t WHERE t.creele = :creele")
    , @NamedQuery(name = "Typestructure.findByCreepar", query = "SELECT t FROM Typestructure t WHERE t.creepar = :creepar")
    , @NamedQuery(name = "Typestructure.findByModifiele", query = "SELECT t FROM Typestructure t WHERE t.modifiele = :modifiele")
    , @NamedQuery(name = "Typestructure.findByModifiepar", query = "SELECT t FROM Typestructure t WHERE t.modifiepar = :modifiepar")})
public class Typestructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "IDTYPESTRUCT")
    private String idtypestruct;
    @Size(max = 30)
    @Column(name = "LIBELLETYPESTRUCT")
    private String libelletypestruct;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypestruct")
    private Collection<Structure> structureCollection;

    public Typestructure() {
    }

    public Typestructure(String idtypestruct) {
        this.idtypestruct = idtypestruct;
    }

    public String getIdtypestruct() {
        return idtypestruct;
    }

    public void setIdtypestruct(String idtypestruct) {
        this.idtypestruct = idtypestruct;
    }

    public String getLibelletypestruct() {
        return libelletypestruct;
    }

    public void setLibelletypestruct(String libelletypestruct) {
        this.libelletypestruct = libelletypestruct;
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

    public Collection<Structure> getStructureCollection() {
        return structureCollection;
    }

    public void setStructureCollection(Collection<Structure> structureCollection) {
        this.structureCollection = structureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypestruct != null ? idtypestruct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typestructure)) {
            return false;
        }
        Typestructure other = (Typestructure) object;
        if ((this.idtypestruct == null && other.idtypestruct != null) || (this.idtypestruct != null && !this.idtypestruct.equals(other.idtypestruct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Typestructure[ idtypestruct=" + idtypestruct + " ]";
    }
    
}
