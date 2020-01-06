/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Famille;
import com.entities.Groupe;
import com.models.FamilleFacade;
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
@Named(value = "familleBean")
@SessionScoped
public class FamilleBean extends AbstractBean implements Serializable {
     @Inject
    private FamilleFacade familleFacade;
     private Famille famille = new Famille();
     private Groupe groupe=new Groupe();
     private List<Famille> listeFamille = null;
     private Famille selectedFamille;
    public FamilleBean() {
    }
    @PostConstruct
    public void init() {
        listeFamille = familleFacade.findAll();
    }
       
//Famille

    public void createFamille() {
        famille.setIdgroupe(groupe);
        try {
            famille.setCreele(UtilisateurBean.date());
            famille.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            familleFacade.create(famille);
            displayInfoMessage("famille inséré avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de l'insertion");
        } finally {

            famille = new Famille();
            init();
        }
    }

    public void deleteFamille(Famille fm) {
        try {
            familleFacade.delete(fm.getCodefamille());
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateFamille(RowEditEvent event) {
        Famille fm = (Famille) event.getObject();
        fm.setModifiele(UtilisateurBean.date());
        fm.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            familleFacade.edit((Famille) event.getObject());
            displayInfoMessage("famille éditée  " + fm.getCodefamille());
        } catch (Exception e) {
            displayErrorMessage("famille non éditée  " + fm.getCodefamille());
        }
        init();
    }

    public void cancelledFamille() {
        displayInfoMessage("vous avez annulez");
    }

    public Famille getFamille() {
        return famille;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public List<Famille> getListeFamille() {
        return listeFamille;
    }

    public Famille getSelectedFamille() {
        return selectedFamille;
    }

    public void setSelectedFamille(Famille selectedFamille) {
        this.selectedFamille = selectedFamille;
    }
public void changeGroupe(){
    groupe.setFamilleCollection(familleFacade.changeGroupe(groupe));
}

}
