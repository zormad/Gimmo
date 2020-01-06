/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Prestataire;
import com.models.PrestataireFacade;
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
@Named(value = "prestataireBean")
@SessionScoped
public class PrestataireBean extends AbstractBean implements Serializable {

    private Prestataire prestataire = new Prestataire();
    @Inject
    private PrestataireFacade facade;
    private Prestataire selectedPrestataire;

    private List<Prestataire> liste = null;

    public PrestataireBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void create() {
        try {
            prestataire.setCreele(UtilisateurBean.date());
            prestataire.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(prestataire);
            prestataire = new Prestataire();
            displayInfoMessage("prestataire inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("prestataire non inseré");
        } finally {
            prestataire = new Prestataire();
            init();
        }

    }

    public void delete(Prestataire sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Prestataire sr = ((Prestataire) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("prestataire édité " + sr.getIdprestataire());
        } catch (Exception e) {
            displayErrorMessage("prestataire non éditée " + sr.getIdprestataire());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }

    public Prestataire getSelectedPrestataire() {
        return selectedPrestataire;
    }

    public List<Prestataire> getListe() {
        return liste;
    }

    public void setSelectedPrestataire(Prestataire selectedPrestataire) {
        this.selectedPrestataire = selectedPrestataire;
    }

}
