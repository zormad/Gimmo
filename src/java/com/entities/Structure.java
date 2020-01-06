/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "STRUCTURE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Structure.findAll", query = "SELECT s FROM Structure s")
    , @NamedQuery(name = "Structure.findAllP", query = "SELECT s FROM Structure s WHERE s.codestructure ='mag'")
    ,@NamedQuery(name = "Structure.findAllS", query = "SELECT s FROM Structure s WHERE s.codestructure !='mag'")
    , @NamedQuery(name = "Structure.findByCodestructure", query = "SELECT s FROM Structure s WHERE s.codestructure = :codestructure")
    , @NamedQuery(name = "Structure.findByLibellestructure", query = "SELECT s FROM Structure s WHERE s.libellestructure = :libellestructure")
    , @NamedQuery(name = "Structure.findByCreele", query = "SELECT s FROM Structure s WHERE s.creele = :creele")
    , @NamedQuery(name = "Structure.findByCreepar", query = "SELECT s FROM Structure s WHERE s.creepar = :creepar")
    , @NamedQuery(name = "Structure.findByModifiele", query = "SELECT s FROM Structure s WHERE s.modifiele = :modifiele")
    , @NamedQuery(name = "Structure.delete", query = "DELETE FROM Structure s WHERE s.codestructure = :codestructure")
    , @NamedQuery(name = "Structure.findByModifiepar", query = "SELECT s FROM Structure s WHERE s.modifiepar = :modifiepar")})
public class Structure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODESTRUCTURE")
    private String codestructure;
    @Size(max = 100)
    @Column(name = "LIBELLESTRUCTURE")
    private String libellestructure;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
    private List<Inventairestructure> inventairestructureCollection;
    @OneToMany(mappedBy = "codestructure")
    private List<Agent> agentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
    private List<Service> serviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure")
    private List<Previsions> previsionsCollection;
    @JoinColumn(name = "IDAGENT", referencedColumnName = "IDAGENT")
    @ManyToOne(optional = false)
    private Agent idagent;
    @JoinColumn(name = "IDCODEMAGASIN", referencedColumnName = "IDCODEMAGASIN")
    @ManyToOne(optional = true)
    private Magasin magasin;
    @JoinColumn(name = "IDTYPESTRUCT", referencedColumnName = "IDTYPESTRUCT")
    @ManyToOne(optional = false)
    private Typestructure idtypestruct;

    public Structure() {
    }

    public Structure(String codestructure) {
        this.codestructure = codestructure;
    }

    public String getCodestructure() {
        return codestructure;
    }

    public void setCodestructure(String codestructure) {
        this.codestructure = codestructure;
    }

    public String getLibellestructure() {
        return libellestructure;
    }

    public void setLibellestructure(String libellestructure) {
        this.libellestructure = libellestructure;
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

    public List<Inventairestructure> getInventairestructureCollection() {
        return inventairestructureCollection;
    }

    public void setInventairestructureCollection(List<Inventairestructure> inventairestructureCollection) {
        this.inventairestructureCollection = inventairestructureCollection;
    }

    public List<Agent> getAgentCollection() {
        return agentCollection;
    }

    public void setAgentCollection(List<Agent> agentCollection) {
        this.agentCollection = agentCollection;
    }

    public List<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(List<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public List<Previsions> getPrevisionsCollection() {
        return previsionsCollection;
    }

    public void setPrevisionsCollection(List<Previsions> previsionsCollection) {
        this.previsionsCollection = previsionsCollection;
    }

    public Agent getIdagent() {
        return idagent;
    }

    public void setIdagent(Agent idagent) {
        this.idagent = idagent;
    }

    public Typestructure getIdtypestruct() {
        return idtypestruct;
    }

    public void setIdtypestruct(Typestructure idtypestruct) {
        this.idtypestruct = idtypestruct;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codestructure != null ? codestructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Structure)) {
            return false;
        }
        Structure other = (Structure) object;
        if ((this.codestructure == null && other.codestructure != null) || (this.codestructure != null && !this.codestructure.equals(other.codestructure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Structure[ codestructure=" + codestructure + " ]";
    }

}
