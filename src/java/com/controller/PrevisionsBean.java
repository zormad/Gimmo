/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Annee;
import com.entities.Article;
import com.entities.PrevisionsPK;
import com.entities.Previsions;
import com.entities.Structure;
import com.models.ArticleFacade;
import com.models.PrevisionsFacade;
import com.models.StructureFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ZORE
 */
@Named(value = "previsionsBean")
@SessionScoped
public class PrevisionsBean extends AbstractBean implements Serializable {

    private Previsions previsions = new Previsions();
    private Structure structure = new Structure();
   // private Structure selectedStructure = new Structure();
    private Annee selectedAnnee;
    private List<Article> listedesArticles = new ArrayList<>();
    private List<Previsions> listedesPrevisions = new ArrayList<>();
    private Article article = new Article();
    @Inject
    private StructureFacade structureFacade;
    @Inject
    private PrevisionsFacade facade;
    @Inject
    private ArticleFacade articleFacade;

    public PrevisionsBean() {
    }

    @PostConstruct
    public void init() {

    }

    public void changeValues() {
        structure = structureFacade.findBycodeStructure(structure);
       // setPrevisionsCollection();
    }

    //actions sur les previsions
    public void delete(Previsions pre) {
        try {
            facade.remove(pre);
            listedesArticles.add(pre.getArticle());
            listedesPrevisions.remove(pre);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void setArticle() {
        article = articleFacade.getArticle(article);
    }

    public void setListeArticle() {
        listedesArticles = articleFacade.findAll();
    }

    public void setPrevisionsCollection() {
        //selectedStructure = structureFacade.findBycodeStructure(selectedStructure);
        listedesPrevisions = facade.listeBesoinsParStructure(structure, selectedAnnee);
        //selectedStructure.setBesoinsCollection(listedesPrevisions);
        setListeArticle();
        for (int i = 0; i < listedesPrevisions.size(); i++) {
            Article art = new Article();
            art.setCodearticle(listedesPrevisions.get(i).getPrevisionsPK().getCodearticle());
            art = articleFacade.getArticle(art);
            listedesArticles.remove(art);
        }
    }

    public void addToBesoins() {
        //listedesprevisions=facade.listeBesoinsParService(selectedStructure, selectedAnnee);
        //selectedStructure.setBesoinsCollection(listedesprevisions);
        try {
            PrevisionsPK pk = new PrevisionsPK();
            pk.setAnneeprevision(selectedAnnee.getAnneeid());
            article = articleFacade.getArticle(article);
            pk.setCodearticle(article.getCodearticle());
            pk.setCodestructure(structure.getCodestructure());
            previsions.setPrevisionsPK(pk);
            previsions.setArticle(article);
            // previsions.setAnneebesoin(selectedAnnee);
            previsions.setCreele(UtilisateurBean.date());
            previsions.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            // previsions.setService(selectedStructure);
            // listedesprevisions.add(previsions);
            listedesPrevisions.add(previsions);
            //selectedStructure.setBesoinsCollection(listedesprevisions);
            facade.create(previsions);
            listedesArticles.remove(article);
            displayInfoMessage("prévision ajoutée");
        } catch (Exception e) {
            displayErrorMessage("prévision non ajoutée");
        } finally {
            article = new Article();
            previsions = new Previsions();
        }

    }

    public void update(RowEditEvent event) {
        Previsions pre = (Previsions) event.getObject();
        pre.setModifiele(UtilisateurBean.date());
        pre.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            facade.edit(pre);
            displayInfoMessage("revisions édité  ");
        } catch (Exception e) {
            displayErrorMessage("previsions non édité  ");
        }
        pre = new Previsions();
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    //getters and setters
    public Previsions getPrevisions() {
        return previsions;
    }

    public void setPrevisions(Previsions previsions) {
        this.previsions = previsions;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

//    public Structure getSelectedStructure() {
//        return selectedStructure;
//    }
//
//    public void setSelectedStructure(Structure selectedStructure) {
//        this.selectedStructure = selectedStructure;
//    }

    public Annee getSelectedAnne() {
        return selectedAnnee;
    }

    public void setSelectedAnne(Annee selectedAnnee) {
        this.selectedAnnee = selectedAnnee;
    }

    public Annee getSelectedAnnee() {
        return selectedAnnee;
    }

    public void setSelectedAnnee(Annee selectedAnnee) {
        this.selectedAnnee = selectedAnnee;
    }

    public List<Article> getListedesArticles() {
        return listedesArticles;
    }

    public void setListedesArticles(List<Article> listedesArticles) {
        this.listedesArticles = listedesArticles;
    }

    public List<Previsions> getListedesPrevisions() {
        return listedesPrevisions;
    }

    public void setListedesPrevisions(List<Previsions> listedesPrevisions) {
        this.listedesPrevisions = listedesPrevisions;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

}
