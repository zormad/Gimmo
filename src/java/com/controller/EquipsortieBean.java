/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Equipement;
import com.entities.Equipementsortis;
import com.entities.Sortie;
import com.models.EquipementsortisFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author ZORE
 */
@Named(value = "equipsortieBean")
@SessionScoped
public class EquipsortieBean extends AbstractBean implements Serializable {

    private Equipement equipement = new Equipement();
    private Sortie sortie = new Sortie();
    private Equipementsortis e = new Equipementsortis();
    @Inject
    private EquipementsortisFacade facade;

    public EquipsortieBean() {
    }

    @PostConstruct
    public void init() {

    }

    public void create() {
        try {
            e.setCreele(UtilisateurBean.date());
            e.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            e.setSortie(sortie);
            e.setEquipement(equipement);
                    
            facade.create(e);
            displayInfoMessage("Equipement sorti avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de l'opération demandée");
        } finally {

        }
    }
}
