/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "UTILISATEUR", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIduser", query = "SELECT u FROM Utilisateur u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Utilisateur.findByLoginuser", query = "SELECT u FROM Utilisateur u WHERE u.loginuser = :loginuser")
    , @NamedQuery(name = "Utilisateur.findByLoginpasswd", query = "SELECT u FROM Utilisateur u WHERE u.loginpasswd = :loginpasswd")
    , @NamedQuery(name = "Utilisateur.findByConnecte", query = "SELECT u FROM Utilisateur u WHERE u.connecte = :connecte")
    , @NamedQuery(name = "Utilisateur.findByDerniereconnexion", query = "SELECT u FROM Utilisateur u WHERE u.derniereconnexion = :derniereconnexion")
    , @NamedQuery(name = "Utilisateur.findByCreele", query = "SELECT u FROM Utilisateur u WHERE u.creele = :creele")
    , @NamedQuery(name = "Utilisateur.findByCreepar", query = "SELECT u FROM Utilisateur u WHERE u.creepar = :creepar")
    , @NamedQuery(name = "Utilisateur.findByModifiele", query = "SELECT u FROM Utilisateur u WHERE u.modifiele = :modifiele")
    , @NamedQuery(name = "Utilisateur.find", query = "SELECT u FROM Utilisateur u WHERE u.loginuser = :loginuser AND u.loginpasswd = :loginpasswd")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "util_seq")
    @SequenceGenerator(
            name = "util_seq",
            sequenceName = "util_iduser_seq",
            allocationSize = 20
    )
    private BigDecimal iduser;
    @Size(max = 30)
    @Column(name = "LOGINUSER")
    private String loginuser;
    @Size(max = 45)
    @Column(name = "LOGINPASSWD")
    private String loginpasswd;
    @Column(name = "CONNECTE")
    private BigInteger connecte;
    @Column(name = "DERNIERECONNEXION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date derniereconnexion;
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
    @JoinColumn(name = "IDPROFIL", referencedColumnName = "IDPROFIL")
    @ManyToOne(optional = false)
    private Profil idprofil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Affectationutilisateur> affectationutilisateurCollection;

    public Utilisateur() {
    }

    public Utilisateur(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public BigDecimal getIduser() {
        return iduser;
    }

    public void setIduser(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public String getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }

    public String getLoginpasswd() {
        return loginpasswd;
    }

    public void setLoginpasswd(String loginpasswd) {
        this.loginpasswd = loginpasswd;
    }

    public BigInteger getConnecte() {
        return connecte;
    }

    public void setConnecte(BigInteger connecte) {
        this.connecte = connecte;
    }

    public Date getDerniereconnexion() {
        return derniereconnexion;
    }

    public void setDerniereconnexion(Date derniereconnexion) {
        this.derniereconnexion = derniereconnexion;
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

    public Profil getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(Profil idprofil) {
        this.idprofil = idprofil;
    }

    public Collection<Affectationutilisateur> getAffectationutilisateurCollection() {
        return affectationutilisateurCollection;
    }

    public void setAffectationutilisateurCollection(Collection<Affectationutilisateur> affectationutilisateurCollection) {
        this.affectationutilisateurCollection = affectationutilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Utilisateur[ iduser=" + iduser + " ]";
    }

}
