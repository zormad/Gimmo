/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Utilisateur;
import com.models.UtilisateurFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ZORE
 */
@SessionScoped
@Named(value="loginController")
public class LoginController extends AbstractBean implements Serializable {

    //@ManagedProperty(value = UtilisateurBean.INJECTION_NAME)
   // @Inject
   // private UtilisateurBean utilisateurBean;// = new UtilisateurBean();
    @Inject
    private UtilisateurFacade facade;
    private Utilisateur user = null;
    private String login;
    private String passwd;
    private String oldpasswd;
    private String passwd1;
    private String passwd2;
    
    public LoginController(){
        
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

public void changePasswd(){
    Utilisateur u;
    u=isValidLogin(UtilisateurBean.getUserConnecte().getLoginuser(), oldpasswd);
    if(u!=null){
        u.setModifiele(UtilisateurBean.date());
        u.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        u.setLoginpasswd(facade.passwd_hash(passwd1));
        try {
            facade.edit(u);
            displayInfoMessage("mot de passe changé avec succès");
        } catch (Exception e) {
            displayInfoMessage("mot de passe non changé");
        }
    }else{
        displayInfoMessage("le mot de passe est incorrect");
    }
}
    private Utilisateur isValidLogin(String login, String passwd) {
        BigDecimal id=null;
        id=facade.findByLogin(login, passwd);
        if(id!=null){user = facade.findByIdUser(id);}
        else{
            user=null;
        }
        return user;
    }

    public String loging() {
        Utilisateur utilisateur = isValidLogin(login, passwd);
        if (utilisateur != null) {// && utilisateur.getLoginpasswd().equals(passwd)
            UtilisateurBean.setUserConnecte(utilisateur);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("utilisateur", utilisateur);
            return utilisateur.getIdprofil().getIdprofil();

        } else {
            utilisateur = null;
            displayErrorMessage("verifiez vos données ");
            return null;
        }
    }

    public String getOldpasswd() {
        return oldpasswd;
    }

    public void setOldpasswd(String oldpasswd) {
        this.oldpasswd = oldpasswd;
    }

    public String getPasswd1() {
        return passwd1;
    }

    public void setPasswd1(String passwd1) {
        this.passwd1 = passwd1;
    }

    public String getPasswd2() {
        return passwd2;
    }

    public void setPasswd2(String passwd2) {
        this.passwd2 = passwd2;
    }
    
}
