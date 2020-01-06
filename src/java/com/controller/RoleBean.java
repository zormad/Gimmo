/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Role;
import com.models.RoleFacade;
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
@Named(value = "roleBean")
@SessionScoped
public class RoleBean extends AbstractBean implements Serializable {
    private Role role=new Role();
    private Role selectedrole;
    private List<Role> liste=null;
    @Inject 
    private RoleFacade facade;
    public RoleBean() {
    }
    @PostConstruct
    public void init(){
        liste=facade.findAll();
    }
    
     public void create() {
        try {
            role.setCreele(UtilisateurBean.date());
            role.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(role);
            role = new Role();
            displayInfoMessage("role inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("role non inseré");
        }

        init();
    }

    public void delete(Role rl) {
        try {
            facade.remove(rl);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Role sr = ((Role) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.edit(sr);
            displayInfoMessage("role édité " + sr.getIdrole());
        } catch (Exception e) {
            displayErrorMessage("role non édité " +sr.getIdrole());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public void setSelectedrole(Role selectedRole) {
        this.selectedrole = selectedRole;
    }

    public Role getRole() {
        return role;
    }

    public Role getSelectedrole() {
        return selectedrole;
    }

    public List<Role> getListe() {
        return liste;
    }

    
}
