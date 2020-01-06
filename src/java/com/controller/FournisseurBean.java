/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Fournisseur;
import com.models.FournisseurFacade;
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
@Named(value = "fournisseurBean")
@SessionScoped
public class FournisseurBean extends AbstractBean implements Serializable {

    private Fournisseur fournisseur = new Fournisseur();
    private Fournisseur selectedFournisseur;
    @Inject
    private FournisseurFacade facade;
    private List<Fournisseur> liste = null;

    public FournisseurBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void create() {
        try {
            fournisseur.setCreele(UtilisateurBean.date());
            fournisseur.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(fournisseur);
            fournisseur = new Fournisseur();
            displayInfoMessage("fournisseur inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("fournisseur non inseré");
        } finally {
            init();
            fournisseur = new Fournisseur();
        }

    }

    public void delete(Fournisseur sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Fournisseur sr = ((Fournisseur) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("fournisseur édité " + sr.getIdfournisseur());
        } catch (Exception e) {
            displayErrorMessage("source non éditée " + sr.getIdfournisseur());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public Fournisseur getSelectedFournisseur() {
        return selectedFournisseur;
    }

    public List<Fournisseur> getListe() {
        return liste;
    }

    public void setSelectedFournisseur(Fournisseur selectedFournisseur) {
        this.selectedFournisseur = selectedFournisseur;
    }

}
