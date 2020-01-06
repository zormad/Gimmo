/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Postedetravail;
import com.entities.Service;
import com.models.PostedetravailFacade;
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
@Named(value = "postedetravailBean")
@SessionScoped
public class PostedetravailBean extends AbstractBean implements Serializable {
    @Inject
    private PostedetravailFacade facade;
    private Postedetravail postedetravail=new Postedetravail();
    
    private Postedetravail selectedposte;
    private Postedetravail selectedposte1;
    private List<Postedetravail> liste=null;
    private Service service=new Service();
    public PostedetravailBean() {
    }
    @PostConstruct
    public void init(){
     liste=facade.findAll();
    }
     public String create() {
        try {
            postedetravail.setService(service);
            postedetravail.setCreele(UtilisateurBean.date());
            postedetravail.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(postedetravail);
            postedetravail=new Postedetravail();
            displayInfoMessage("postedetravail inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("postedetravail non inseré");
        } finally{
            postedetravail=new Postedetravail();
            init();
        }

        return "";
    }

    public void delete(Postedetravail p){
        try {
            facade.remove(p);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }
     public void update(RowEditEvent event){
        try {
            facade.edit((Postedetravail) event.getObject());
            displayInfoMessage("Postedetravail édité "+((Postedetravail) event.getObject()).getIdposte());
        } catch (Exception e) {
            displayErrorMessage("Postedetravail non édité "+((Postedetravail) event.getObject()).getIdposte());
        }
        init();
    }
     public void cancelled(){
         displayInfoMessage("vous avez annulez");
     }

    public List<Postedetravail> getListe() {
        return liste;
    }

    public Postedetravail getSelectedposte() {
        return selectedposte;
    }

    public void setSelectedposte(Postedetravail selectedposte) {
        this.selectedposte = selectedposte;
    }


    public Postedetravail getPostedetravail() {
        return postedetravail;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Postedetravail getSelectedposte1() {
        return selectedposte1;
    }

    public void setSelectedposte1(Postedetravail selectedposte1) {
        this.selectedposte1 = selectedposte1;
    }
   
}
