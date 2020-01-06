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
//import javax.persistence.EmbeddedId;
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
@Table(name = "SERVICE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByCodeservice", query = "SELECT s FROM Service s WHERE s.codeservice = :codeservice")
    , @NamedQuery(name = "Service.findByLibelleservice", query = "SELECT s FROM Service s WHERE s.libelleservice = :libelleservice")
    , @NamedQuery(name = "Service.findByCreele", query = "SELECT s FROM Service s WHERE s.creele = :creele")
    , @NamedQuery(name = "Service.findByCreepar", query = "SELECT s FROM Service s WHERE s.creepar = :creepar")
    , @NamedQuery(name = "Service.findByModifiele", query = "SELECT s FROM Service s WHERE s.modifiele = :modifiele")
    , @NamedQuery(name = "Service.findByModifiepar", query = "SELECT s FROM Service s WHERE s.modifiepar = :modifiepar")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODESERVICE")
    private String codeservice;
    @Size(max = 60)
    @Column(name = "LIBELLESERVICE")
    private String libelleservice;
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
    @OneToMany(mappedBy = "service")
    private List<Agent> agentCollection;
    @JoinColumn(name = "IDAGENT", referencedColumnName = "IDAGENT")
    @ManyToOne(optional = false)
    private Agent idagent;
    @JoinColumn(name = "CODESTRUCTURE", referencedColumnName = "CODESTRUCTURE")
    @ManyToOne(optional = false)
    private Structure structure;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
//    private List<Besoins> besoinsCollection;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "service")
    private List<Postedetravail> postedetravailCollection;

    public Service() {
    }

    
    public String getCodeservice() {
        return codeservice;
    }
    public void setCodeservice(String codeservice) {    
        this.codeservice = codeservice;
    }

    public String getLibelleservice() {
        return libelleservice;
    }

    public void setLibelleservice(String libelleservice) {
        this.libelleservice = libelleservice;
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

    public List<Agent> getAgentCollection() {
        return agentCollection;
    }

    public void setAgentCollection(List<Agent> agentCollection) {
        this.agentCollection = agentCollection;
    }

    public Agent getIdagent() {
        return idagent;
    }

    public void setIdagent(Agent idagent) {
        this.idagent = idagent;
    }

    
    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

//    public List<Besoins> getBesoinsCollection() {
//        return besoinsCollection;
//    }
//
//    public void setBesoinsCollection(List<Besoins> besoinsCollection) {
//        this.besoinsCollection = besoinsCollection;
//    }

    public List<Postedetravail> getPostedetravailCollection() {
        return postedetravailCollection;
    }

    public void setPostedetravailCollection(List<Postedetravail> postedetravailCollection) {
        this.postedetravailCollection = postedetravailCollection;
    }
    
    
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicePK != null ? servicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.servicePK == null && other.servicePK != null) || (this.servicePK != null && !this.servicePK.equals(other.servicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Service[ servicePK=" + servicePK + " ]";
    }
*/
}
