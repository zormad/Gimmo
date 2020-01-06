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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "BONDEMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bondemande.findAll", query = "SELECT b FROM Bondemande b")
   ,@NamedQuery(name = "Bondemande.findAllValider", query = "SELECT b FROM Bondemande b where b.valider = :valider order by b.idbondemande")
    ,@NamedQuery(name = "Bondemande.findDemande", query = "SELECT b FROM Bondemande b WHERE b.magasin IN (SELECT m FROM Magasin m WHERE m.idcodemagasin = :idcodemagasin) ORDER BY b.idbondemande DESC ")
    , @NamedQuery(name = "Bondemande.findByIdbondemande", query = "SELECT b FROM Bondemande b WHERE b.idbondemande = :idbondemande")})
public class Bondemande implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bondemande_seq")
    @SequenceGenerator(
            name = "bondemande_seq",
            sequenceName = "bondemande_idbondemande_seq",
            allocationSize = 1
    )
    @Column(name = "IDBONDEMANDE")
    private BigDecimal idbondemande;
    @Column(name = "VALIDER")
    private String valider="false";
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin magasin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bondemande")
    private Collection<Demandedotation> demandeCollection;

    public Bondemande() {
    }

    public Bondemande(BigDecimal idbondemande) {
        this.idbondemande = idbondemande;
    }

    public BigDecimal getIdbondemande() {
        return idbondemande;
    }

    public void setIdbondemande(BigDecimal idbondemande) {
        this.idbondemande = idbondemande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbondemande != null ? idbondemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bondemande)) {
            return false;
        }
        Bondemande other = (Bondemande) object;
        if ((this.idbondemande == null && other.idbondemande != null) || (this.idbondemande != null && !this.idbondemande.equals(other.idbondemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Bondemande[ idbondemande=" + idbondemande + " ]";
    }

    public Collection<Demandedotation> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demandedotation> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
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

}
