/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Agent;
import com.entities.Service;
import com.entities.Structure;
import com.models.ServiceFacade;
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
@Named(value = "serviceBean")
@SessionScoped
public class ServiceBean extends AbstractBean implements Serializable {

    private Service service = new Service();
    private Structure structure=new Structure();
    private Service selectedservice;
     private Service selectedservice1;
    @Inject
    private ServiceFacade facade;
    private Agent agent = new Agent();

    private List<Service> liste = null;

    public ServiceBean() {
    }
    @PostConstruct
    public void init(){
        liste=facade.findAll();
    }
 public void create() {
        try {
            service.setCreele(UtilisateurBean.date());
            service.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            service.setIdagent(agent);
            service.setStructure(structure);
            facade.create(service);
            service = new Service();
            displayInfoMessage("service inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("service non inseré");
        }

        init();
    }

    public void delete(Service sr) {
        try {
            facade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Service sr = ((Service) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("service édité " + sr.getCodeservice());
        } catch (Exception e) {
            displayErrorMessage("service non édité " +sr.getCodeservice());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Service getService() {
        return service;
    }

    public Structure getStructure() {
        return structure;
    }

    public Service getSelectedservice() {
        return selectedservice;
    }

    public Agent getAgent() {
        return agent;
    }

    public List<Service> getListe() {
        return liste;
    }

    public void setSelectedservice(Service selectedservice) {
        this.selectedservice = selectedservice;
    }

    public Service getSelectedservice1() {
        return selectedservice1;
    }

    public void setSelectedservice1(Service selectedservice1) {
        this.selectedservice1 = selectedservice1;
    }

    
}
