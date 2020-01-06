/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Affectationutilisateur;
import com.entities.Agent;
import com.entities.Utilisateur;
import com.models.AffectationutilisateurFacade;
import com.models.AgentFacade;
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
@Named(value = "agentBean")
@SessionScoped
public class AgentBean extends AbstractBean implements Serializable {

    private Agent agent = new Agent();
    @Inject
    private AgentFacade facade;
    @Inject
    private AffectationutilisateurFacade af;
    private Affectationutilisateur affectationuser=new Affectationutilisateur();
    private List<Agent> liste = null;
    private Agent agentSelected;
    private Utilisateur utilisateur=new Utilisateur();

    public AgentBean() {
    }

    public void create() {
        try {
            agent.setCreele(UtilisateurBean.date());
            agent.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            facade.create(agent);
            displayInfoMessage("Agent crée avec succès");
        } catch (Exception e) {
            displayErrorMessage("Erreur lors de la création de l'agent");
        } finally {
            agent = new Agent();
            init();
        }
    }

    @PostConstruct
    public void init() {
        liste = facade.findAll();
    }

    public void delete(Agent agt) {
        try {
            facade.remove(agt);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        try {
            facade.edit((Agent) event.getObject());
            displayInfoMessage("agent édité  "+((Agent) event.getObject()).getMatricule());
        } catch (Exception e) {
            displayErrorMessage("agent non édité "+((Agent) event.getObject()).getMatricule());
        }
        init();
    }
    public void createaffectation(){
        affectationuser.setAgent(agent);
        affectationuser.setCreele(UtilisateurBean.date());
        affectationuser.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        affectationuser.setUtilisateur(utilisateur);
        affectationuser.setDateaffectation(UtilisateurBean.date());
        try{
            af.create(affectationuser);
            displayInfoMessage("affectation reussie");
        }catch(Exception e){
            displayErrorMessage("erreur lors de l'affectation");
        }finally{
            init();
        }
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Agent getAgent() {
        return agent;
    }

    public List<Agent> getListe() {
        return liste;
    }

    public Agent getAgentSelected() {
        return agentSelected;
    }

    public void setAgentSelected(Agent agentSelected) {
        this.agentSelected = agentSelected;
    }

    public Affectationutilisateur getAffectationuser() {
        return affectationuser;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

}
