/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "DEMANDEDOTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demandedotation.findAll", query = "SELECT d FROM Demandedotation d")
    , @NamedQuery(name = "Demandedotation.findByIddemande", query = "SELECT d FROM Demandedotation d WHERE d.iddemande = :iddemande")
    , @NamedQuery(name = "Demandedotation.findByDatedemande", query = "SELECT d FROM Demandedotation d WHERE d.datedemande = :datedemande")
    , @NamedQuery(name = "Demandedotation.findByQuantite", query = "SELECT d FROM Demandedotation d WHERE d.quantite = :quantite")})
public class Demandedotation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDEMANDE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demandedotation_seq")
    @SequenceGenerator(
            name = "demandedotation_seq",
            sequenceName = "demandedotation_iddemande_seq",
            allocationSize = 1
    )
    private BigDecimal iddemande;
    @Column(name = "DATEDEMANDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedemande;
    @Column(name = "QUANTITE")
    private BigInteger quantite;
    @JoinColumn(name = "CODEARTICLE", referencedColumnName = "CODEARTICLE")
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "IDBONDEMANDE", referencedColumnName = "IDBONDEMANDE")
    @ManyToOne(optional = false)
    private Bondemande bondemande;

    public Demandedotation() {
    }

    public Demandedotation(BigDecimal iddemande) {
        this.iddemande = iddemande;
    }

    public BigDecimal getIddemande() {
        return iddemande;
    }

    public void setIddemande(BigDecimal iddemande) {
        this.iddemande = iddemande;
    }

    public Date getDatedemande() {
        return datedemande;
    }

    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
    }

    public BigInteger getQuantite() {
        return quantite;
    }

    public void setQuantite(BigInteger quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddemande != null ? iddemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandedotation)) {
            return false;
        }
        Demandedotation other = (Demandedotation) object;
        if ((this.iddemande == null && other.iddemande != null) || (this.iddemande != null && !this.iddemande.equals(other.iddemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Demandedotation[ iddemande=" + iddemande + " ]";
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Bondemande getBondemande() {
        return bondemande;
    }

    public void setBondemande(Bondemande bondemande) {
        this.bondemande = bondemande;
    }

  

}
