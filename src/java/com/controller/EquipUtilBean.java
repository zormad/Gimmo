/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Singleconnexion;
import com.entities.Article;
import com.entities.Bon;
import com.entities.Equipement;
import com.entities.Etat;
import com.entities.Fournisseur;
import com.entities.Magasin;
import com.entities.Marque;
import com.entities.Sourcedefinancement;
import com.entities.Structure;
import com.models.BonFacade;
import com.models.EquipementFacade;
import com.models.EtatFacade;
import com.models.MagasinFacade;
import com.models.MarqueFacade;
import com.models.StructureFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ZORE
 */
@Named(value = "equipUtilBean")
@SessionScoped
public class EquipUtilBean extends AbstractBean implements Serializable {

    private Magasin magasin = new Magasin();
    private Etat etat = new Etat();
    private Fournisseur fournisseur = new Fournisseur();
    private Article article = new Article();
    private Marque marque = new Marque();
    private Sourcedefinancement source = new Sourcedefinancement();
    private Equipement equipement = new Equipement();
    private Bon bon = new Bon();
    private String EntreeMagasin = "aucun";
    //essaie
    private Bon bonessaie = new Bon();

    private Boolean skip;
    private int quantite = 0;

    @Inject
    private MarqueFacade marqueFacade;
    @Inject
    private EtatFacade etatFacade;
    @Inject
    private EquipementFacade facade;
    @Inject
    private BonFacade bonFacade;
    @Inject
    private StructureFacade structureFacade;

    List listeEntree = new ArrayList();
    List<Etat> listeEtat = null;
    List<Marque> listeMarque = null;
    List<Equipement> liste = null;
    List<Bon> listeBon = null;
    List<Bon> listeBonAll = null;
    List listeEquipBon = null;
    private List<Magasin> listeMagasinsP = null;

    private Etat selectedEtat;
    private Marque selectedMarque;
    private Equipement selectedEquipement;

    //supplementaire
    private Structure structure = new Structure();
    @Inject
    private MagasinFacade magasinFacade;

    public EquipUtilBean() {
    }

    @PostConstruct
    public void init() {
        if (bon != null) {
            listeEntree = facade.listeEquipBon(bon);
        } else {
            listeEntree = new ArrayList();
        }
        listeEtat = etatFacade.findAll();
        if (magasin != null) {
            listeBonAll = bonFacade.findByvalider(magasin);
        } else {
            listeBonAll = new ArrayList<>();
        }
        //listeEtat = etatFacade.findAll();
        listeMarque = marqueFacade.findAll();
        liste = facade.findByBon(bon);
        if (magasin != null) {
            listeBon = bonFacade.findByvalider(magasin);
        } else {
            listeBon = new ArrayList<Bon>();
        }
        listeMagasinsP = magasinFacade.MagasinPrincipal();
        //listeEquipBon=facade.listeEquipBon(bon);
    }

    //Bon d'entrée
    public void printPdf() throws JRException, IOException {
        //String filename = "bonEntree";
        String jasperPath = "/pages/admin/equipements/reportBonEntree.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("numBon", bon.getNumbon());
        parameters.put("nommagasin", magasin.getNommagasin());
        parameters.put("nombon", bon.getLibelle());
        Connection conn = Singleconnexion.getConnecter();
        String title = "bonEntree";
        String chemin = "/pages/admin/equipements/";
        String sql = "select a.designation,e.coutacqui,m.nommarque,count(e.idequip) as quantite  from equipement e inner join article a on a.codearticle = e.codearticle inner join "
                + "marque m on m.idmarque = e.idmarque  "
                + "where e.numbon = '"+bon.getNumbon()+"' "
                + "group by a.designation,e.coutacqui,m.nommarque ";
        report(parameters, jasperPath, sql, chemin, title, conn);
    }

    //ETAT
    public void createEtat() {
        try {
            etat.setCreele(UtilisateurBean.date());
            etat.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            etatFacade.create(etat);
            etat = new Etat();
            displayInfoMessage("etat inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("etat non inseré");
        }

        init();
    }

    public void deleteEtat(Etat sr) {
        try {
            etatFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateEtat(RowEditEvent event) {
        Etat sr = ((Etat) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            etatFacade.edit(sr);
            displayInfoMessage("etat édité " + sr.getIdetat());
        } catch (Exception e) {
            displayErrorMessage("etat non éditée " + sr.getIdetat());
        }
        init();
    }

    public void cancelledEtat() {
        displayInfoMessage("vous avez annulez");
    }

    //MARQUE
    public void createMarque() {
        try {
            marque.setCreele(UtilisateurBean.date());
            marque.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            marqueFacade.create(marque);
            marque = new Marque();
            displayInfoMessage("marque inserée");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("marque non inserée");
        }

        init();
    }

    public void deleteMarque(Marque sr) {
        try {
            marqueFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateMarque(RowEditEvent event) {
        Marque sr = ((Marque) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            marqueFacade.edit(sr);
            displayInfoMessage("marque éditée " + sr.getIdmarque());
        } catch (Exception e) {
            displayErrorMessage("marque non éditée " + sr.getIdmarque());
        }
        init();
    }

    public void cancelledMarque() {
        displayInfoMessage("vous avez annulez");
    }

    //Equipement
    public void create() {
        int tot = 0;
        etat.setIdetat("A");
        equipement.setMagasinActuel(bon.getIdcodemagasin());
        equipement.setMagasinEntre(magasin);
        equipement.setMagasinActuel(magasin);
        equipement.setCreele(UtilisateurBean.date());
        equipement.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        equipement.setIdmarque(marque);
        equipement.setBon(bon);
        equipement.setCodearticle(article);
        equipement.setIdetat(etat);
        equipement.setCreele(UtilisateurBean.date());
        equipement.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        equipement.setDateacqui(UtilisateurBean.date());
        Equipement nouveau = new Equipement();
        for (int i = 0; i < quantite; i++) {
            try {
                nouveau = equipement;
                nouveau.setIdequip(null);
                facade.create(nouveau);
                tot++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                nouveau = new Equipement();
                init();
            }
        }
        if (tot != 0 && tot == quantite) {
            displayInfoMessage("equipements inserés");
        } else {
            displayInfoMessage("equipements non  inserés");
        }
    }

    public void delete(Equipement sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Equipement sr = ((Equipement) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("equipement édité " + sr.getIdequip());
        } catch (Exception e) {
            displayErrorMessage("marque non éditée " + sr.getIdequip());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public String onFlowProcess(FlowEvent event) {
        if (this.skip == true) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public void changealues() {//displayErrorMessage("ii"+structure);
        structure = new Structure();
        magasin = new Magasin();
        bon = new Bon();
        init();
        // displayInfoMessage("dd"+magasin);
    }

    public void changealuesstructure() {//displayErrorMessage("ii"+structure);
        structure = structureFacade.findBycodeStructure(structure);
        magasin = structure.getMagasin();
        bon = new Bon();
        init();
        // displayInfoMessage("dd"+magasin);
    }

    public void changealuesmagasin() {//displayErrorMessage("ii"+structure);
        //structure = structureFacade.findBycodeStructure(structure);
        magasin = magasinFacade.getMagasin(magasin);
        bon = new Bon();
        init();
        // displayInfoMessage("dd"+magasin);
    }

//
//    public void changealuesmagasin() {
//        bon = new Bon();
//        // init();
//    }
//    public void changealuesmagasin(){
//        bon=new Bon();
//        init();
//    }
    public Magasin getMagasin() {
        return magasin;
    }

    public Etat getEtat() {
        return etat;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public Article getArticle() {
        return article;
    }

    public Marque getMarque() {
        return marque;
    }

    public Sourcedefinancement getSource() {
        return source;
    }

    public List<Etat> getListeEtat() {
        return listeEtat;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public List<Marque> getListeMarque() {
        return listeMarque;
    }

    public List<Equipement> getListe() {
        return liste;
    }

    public List getListeEquipBon() {
        return listeEquipBon;
    }

    public Etat getSelectedEtat() {
        return selectedEtat;
    }

    public Marque getSelectedMarque() {
        return selectedMarque;
    }

    public Equipement getSelectedEquipement() {
        return selectedEquipement;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Boolean getSkip() {
        return skip;
    }

    public void setSkip(Boolean Skip) {
        this.skip = Skip;
    }

    public void setSelectedEtat(Etat selectedEtat) {
        this.selectedEtat = selectedEtat;
    }

    public void setSelectedMarque(Marque selectedMarque) {
        this.selectedMarque = selectedMarque;
    }

    public void setSelectedEquipement(Equipement selectedEquipement) {
        this.selectedEquipement = selectedEquipement;
    }

    public Bon getBon() {
        return bon;
    }

    public List<Bon> getListeBon() {
        return listeBon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    //Supplementaire
    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    //Bon
    public void createBon() {
        try {
            bon.setIdfournisseur(fournisseur);
            bon.setIdsource(source);
            bon.setIdcodemagasin(magasin);
            bonFacade.create(bon);
            displayInfoMessage("bon crée");
        } catch (Exception e) {
            displayInfoMessage("bon non crée");
        } finally {
            bon = new Bon();
            init();
        }
    }

    public void updateBon() throws JRException, IOException {
        bon.setValider("true");
        try {
            bonFacade.edit(bon);
            displayInfoMessage("Bon " + bon.getLibelle() + " validé avec succès");
            bon = new Bon();
        } catch (Exception e) {
            displayErrorMessage("Bon " + bon.getLibelle() + " non validé");
        } finally {
            bon=new Bon();
            liste=new ArrayList<>();
            init();
        }
    }

    public void updatebon() {
        bon = bonFacade.findByid(bon);
        init();
    }

    public List<Bon> getListeBonAll() {
        return listeBonAll;
    }

    public void setListeBonAll(List<Bon> listeBonAll) {
        this.listeBonAll = listeBonAll;
    }

    public List getListeEntree() {
        return listeEntree;
    }

    public void setListeEntree(List listeEntree) {
        this.listeEntree = listeEntree;
    }

    public String getEntreeMagasin() {
        return EntreeMagasin;
    }

    public void setEntreeMagasin(String EntreeMagasin) {
        this.EntreeMagasin = EntreeMagasin;
    }

    public List<Magasin> getListeMagasinsP() {
        return listeMagasinsP;
    }

    public void setListeMagasinsP(List<Magasin> listeMagasinsP) {
        this.listeMagasinsP = listeMagasinsP;
    }

}
