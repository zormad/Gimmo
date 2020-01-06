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
@Table(name = "AGENTCAT", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Agentcat.findAll", query = "SELECT a FROM Agentcat a")
   , @NamedQuery(name = "Agentcat.findByDateaff", query = "SELECT a FROM Agentcat a WHERE a.dateaff = :dateaff")
    , @NamedQuery(name = "Agentcat.findByCreele", query = "SELECT a FROM Agentcat a WHERE a.creele = :creele")
    , @NamedQuery(name = "Agentcat.findByCreepar", query = "SELECT a FROM Agentcat a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Agentcat.findByModifierle", query = "SELECT a FROM Agentcat a WHERE a.modifierle = :modifierle")
    , @NamedQuery(name = "Agentcat.findByModifierpar", query = "SELECT a FROM Agentcat a WHERE a.modifierpar = :modifierpar")})
public class Agentcat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATEAFF")
    private BigInteger dateaff;
    @Column(name = "CREELE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creele;
    @Size(max = 6)
    @Column(name = "CREEPAR")
    private String creepar;
    @Column(name = "MODIFIERLE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifierle;
    @Size(max = 6)
    @Column(name = "MODIFIERPAR")
    private String modifierpar;
    @JoinColumn(name = "IDAGENT", referencedColumnName = "IDAGENT")
    @ManyToOne(optional = false)
    private Agent agent;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE")
    @ManyToOne(optional = false)
    private Categorie categorie;

    public Agentcat() {
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

    public Date getModifierle() {
        return modifierle;
    }

    public void setModifierle(Date modifierle) {
        this.modifierle = modifierle;
    }

    public String getModifierpar() {
        return modifierpar;
    }

    public void setModifierpar(String modifierpar) {
        this.modifierpar = modifierpar;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public BigInteger getDateaff() {
        return dateaff;
    }

    public void setDateaff(BigInteger dateaff) {
        this.dateaff = dateaff;
    }
    
}
