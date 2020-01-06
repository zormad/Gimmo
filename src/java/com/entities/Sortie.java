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

/**
 *
 * @author ZORE
 */
@Entity
@Table(name = "SORTIE", catalog = "", schema = "C##TEST")
@NamedQueries({
    @NamedQuery(name = "Sortie.findAll", query = "SELECT s FROM Sortie s")
    , @NamedQuery(name = "Sortie.findByIdsortie", query = "SELECT s FROM Sortie s WHERE s.idsortie = :idsortie")
    , @NamedQuery(name = "Sortie.findBytypesortie", query = "SELECT s FROM Sortie s WHERE s.idtypesortie.idtypesortie = :typesortie")
     , @NamedQuery(name = "Sortie.findBytypesortieValider", query = "SELECT s FROM Sortie s WHERE s.idtypesortie.idtypesortie = :typesortie AND s.valider= :valider")
   , @NamedQuery(name = "Sortie.findByLibellesortie", query = "SELECT s FROM Sortie s WHERE s.libellesortie = :libellesortie")
    , @NamedQuery(name = "Sortie.findByDescriptionsortie", query = "SELECT s FROM Sortie s WHERE s.descriptionsortie = :descriptionsortie")
    , @NamedQuery(name = "Sortie.findByDatesortie", query = "SELECT s FROM Sortie s WHERE s.datesortie = :datesortie")
    , @NamedQuery(name = "Sortie.findByDateprevuretour", query = "SELECT s FROM Sortie s WHERE s.dateprevuretour = :dateprevuretour")
    , @NamedQuery(name = "Sortie.findByCreele", query = "SELECT s FROM Sortie s WHERE s.creele = :creele")
    , @NamedQuery(name = "Sortie.delete", query = "DELETE FROM Sortie s WHERE s.idsortie = :id")
    , @NamedQuery(name = "Sortie.findByCreepar", query = "SELECT s FROM Sortie s WHERE s.creepar = :creepar")
    , @NamedQuery(name = "Sortie.findByModifiele", query = "SELECT s FROM Sortie s WHERE s.modifiele = :modifiele")
    , @NamedQuery(name = "Sortie.findByModifiepar", query = "SELECT s FROM Sortie s WHERE s.modifiepar = :modifiepar")})
public class Sortie implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSORTIE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sortie_seq")
    @SequenceGenerator(
            name = "sortie_seq",
            sequenceName = "sortie_idsortie_seq",
            allocationSize = 20
    )
    private BigDecimal idsortie;
    @Size(max = 100)
    @Column(name = "LIBELLESORTIE")
    private String libellesortie;
    @Size(max = 45)
    @Column(name = "DESCRIPTIONSORTIE")
    private String descriptionsortie;
    @Column(name = "DATESORTIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesortie;
    @Column(name = "DATERETOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretour;
    @Column(name = "DATEPREVURETOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateprevuretour;
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
    @Column(name = "VALIDER")
    private String valider = "false";
    @JoinColumn(name = "IDAGENT", referencedColumnName = "IDAGENT")
    @ManyToOne(optional = true)
    private Agent idagent;
    @JoinColumn(name = "IDPRESTATAIRE", referencedColumnName = "IDPRESTATAIRE")
    @ManyToOne
    private Prestataire idprestataire;
    @JoinColumn(name = "IDTYPESORTIE", referencedColumnName = "IDTYPESORTIE")
    @ManyToOne(optional = true)
    private Typedesortie idtypesortie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sortie")
    private Collection<Equipementsortis> equipementsortisCollection;

    public Sortie() {
    }

    public Sortie(BigDecimal idsortie) {
        this.idsortie = idsortie;
    }

    public BigDecimal getIdsortie() {
        return idsortie;
    }

    public void setIdsortie(BigDecimal idsortie) {
        this.idsortie = idsortie;
    }

    public String getLibellesortie() {
        return libellesortie;
    }

    public void setLibellesortie(String libellesortie) {
        this.libellesortie = libellesortie;
    }

    public String getDescriptionsortie() {
        return descriptionsortie;
    }

    public void setDescriptionsortie(String descriptionsortie) {
        this.descriptionsortie = descriptionsortie;
    }

    public Date getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }

    public Date getDateprevuretour() {
        return dateprevuretour;
    }

    public void setDateprevuretour(Date dateprevuretour) {
        this.dateprevuretour = dateprevuretour;
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

    public Agent getIdagent() {
        return idagent;
    }

    public void setIdagent(Agent idagent) {
        this.idagent = idagent;
    }

    public Prestataire getIdprestataire() {
        return idprestataire;
    }

    public void setIdprestataire(Prestataire idprestataire) {
        this.idprestataire = idprestataire;
    }

    public Typedesortie getIdtypesortie() {
        return idtypesortie;
    }

    public void setIdtypesortie(Typedesortie idtypesortie) {
        this.idtypesortie = idtypesortie;
    }

    public Collection<Equipementsortis> getEquipementsortisCollection() {
        return equipementsortisCollection;
    }

    public void setEquipementsortisCollection(Collection<Equipementsortis> equipementsortisCollection) {
        this.equipementsortisCollection = equipementsortisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsortie != null ? idsortie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sortie)) {
            return false;
        }
        Sortie other = (Sortie) object;
        if ((this.idsortie == null && other.idsortie != null) || (this.idsortie != null && !this.idsortie.equals(other.idsortie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Sortie[ idsortie=" + idsortie + " ]";
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

}
