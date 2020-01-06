/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Agent;
import com.entities.Equipement;
import com.entities.Equipementreparation;
import com.entities.Equipementsortis;
import com.entities.Prestataire;
import com.entities.Sortie;
import com.entities.Typedesortie;
import com.entities.Typeintervention;
import com.models.EquipementFacade;
import com.models.EquipementreparationFacade;
import com.models.EquipementsortisFacade;
import com.models.SortieFacade;
import com.models.TypedesortieFacade;
import com.models.TypeinterventionFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;
import java.sql.Connection;
import com.connexion.Singleconnexion;

/**
 *
 * @author ZORE
 */
@Named(value = "sortieBean")
@SessionScoped
public class SortieBean extends AbstractBean implements Serializable {

    private Typedesortie type = new Typedesortie();
    private Sortie sortie = new Sortie();
    private Agent agent = new Agent();
    private Prestataire prestataire = new Prestataire();
    @Inject
    private TypedesortieFacade typeFacade;
    @Inject
    private SortieFacade facade;
    @Inject
    private EquipementFacade equipF;
    @Inject
    private EquipementsortisFacade equipementsortisFacade;

    private Typedesortie selectedType;
    private Sortie selectedSortie = null;

    List<Typedesortie> listetype = null;
    List<Sortie> liste = null;
    List<Sortie> listeReparation = null;
    List<Sortie> listeMission = null;
    List<Sortie> filteredsorties = null;
    private Collection<Equipementsortis> listeEquipsortis = new ArrayList<>();
    private Equipementsortis equipementsortis = new Equipementsortis();

    private List<Equipement> listEquipall = null;//equipementFacade.findAll();
    private List<Equipement> target = null;
    private Equipement equipement = new Equipement();
    private DualListModel<Equipement> equipements;
    private List<Equipement> listeEquipements = null;
    private Equipementsortis selectEquipementSorti;
    //REPARATION
    private Equipementreparation reparation = new Equipementreparation();
    private Typeintervention typeIntervention = new Typeintervention();
    @Inject
    private EquipementreparationFacade facadeReparation;
    @Inject
    private TypeinterventionFacade typefacade;
    private List<Typeintervention> listeinterventions = null;
    private Typeintervention selectedIntervention;
    private Boolean repareB = false;
    private Boolean incorporeB = false;

    public SortieBean() {
    }

    @PostConstruct
    public void init() {
        listeMission = facade.missionValider();
        listeReparation = facade.reparationValider();
        listetype = typeFacade.findAll();
        if (type != null) {
            liste = facade.typSorties(type);
        } else {
            liste = null;
        }
        listEquipall = equipF.listeAll();
        target = new ArrayList<Equipement>();
        equipements = new DualListModel<>(listEquipall, target);
        if (selectedSortie != null) {
            setCollection();
        }
//reparation
        listeinterventions = typefacade.findAll();
    }
//methods for reparation

    public void afterSelectReparation() {
        setCollection();
        BigDecimal big = equipementsortisFacade.getEquipementReparation(selectEquipementSorti);
        if (big == null) {
            reparation = new Equipementreparation();
        } else {
            reparation = facadeReparation.getEquipementreparation(big);
        }
        if (reparation.getIdreparation() != null) {
            if (reparation.getRepare().equals("true")) {
                repareB = true;
            } else {
                repareB = false;
            }
            if (reparation.getIncorpore().equals("true")) {
                incorporeB = true;
            } else {
                incorporeB = false;
            }
            typeIntervention = reparation.getCodetypeint();
        }
    }

    public void resetSelectedEquipsorti() {
        selectEquipementSorti = new Equipementsortis();
    }

    public void createReparation() {
        reparation.setCodetypeint(typeIntervention);
        reparation.setCreele(UtilisateurBean.date());
        reparation.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        reparation.setDateretour(UtilisateurBean.date());
        reparation.setEquipementsortis(selectEquipementSorti);
        if (repareB == true) {
            reparation.setRepare("true");
        } else {
            reparation.setRepare("false");
        }
        if (incorporeB == true) {
            reparation.setIncorpore("true");
        } else {
            reparation.setIncorpore("false");
        }
        try {
            facadeReparation.create(reparation);
            equipementsortisFacade.setReparation(reparation, selectEquipementSorti);
            displayInfoMessage("réparation effectué avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur equipement non reparé");
        }
    }

    public void updateReparation() {
        reparation.setCodetypeint(typeIntervention);
        reparation.setModifiele(UtilisateurBean.date());
        reparation.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        if (repareB == true) {
            reparation.setRepare("true");
        } else {
            reparation.setRepare("false");
        }
        if (incorporeB == true) {
            reparation.setIncorpore("true");
        } else {
            reparation.setIncorpore("false");
        }
        try {
            facadeReparation.edit(reparation);
            displayInfoMessage("réparation modifiée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur reparation non modifiée");
        }
    }
//print pdf retour de mission

    public void printPdfRetourmission() throws JRException, IOException {
        String filename = "retourmission.pdf";
        String jasperPath = "/pages/admin/sorties/retourmission_1.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("idsortie", selectedSortie.getIdsortie());
        parameters.put("libellesortie", selectedSortie.getLibellesortie());
        parameters.put("nomagent", selectedSortie.getIdagent().getNom() + " " + selectedSortie.getIdagent().getPrenom());
//        List<?> l=new ArrayList();
//        l=equipementsortisFacade.liste(selectedSortie);
        //  PDF(parameters, jasperPath, liste, filename);
        Connection conn = Singleconnexion.getConnecter();
        String title = "sortiemission";
        String chemin = "/pages/admin/sorties/";
        String sql = "select e.coutacqui, a.designation, m.nommarque, et.libelleetat, e.idequip from equipementsortis es inner join equipement e on e.idequip = es.idequip "
                + "inner join sortie s on s.idsortie = es.idsortie "
                + "inner join article a on a.codearticle = e.codearticle "
                + "inner join marque m on m.idmarque = e.idmarque "
                + "inner join etat et on et.idetat = e.idetat where s.idsortie = '" + selectedSortie.getIdsortie() + "'";
        //PDF2(parameters, jasperPath, sql, chemin, filename, conn);
        report(parameters, jasperPath, sql, chemin, title, conn);
    }

    public void printPdfmaintenance() throws JRException, IOException {
        String jasperPath = "/pages/admin/sorties/sortiemaitenance.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("idsortie", selectedSortie.getIdsortie());
        parameters.put("libellesortie", selectedSortie.getLibellesortie());
        parameters.put("libelleprestataire", selectedSortie.getIdprestataire().getLibelleprestataire());
        Connection conn = Singleconnexion.getConnecter();
        String title = "sortiemaintenance";
        String chemin = "/pages/admin/sorties/";
        String sql = "select e.coutacqui, a.designation, m.nommarque, et.libelleetat, e.idequip from equipementsortis es inner join equipement e on e.idequip = es.idequip "
                + "inner join sortie s on s.idsortie = es.idsortie "
                + "inner join article a on a.codearticle = e.codearticle "
                + "inner join marque m on m.idmarque = e.idmarque "
                + "inner join etat et on et.idetat = e.idetat where s.idsortie = '" + selectedSortie.getIdsortie() + "'";
        report(parameters, jasperPath, sql, chemin, title, conn);
    }

    public void createTypeIntervention() {
        typeIntervention.setCreele(UtilisateurBean.date());
        typeIntervention.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            typefacade.create(typeIntervention);
            displayInfoMessage("type crée avec succès");
        } catch (Exception e) {
            displayErrorMessage("type non crée");
        } finally {
            typeIntervention = new Typeintervention();
            init();
        }
    }

    public void deleteTypeIntervention(Typeintervention t) {
        try {
            typefacade.remove(t);
            displayInfoMessage("suppression effectuée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateTypeIntervention(RowEditEvent event) {
        try {
            typefacade.edit((Typeintervention) event.getObject());
            displayInfoMessage("type édité  " + ((Typeintervention) event.getObject()).getCodetypeint());
        } catch (Exception e) {
            displayErrorMessage("type non édité  " + ((Typeintervention) event.getObject()).getCodetypeint());
        }
        init();
    }

    public void setCollection() {
        listeEquipements = equipementsortisFacade.equipementsortis(selectedSortie);
    }

    public void afterchoose() {
        selectedSortie = new Sortie();
        init();
    }

    public void editEquip(Equipementsortis e) {
        try {
            equipF.edit(e.getEquipement());
        } catch (Exception e1) {
        }
    }

    public void retourner() {
        int tot = 0;
        ArrayList<Equipementsortis> arrayList = new ArrayList<>();
        arrayList.addAll(selectedSortie.getEquipementsortisCollection());
        for (int i = 0; i < arrayList.size(); i++) {
            equipementsortis = new Equipementsortis();
            equipementsortis = arrayList.get(i);
            equipement = new Equipement();
            equipement = equipF.getEquipement(arrayList.get(i).getEquipement());
            equipement.setStatut("actif");

            try {
                equipF.updateStatut(equipement);
                tot++;
            } catch (Exception e) {
            }

        }
    }

    public void validerReparation() {

        selectedSortie.setDateretour(UtilisateurBean.date());
        try {
            facade.edit(selectedSortie);
            displayInfoMessage("sortie reparation validée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de l'opération souhaitée");
        }
        init();
    }

    public void resetSelectedSortie() {
        selectedSortie = new Sortie();
    }

    public void addEquip() throws Throwable {
        int tot = 0;
        for (int i = 0; i < equipements.getTarget().size(); i++) {
            equipementsortis = new Equipementsortis();
            equipement = new Equipement();
            equipement = equipF.getEquipement(equipements.getTarget().get(i));
            equipement.setStatut("inactif");
            equipementsortis.setCreele(UtilisateurBean.date());
            equipementsortis.setEquipement(equipement);
            equipementsortis.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            equipementsortis.setSortie(selectedSortie);
            try {
                equipementsortisFacade.create(equipementsortis);
                equipF.updateStatut(equipement);
                listEquipall.remove(equipement);
                tot++;
            } catch (Exception e) {
            }

        }
        if (tot == equipements.getTarget().size() && tot > 0) {
            displayInfoMessage("Enregistement reussi");
            equipements.setTarget(new ArrayList<>());
        } else {
            displayErrorMessage("Enregistrement non reussi");
        }
        init();
//        selectedSortie.setEquipementsortisCollection(listeEquipsortis);
//        displayInfoMessage("équipement ajouté avec succès");
    }
    // type de sortie

    public void createType() {
        try {
            type.setCreele(UtilisateurBean.date());
            type.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typeFacade.create(type);
            displayInfoMessage("type de sortie inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("type de sortie non inseré");
        } finally {
            type = new Typedesortie();
            init();
        }

    }

    public void deleteType(Typedesortie sr) {
        try {
            typeFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateType(RowEditEvent event) {
        Typedesortie sr = ((Typedesortie) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typeFacade.edit(sr);
            displayInfoMessage("type de sortie édité " + sr.getIdtypesortie());
        } catch (Exception e) {
            displayErrorMessage("type de sortie non éditée " + sr.getIdtypesortie());
        }
        init();
    }
//SORTIE

    public void create() {
        try {
            sortie.setCreele(UtilisateurBean.date());
            sortie.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            sortie.setValider("false");
            if (agent.getIdagent() != null) {
                sortie.setIdagent(agent);
            }
            if (prestataire.getIdprestataire() != null) {
                sortie.setIdprestataire(prestataire);
            }
            sortie.setIdtypesortie(type);
            facade.create(sortie);
            displayInfoMessage("sortie inserée");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("sortie non inserée");
        } finally {
            agent = new Agent();
            prestataire = new Prestataire();
            sortie = new Sortie();
            init();
        }
    }

    public void delete(Sortie sr) {
        try {
            facade.delete(sr.getIdsortie());
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateValider() {
        selectedSortie.setValider("true");
        try {

            if (facade.updateValider(selectedSortie) > 0) {
                displayInfoMessage("sortie validée avec succès");
            } else {
                displayErrorMessage("erreur lors de la validation");
            }
        } catch (Exception e) {
            displayErrorMessage("erreur lors de la validation");

        }
        init();
    }

    public void update(RowEditEvent event) {
        Sortie sr = ((Sortie) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("sortie éditée " + sr.getIdsortie());
        } catch (Exception e) {
            displayErrorMessage("sortie non éditée " + sr.getIdsortie());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public void cancelledType() {
        displayInfoMessage("vous avez annulez");
    }

    public Typedesortie getType() {
        return type;
    }

    public Typedesortie getSelectedType() {
        return selectedType;
    }

    public List<Typedesortie> getListetype() {
        return listetype;
    }

    public void setSelectedType(Typedesortie selectedType) {
        this.selectedType = selectedType;
    }

    public Sortie getSortie() {
        return sortie;
    }

    public Sortie getSelectedSortie() {
        return selectedSortie;
    }

    public List<Sortie> getListe() {
        return liste;
    }

    public void setSelectedSortie(Sortie selectedSortie) {
        this.selectedSortie = selectedSortie;
    }

    public Agent getAgent() {
        return agent;
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }

    public TypedesortieFacade getTypeFacade() {
        return typeFacade;
    }

    public List<Sortie> getFilteredsorties() {
        return filteredsorties;
    }

    public void setFilteredsorties(List<Sortie> filteredsorties) {
        this.filteredsorties = filteredsorties;
    }

    public Collection<Equipementsortis> getListeEquipsortis() {
        return listeEquipsortis;
    }

    public void setListeEquipsortis(List<Equipementsortis> listeEquipsortis) {
        this.listeEquipsortis = listeEquipsortis;
    }

    public Equipementsortis getEquipementsortis() {
        return equipementsortis;
    }

    public void setEquipementsortis(Equipementsortis equipementsortis) {
        this.equipementsortis = equipementsortis;
    }

    public List<Equipement> getListEquipall() {
        return listEquipall;
    }

    public void setListEquipall(List<Equipement> listEquipall) {
        this.listEquipall = listEquipall;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public List<Equipement> getTarget() {
        return target;
    }

    public void setTarget(List<Equipement> target) {
        this.target = target;
    }

    public DualListModel<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(DualListModel<Equipement> equipements) {
        this.equipements = equipements;
    }

    public List<Equipement> getListeEquipements() {
        return listeEquipements;
    }

    public void setListeEquipements(List<Equipement> listeEquipements) {
        this.listeEquipements = listeEquipements;
    }

    public List<Sortie> getListeReparation() {
        return listeReparation;
    }

    public void setListeReparation(List<Sortie> listeReparation) {
        this.listeReparation = listeReparation;
    }

    public List<Sortie> getListeMission() {
        return listeMission;
    }

    public void setListeMission(List<Sortie> listeMission) {
        this.listeMission = listeMission;
    }

    public Equipementsortis getSelectEquipementSorti() {
        return selectEquipementSorti;
    }

    public void setSelectEquipementSorti(Equipementsortis selectEquipementSorti) {
        this.selectEquipementSorti = selectEquipementSorti;
    }

    public Equipementreparation getReparation() {
        return reparation;
    }

    public void setReparation(Equipementreparation reparation) {
        this.reparation = reparation;
    }
//reparation getters and setters

    public Typeintervention getTypeIntervention() {
        return typeIntervention;
    }

    public void setTypeIntervention(Typeintervention typeIntervention) {
        this.typeIntervention = typeIntervention;
    }

    public List<Typeintervention> getListeinterventions() {
        return listeinterventions;
    }

    public void setListeinterventions(List<Typeintervention> listeinterventions) {
        this.listeinterventions = listeinterventions;
    }

    public Typeintervention getSelectedIntervention() {
        return selectedIntervention;
    }

    public void setSelectedIntervention(Typeintervention selectedIntervention) {
        this.selectedIntervention = selectedIntervention;
    }

    public Boolean getRepareB() {
        return repareB;
    }

    public void setRepareB(Boolean repareB) {
        this.repareB = repareB;
    }

    public Boolean getIncorporeB() {
        return incorporeB;
    }

    public void setIncorporeB(Boolean incorporeB) {
        this.incorporeB = incorporeB;
    }

}
