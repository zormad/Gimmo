/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Sourcedefinancement;
import com.models.SourcedefinancementFacade;
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
@Named(value = "sourcedefinancementBean")
@SessionScoped
public class SourcedefinancementBean extends AbstractBean implements Serializable {

    private Sourcedefinancement source = new Sourcedefinancement();
    @Inject
    private SourcedefinancementFacade facade;
    private Sourcedefinancement selectedSource;
    private List<Sourcedefinancement> liste = null;

    public SourcedefinancementBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void create() {
        try {
            source.setCreele(UtilisateurBean.date());
            source.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(source);
            source = new Sourcedefinancement();
            displayInfoMessage("source inserée");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("source non inserée");
        }

        init();
    }

    public void delete(Sourcedefinancement sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Sourcedefinancement sr = ((Sourcedefinancement) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("source éditée " + sr.getIdsource());
        } catch (Exception e) {
            displayErrorMessage("source non éditée " +sr.getIdsource());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Sourcedefinancement getSource() {
        return source;
    }

    public Sourcedefinancement getSelectedSource() {
        return selectedSource;
    }

    public List<Sourcedefinancement> getListe() {
        return liste;
    }

    public void setSelectedSource(Sourcedefinancement selectedSource) {
        this.selectedSource = selectedSource;
    }
    
    
}
