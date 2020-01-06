/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Annee;
import com.models.AnneeFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author ZORE
 */
@Named(value = "anneeBean")
@SessionScoped
public class AnneeBean extends AbstractBean implements Serializable {

    private Annee annee = new Annee();
    @Inject
    private AnneeFacade facade;
    private List<Annee> listeAnnee = new ArrayList<>();

    public AnneeBean() {
    }

    @PostConstruct
    public void init() {
        listeAnnee = facade.findAll();
    }

    //Ajout
    public void add() {
        try {
            facade.create(annee);
            displayInfoMessage("Année créee avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de la création");
        }
        init();
    }
    //getter and setter

    public Annee getAnnee() {
        return annee;
    }
    
    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
    
    public AnneeFacade getFacade() {
        return facade;
    }
    
    public void setFacade(AnneeFacade facade) {
        this.facade = facade;
    }
    
    public List<Annee> getListeAnnee() {
        return listeAnnee;
    }
    
    public void setListeAnnee(List<Annee> listeAnnee) {
        this.listeAnnee = listeAnnee;
    }
    
}
