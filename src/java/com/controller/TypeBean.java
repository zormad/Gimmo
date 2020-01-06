/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Famille;
import com.entities.Type;
import com.models.TypeFacade;
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
@Named(value = "typeBean")
@SessionScoped
public class TypeBean extends AbstractBean implements Serializable {
    @Inject
    private TypeFacade typeFacade;
    private Type type = new Type();
      private List<Type> listeType = null;
      private Type selectedType;
      private Famille famille=new Famille();
    public TypeBean() {
    }
    @PostConstruct
    public void init() {
        listeType = typeFacade.findAll();
    }
    //type
    public void createType() {
        type.setCodefamille(famille);
        try {
            type.setCreele(UtilisateurBean.date());
            type.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typeFacade.create(type);
            type = new Type();
            displayInfoMessage("type inséré avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de l'insertion");
        }
        init();
    }

    public void deleteType(Type tp) {
        try {
            typeFacade.delete(tp.getCodetype());
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateType(RowEditEvent event) {
        Type tp = (Type) event.getObject();
        tp.setModifiele(UtilisateurBean.date());
        tp.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            typeFacade.edit((Type) event.getObject());
            displayInfoMessage("type édité  " + tp.getCodetype());
        } catch (Exception e) {
            displayErrorMessage("type nonédité  " + tp.getCodetype());
        }
        init();
    }

    public void cancelledType() {
        displayInfoMessage("vous avez annulez");
    }
    public void changgeFAmille(){
        famille.setTypeCollection(typeFacade.changeGroupe(famille));
    }

    public void setSelectedType(Type selectedType) {
        this.selectedType = selectedType;
    }

    public Type getType() {
        return type;
    }

    public List<Type> getListeType() {
        return listeType;
    }

    public Type getSelectedType() {
        return selectedType;
    }

    public Famille getFamille() {
        return famille;
    }
    
}
