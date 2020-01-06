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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "POSTEDETRAVAIL", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Postedetravail.findAll", query = "SELECT p FROM Postedetravail p")
    , @NamedQuery(name = "Postedetravail.findByIdposte", query = "SELECT p FROM Postedetravail p WHERE p.idposte = :idposte")
    , @NamedQuery(name = "Postedetravail.findByNomposte", query = "SELECT p FROM Postedetravail p WHERE p.nomposte = :nomposte")
    , @NamedQuery(name = "Postedetravail.findByCreele", query = "SELECT p FROM Postedetravail p WHERE p.creele = :creele")
    , @NamedQuery(name = "Postedetravail.findByCreepar", query = "SELECT p FROM Postedetravail p WHERE p.creepar = :creepar")
    , @NamedQuery(name = "Postedetravail.findByModifiele", query = "SELECT p FROM Postedetravail p WHERE p.modifiele = :modifiele")
    , @NamedQuery(name = "Postedetravail.findByModifiepar", query = "SELECT p FROM Postedetravail p WHERE p.modifiepar = :modifiepar")})
public class Postedetravail implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOSTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poste_seq")
    @SequenceGenerator(
            name = "poste_seq",
            sequenceName = "poste_idposte_seq",
            allocationSize = 1
    )
    private BigDecimal idposte;
    @Size(max = 30)
    @Column(name = "NOMPOSTE")
    private String nomposte;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedetravail")
    private Collection<Affectation> affectationCollection;
   @JoinColumn(name = "CODESERVICE", referencedColumnName = "CODESERVICE")
    @ManyToOne(optional = false)
    private Service service;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedetravail")
    private Collection<Occupation> occupationCollection;

    public Postedetravail() {
    }

    public Postedetravail(BigDecimal idposte) {
        this.idposte = idposte;
    }

    public BigDecimal getIdposte() {
        return idposte;
    }

    public void setIdposte(BigDecimal idposte) {
        this.idposte = idposte;
    }

    public String getNomposte() {
        return nomposte;
    }

    public void setNomposte(String nomposte) {
        this.nomposte = nomposte;
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

    public Collection<Affectation> getAffectationCollection() {
        return affectationCollection;
    }

    public void setAffectationCollection(Collection<Affectation> affectationCollection) {
        this.affectationCollection = affectationCollection;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposte != null ? idposte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postedetravail)) {
            return false;
        }
        Postedetravail other = (Postedetravail) object;
        if ((this.idposte == null && other.idposte != null) || (this.idposte != null && !this.idposte.equals(other.idposte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Postedetravail[ idposte=" + idposte + " ]";
    }
    
}
