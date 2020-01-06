/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "INVENTAIRESTRUCTURE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Inventairestructure.findAll", query = "SELECT i FROM Inventairestructure i")
   , @NamedQuery(name = "Inventairestructure.findByIdinventaire", query = "SELECT i FROM Inventairestructure i WHERE i.idinventaire = :idinventaire")
    , @NamedQuery(name = "Inventairestructure.findByDateinv", query = "SELECT i FROM Inventairestructure i WHERE i.dateinv = :dateinv")
    , @NamedQuery(name = "Inventairestructure.findByQuantite", query = "SELECT i FROM Inventairestructure i WHERE i.quantite = :quantite")
    , @NamedQuery(name = "Inventairestructure.findByCreele", query = "SELECT i FROM Inventairestructure i WHERE i.creele = :creele")
    , @NamedQuery(name = "Inventairestructure.findByCreepar", query = "SELECT i FROM Inventairestructure i WHERE i.creepar = :creepar")
    , @NamedQuery(name = "Inventairestructure.findByModifiele", query = "SELECT i FROM Inventairestructure i WHERE i.modifiele = :modifiele")
    , @NamedQuery(name = "Inventairestructure.findByModifiepar", query = "SELECT i FROM Inventairestructure i WHERE i.modifiepar = :modifiepar")})
public class Inventairestructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @Basic(optional = false)
    @Column(name = "IDINVENTAIRE")
    private BigInteger idinventaire;
    @Column(name = "DATEINV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinv;
    @Column(name = "QUANTITE")
    private BigInteger quantite;
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
    @JoinColumn(name = "CODESTRUCTURE", referencedColumnName = "CODESTRUCTURE")
    @ManyToOne(optional = false)
    private Structure structure;

    public Inventairestructure() {
    }

    public Date getDateinv() {
        return dateinv;
    }

    public void setDateinv(Date dateinv) {
        this.dateinv = dateinv;
    }

    public BigInteger getQuantite() {
        return quantite;
    }

    public void setQuantite(BigInteger quantite) {
        this.quantite = quantite;
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

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public BigInteger getIdinventaire() {
        return idinventaire;
    }

    public void setIdinventaire(BigInteger idinventaire) {
        this.idinventaire = idinventaire;
    }
    
}
