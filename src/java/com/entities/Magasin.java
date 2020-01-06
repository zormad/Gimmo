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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAGASIN", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Magasin.findAll", query = "SELECT m FROM Magasin m")
    , @NamedQuery(name = "Magasin.findByIdcodemagasin", query = "SELECT m FROM Magasin m WHERE m.idcodemagasin = :idcodemagasin")
    , @NamedQuery(name = "Magasin.findByNommagasin", query = "SELECT m FROM Magasin m WHERE m.nommagasin = :nommagasin")
    , @NamedQuery(name = "Magasin.findByCreele", query = "SELECT m FROM Magasin m WHERE m.creele = :creele")
    , @NamedQuery(name = "Magasin.findByCreepar", query = "SELECT m FROM Magasin m WHERE m.creepar = :creepar")
    , @NamedQuery(name = "Magasin.findByModifiele", query = "SELECT m FROM Magasin m WHERE m.modifiele = :modifiele")
    , @NamedQuery(name = "Magasin.delete", query = "DELETE FROM Magasin m WHERE m.idcodemagasin = :id")
    , @NamedQuery(name = "Magasin.findByStructure", query = "SELECT m FROM Magasin m WHERE m.codestructure IN(SELECT s.codestructure FROM Structure s WHERE s.codestructure=:code)")
    , @NamedQuery(name = "Magasin.findPrincipal", query = "SELECT m FROM Magasin m WHERE m.idtypemag IN(SELECT t FROM Typemagasin t WHERE t.idtypemag=:type)")
       , @NamedQuery(name = "Magasin.findByModifiepar", query = "SELECT m FROM Magasin m WHERE m.modifiepar = :modifiepar")})
public class Magasin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDCODEMAGASIN")
    private String idcodemagasin;
    @Size(max = 100)
    @Column(name = "NOMMAGASIN")
    private String nommagasin;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magasin")
    private Collection<Inventairemagasin> inventairemagasinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magasin")
    private Collection<Retourner> retournerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magasin")
    private Collection<Dotation> dotationCollection;
    @JoinColumn(name = "CODESTRUCTURE", referencedColumnName = "CODESTRUCTURE")
    @ManyToOne(optional = true)
    private Structure codestructure;
    @JoinColumn(name = "IDTYPEMAG", referencedColumnName = "IDTYPEMAG")
    @ManyToOne(optional = false)
    private Typemagasin idtypemag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcodemagasin")
    private Collection<Bon> bonCollection;

    public Magasin() {
    }

    public Magasin(String idcodemagasin) {
        this.idcodemagasin = idcodemagasin;
    }

    public String getIdcodemagasin() {
        return idcodemagasin;
    }

    public void setIdcodemagasin(String idcodemagasin) {
        this.idcodemagasin = idcodemagasin;
    }

    public String getNommagasin() {
        return nommagasin;
    }

    public void setNommagasin(String nommagasin) {
        this.nommagasin = nommagasin;
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

    public Collection<Inventairemagasin> getInventairemagasinCollection() {
        return inventairemagasinCollection;
    }

    public void setInventairemagasinCollection(Collection<Inventairemagasin> inventairemagasinCollection) {
        this.inventairemagasinCollection = inventairemagasinCollection;
    }

    public Collection<Retourner> getRetournerCollection() {
        return retournerCollection;
    }

    public void setRetournerCollection(Collection<Retourner> retournerCollection) {
        this.retournerCollection = retournerCollection;
    }

    public Collection<Dotation> getDotationCollection() {
        return dotationCollection;
    }

    public void setDotationCollection(Collection<Dotation> dotationCollection) {
        this.dotationCollection = dotationCollection;
    }

    public Structure getCodestructure() {
        return codestructure;
    }

    public void setCodestructure(Structure codestructure) {
        this.codestructure = codestructure;
    }

    public Typemagasin getIdtypemag() {
        return idtypemag;
    }

    public void setIdtypemag(Typemagasin idtypemag) {
        this.idtypemag = idtypemag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcodemagasin != null ? idcodemagasin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magasin)) {
            return false;
        }
        Magasin other = (Magasin) object;
        if ((this.idcodemagasin == null && other.idcodemagasin != null) || (this.idcodemagasin != null && !this.idcodemagasin.equals(other.idcodemagasin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Magasin[ idcodemagasin=" + idcodemagasin + " ]";
    }

    public Collection<Bon> getBonCollection() {
        return bonCollection;
    }

    public void setBonCollection(Collection<Bon> bonCollection) {
        this.bonCollection = bonCollection;
    }

}
