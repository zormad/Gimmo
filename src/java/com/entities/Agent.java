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
@Table(name = "AGENT", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a")
    , @NamedQuery(name = "Agent.findByIdagent", query = "SELECT a FROM Agent a WHERE a.idagent = :idagent")
    , @NamedQuery(name = "Agent.findByMatricule", query = "SELECT a FROM Agent a WHERE a.matricule = :matricule")
    , @NamedQuery(name = "Agent.findByNom", query = "SELECT a FROM Agent a WHERE a.nom = :nom")
    , @NamedQuery(name = "Agent.findByPrenom", query = "SELECT a FROM Agent a WHERE a.prenom = :prenom")
    , @NamedQuery(name = "Agent.findBySexe", query = "SELECT a FROM Agent a WHERE a.sexe = :sexe")
    , @NamedQuery(name = "Agent.findByDatenaissance", query = "SELECT a FROM Agent a WHERE a.datenaissance = :datenaissance")
    , @NamedQuery(name = "Agent.findByTelagent", query = "SELECT a FROM Agent a WHERE a.telagent = :telagent")
    , @NamedQuery(name = "Agent.findByCreele", query = "SELECT a FROM Agent a WHERE a.creele = :creele")
    , @NamedQuery(name = "Agent.findByCreepar", query = "SELECT a FROM Agent a WHERE a.creepar = :creepar")
    , @NamedQuery(name = "Agent.findByModifierle", query = "SELECT a FROM Agent a WHERE a.modifierle = :modifierle")
    , @NamedQuery(name = "Agent.findByModifierpar", query = "SELECT a FROM Agent a WHERE a.modifierpar = :modifierpar")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAGENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agent_seq")
    @SequenceGenerator(
            name = "agent_seq",
            sequenceName = "agent_idagent_seq",
            allocationSize = 1
    )
    private BigDecimal idagent;
    @Size(max = 30)
    @Column(name = "MATRICULE")
    private String matricule;
    @Size(max = 15)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 40)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 8)
    @Column(name = "SEXE")
    private String sexe;
    @Column(name = "DATENAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenaissance;
    @Size(max = 15)
    @Column(name = "TELAGENT")
    private String telagent;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Collection<Agentcat> agentcatCollection;
    @JoinColumn(name = "CODESERVICE", referencedColumnName = "CODESERVICE")
    //responsable
    @ManyToOne(optional =true)
    private Service service;
    @JoinColumn(name = "CODESTRUCTURE", referencedColumnName = "CODESTRUCTURE")
    //rsponsable
    @ManyToOne(optional =true)
    private Structure codestructure;
    @OneToMany(mappedBy = "idagent")
    private Collection<Sortie> sortieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagent")
    private Collection<Service> serviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Collection<Affectationutilisateur> affectationutilisateurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagent")
    private Collection<Structure> structureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent")
    private Collection<Occupation> occupationCollection;

    public Agent() {
    }

    public Agent(BigDecimal idagent) {
        this.idagent = idagent;
    }

    public BigDecimal getIdagent() {
        return idagent;
    }

    public void setIdagent(BigDecimal idagent) {
        this.idagent = idagent;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getTelagent() {
        return telagent;
    }

    public void setTelagent(String telagent) {
        this.telagent = telagent;
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

    public Collection<Agentcat> getAgentcatCollection() {
        return agentcatCollection;
    }

    public void setAgentcatCollection(Collection<Agentcat> agentcatCollection) {
        this.agentcatCollection = agentcatCollection;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Structure getCodestructure() {
        return codestructure;
    }

    public void setCodestructure(Structure codestructure) {
        this.codestructure = codestructure;
    }

    public Collection<Sortie> getSortieCollection() {
        return sortieCollection;
    }

    public void setSortieCollection(Collection<Sortie> sortieCollection) {
        this.sortieCollection = sortieCollection;
    }

    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    public Collection<Affectationutilisateur> getAffectationutilisateurCollection() {
        return affectationutilisateurCollection;
    }

    public void setAffectationutilisateurCollection(Collection<Affectationutilisateur> affectationutilisateurCollection) {
        this.affectationutilisateurCollection = affectationutilisateurCollection;
    }

    public Collection<Structure> getStructureCollection() {
        return structureCollection;
    }

    public void setStructureCollection(Collection<Structure> structureCollection) {
        this.structureCollection = structureCollection;
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
        hash += (idagent != null ? idagent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.idagent == null && other.idagent != null) || (this.idagent != null && !this.idagent.equals(other.idagent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + matricule + " "+nom+" "+prenom;
    }

}
