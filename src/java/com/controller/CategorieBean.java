/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Affectationutilisateur;
import com.entities.Agent;
import com.entities.Agentcat;
import com.entities.Categorie;
import com.entities.Typeretour;
import com.models.AffectationutilisateurFacade;
import com.models.AgentcatFacade;
import com.models.CategorieFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ZORE
 */
@Named(value = "categorieBean")
@SessionScoped
public class CategorieBean extends AbstractBean implements Serializable {
    private Categorie categorie=new Categorie();
    @Inject
    private CategorieFacade facade;
    @Inject
    private AgentcatFacade affectationfacade;
    private Agentcat affectation=new Agentcat();
    private Categorie selectedCategorie;
    private List<Categorie>  liste=null;
    public CategorieBean() {
    }
    
    @PostConstruct
    public void init(){
        liste=facade.findAll();
    }
    public void create() {
        try {
            categorie.setCreele(UtilisateurBean.date());
            categorie.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(categorie);
            displayInfoMessage("categorie inserée ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("categorie non inserée");
        } finally {
            categorie = new Categorie();
            init();
        }

    }
    
    public void createaffectation(Agent agent) {
        try {affectation.setCategorie(categorie);
        affectation.setAgent(agent);
        affectation.setCreele(UtilisateurBean.date());
        affectation.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            affectationfacade.create(affectation);
            displayInfoMessage("reussie ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("echec");
        } finally {
            affectation = new Agentcat();
        }

    }

    public void delete(Categorie sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Categorie sr = ((Categorie) event.getObject());
        try {
            sr.setModifierle(UtilisateurBean.date());
            sr.setModifierpar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("categorie éditée " + sr.getIdcategorie());
        } catch (Exception e) {
            displayErrorMessage("categorie non éditée " + sr.getIdcategorie());
        }
        init();
    }
    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public void setSelectedCategorie(Categorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Categorie getSelectedCategorie() {
        return selectedCategorie;
    }

    public List<Categorie> getListe() {
        return liste;
    }

}
