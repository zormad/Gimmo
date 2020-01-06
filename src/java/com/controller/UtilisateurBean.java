/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Profil;
import com.entities.Utilisateur;
import com.models.UtilisateurFacade;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ZORE
 */
@SessionScoped
@Named(value = "utilisateurBean")
public class UtilisateurBean extends AbstractBean implements Serializable {

    private static final String LOGIN_PAGE = "/login.xhtml";
    private static Utilisateur userConnecte = new Utilisateur();
    private Utilisateur utilisateur = new Utilisateur();
    private Utilisateur utilisateurSelected;
    private List<Utilisateur> filteredUtilisateurs;
    private final Profil profile = new Profil();
    @Inject
    private UtilisateurFacade facade;
    List<Utilisateur> liste = null;

    public UtilisateurBean() {
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    /*public Boolean isAdmin(){
        return true;
    }
     public Boolean isCsfm(){
        return true;
    }
      public Boolean isMagasinier(){
        return true;
    }
       public Boolean isChargeDotation(){
        return true;
    }*/
    public static Date date() {
        Date date = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        date = cal.getTime();
        return date;
    }
    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        // displayInfoMessage("you are successfully logged out");
        return LOGIN_PAGE+ "?faces-redirect=true";
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void create() throws Throwable {
        try {
            //utilisateur.setIduser(BigDecimal.ZERO);
            utilisateur.setCreele(UtilisateurBean.date());
            utilisateur.setIdprofil(profile);
            utilisateur.setCreepar(this.userConnecte.getLoginuser());
            facade.create(utilisateur);
            facade.hash_passwd(utilisateur);
            displayInfoMessage("Utilisateur inséré");

        } catch (Exception e) {
            displayErrorMessage("Utilisateur non inseré");
        } finally {
            utilisateur = new Utilisateur();
            init();
        }
    }

    public void delete(Utilisateur user) {
        try {
            facade.remove(user);
            displayInfoMessage("suppression effectuée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        try {
            facade.edit((Utilisateur) event.getObject());
            displayInfoMessage("utilisateur édité  " + ((Utilisateur) event.getObject()).getLoginuser());
        } catch (Exception e) {
            displayErrorMessage("utilisateur non édité  " + ((Utilisateur) event.getObject()).getLoginuser());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Profil getProfile() {
        return profile;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getFilteredUtilisateurs() {
        return filteredUtilisateurs;
    }

    public static Utilisateur getUserConnecte() {
        return UtilisateurBean.userConnecte;
    }

    public static void setUserConnecte(Utilisateur userConnecte) {
        UtilisateurBean.userConnecte = userConnecte;
    }

    public List<Utilisateur> getListe() {
        return liste;
    }

    public Utilisateur getUtilisateurSelected() {
        return utilisateurSelected;
    }

    public void setUtilisateurSelected(Utilisateur utilisateurSelected) {
        this.utilisateurSelected = utilisateurSelected;
    }

    public static String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }
public Utilisateur user(){
    return UtilisateurBean.userConnecte;
}
}
