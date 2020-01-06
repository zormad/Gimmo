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
@Table(name = "SOURCEDEFINANCEMENT", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Sourcedefinancement.findAll", query = "SELECT s FROM Sourcedefinancement s")
    , @NamedQuery(name = "Sourcedefinancement.findByIdsource", query = "SELECT s FROM Sourcedefinancement s WHERE s.idsource = :idsource")
    , @NamedQuery(name = "Sourcedefinancement.findByLibellesource", query = "SELECT s FROM Sourcedefinancement s WHERE s.libellesource = :libellesource")
    , @NamedQuery(name = "Sourcedefinancement.findByCreele", query = "SELECT s FROM Sourcedefinancement s WHERE s.creele = :creele")
    , @NamedQuery(name = "Sourcedefinancement.findByCreepar", query = "SELECT s FROM Sourcedefinancement s WHERE s.creepar = :creepar")
    , @NamedQuery(name = "Sourcedefinancement.findByModifiele", query = "SELECT s FROM Sourcedefinancement s WHERE s.modifiele = :modifiele")
    , @NamedQuery(name = "Sourcedefinancement.findByModifiepar", query = "SELECT s FROM Sourcedefinancement s WHERE s.modifiepar = :modifiepar")})
public class Sourcedefinancement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOURCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_seq")
    @SequenceGenerator(
            name = "source_seq",
            sequenceName = "source_idsource_seq",
            allocationSize = 20
    )
    private BigDecimal idsource;
    @Size(max = 60)
    @Column(name = "LIBELLESOURCE")
    private String libellesource;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsource")
    private Collection<Bon> bonCollection;

    public Sourcedefinancement() {
    }

    public Sourcedefinancement(BigDecimal idsource) {
        this.idsource = idsource;
    }

    public BigDecimal getIdsource() {
        return idsource;
    }

    public void setIdsource(BigDecimal idsource) {
        this.idsource = idsource;
    }

    public String getLibellesource() {
        return libellesource;
    }

    public void setLibellesource(String libellesource) {
        this.libellesource = libellesource;
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

    public Collection<Bon> getBonCollection() {
        return bonCollection;
    }

    public void setBonCollection(Collection<Bon> bonCollection) {
        this.bonCollection = bonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsource != null ? idsource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sourcedefinancement)) {
            return false;
        }
        Sourcedefinancement other = (Sourcedefinancement) object;
        if ((this.idsource == null && other.idsource != null) || (this.idsource != null && !this.idsource.equals(other.idsource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Sourcedefinancement[ idsource=" + idsource + " ]";
    }
    
}
