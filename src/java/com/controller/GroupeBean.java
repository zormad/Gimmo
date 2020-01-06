/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Groupe;
import com.models.GroupeFacade;
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
@Named(value = "groupeBean")
@SessionScoped
public class GroupeBean extends AbstractBean implements Serializable {
    @Inject
    private GroupeFacade groupeFacade;
    private Groupe groupe = new Groupe();
    private List<Groupe> listeGroupe = null;
    private Groupe selectedGroupe;
    public GroupeBean() {
    }
     @PostConstruct
    public void init() {
        listeGroupe = groupeFacade.findAll();
    }
    
     //Groupe
    public void createGroupe() {
        try {
            groupe.setCreele(UtilisateurBean.date());
            groupe.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            groupeFacade.create(groupe);
            displayInfoMessage("Groupe inséré");
        } catch (Exception e) {
            displayErrorMessage("Groupe non inséré " + groupe.getIdgroupe());
        }
        groupe = new Groupe();
        init();
    }

    public void deleteGroupe(Groupe gp) {
        try {
            groupeFacade.remove(gp);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateGroupe(RowEditEvent event) {
        Groupe gp = (Groupe) event.getObject();
        gp.setModifiele(UtilisateurBean.date());
        gp.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            groupeFacade.edit(gp);
            displayInfoMessage("groupe édité  " + gp.getIdgroupe());
        } catch (Exception e) {
            displayErrorMessage("groupe non édité  " + gp.getIdgroupe());
        }
        groupe = new Groupe();
        init();
    }

    public void cancelledGroupe() {
        displayInfoMessage("vous avez annulez");
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public List<Groupe> getListeGroupe() {
        return listeGroupe;
    }

    public Groupe getSelectedGroupe() {
        return selectedGroupe;
    }

    public void setSelectedGroupe(Groupe selectedGroupe) {
        this.selectedGroupe = selectedGroupe;
    }
    
    
}
