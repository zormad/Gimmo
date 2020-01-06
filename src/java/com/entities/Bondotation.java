/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "BONDOTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bondotation.findAll", query = "SELECT b FROM Bondotation b")
    , @NamedQuery(name = "Bondotation.findByvalider", query = "select b from Bondotation b where b.valider= :valider and b.idcodemagasin in (select m.idcodemagasin from Magasin m where m.idcodemagasin =:magasin)")
    , @NamedQuery(name = "Bondotation.findByIdbondotation", query = "SELECT b FROM Bondotation b WHERE b.idbondotation = :idbondotation")
    , @NamedQuery(name = "Bondotation.findByLibellebondotation", query = "SELECT b FROM Bondotation b WHERE b.libellebondotation = :libellebondotation")
    , @NamedQuery(name = "Bondotation.findByCreele", query = "SELECT b FROM Bondotation b WHERE b.creele = :creele")
    , @NamedQuery(name = "Bondotation.findByCreepar", query = "SELECT b FROM Bondotation b WHERE b.creepar = :creepar")
    , @NamedQuery(name = "Bondotation.findByModifiepar", query = "SELECT b FROM Bondotation b WHERE b.modifiepar = :modifiepar")
    , @NamedQuery(name = "Bondotation.findByModifiele", query = "SELECT b FROM Bondotation b WHERE b.modifiele = :modifiele")})
public class Bondotation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBONDOTATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bondotation_seq")
    @SequenceGenerator(
            name = "bondotation_seq",
            sequenceName = "bondotation_id_seq",
            allocationSize = 1
    )
    private BigDecimal idbondotation;
    @Size(max = 100)
    @Column(name = "LIBELLEBONDOTATION")
    private String libellebondotation;
    @Column(name = "VALIDER")
    private String valider;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 30)
    @Column(name = "CREEPAR")
    private String creepar;
    @Size(max = 30)
    @Column(name = "MODIFIEPAR")
    private String modifiepar;
    @Column(name = "MODIFIELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiele;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = false)
    private Magasin idcodemagasin;

    public Bondotation() {
    }

    public Bondotation(BigDecimal idbondotation) {
        this.idbondotation = idbondotation;
    }

    public BigDecimal getIdbondotation() {
        return idbondotation;
    }

    public void setIdbondotation(BigDecimal idbondotation) {
        this.idbondotation = idbondotation;
    }

    public String getLibellebondotation() {
        return libellebondotation;
    }

    public void setLibellebondotation(String libellebondotation) {
        this.libellebondotation = libellebondotation;
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

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Date getModifiele() {
        return modifiele;
    }

    public void setModifiele(Date modifiele) {
        this.modifiele = modifiele;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbondotation != null ? idbondotation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bondotation)) {
            return false;
        }
        Bondotation other = (Bondotation) object;
        if ((this.idbondotation == null && other.idbondotation != null) || (this.idbondotation != null && !this.idbondotation.equals(other.idbondotation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Bondotation[ idbondotation=" + idbondotation + " ]";
    }

    public Magasin getIdcodemagasin() {
        return idcodemagasin;
    }

    public void setIdcodemagasin(Magasin idcodemagasin) {
        this.idcodemagasin = idcodemagasin;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

}
