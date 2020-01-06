/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Groupe;
import com.entities.Famille;
import com.entities.Type;
import com.models.FamilleFacade;
import com.models.GroupeFacade;
import com.entities.Article;
import com.models.ArticleFacade;
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
@Named(value = "articleBean")
@SessionScoped
public class ArticleBean extends AbstractBean implements Serializable {
    
    @Inject
    private ArticleFacade articleFacade;
    private Article article = new Article();
    
    private List<Article> listeArticle = null;
    
    private Article selectedArticle;
    
    private Type type = new Type();
    
    public ArticleBean() {
    }
    
    @PostConstruct
    public void init() {
        listeArticle = articleFacade.findAll();
    }

//article
    public void createArticle() {
        article.setCodetype(type);
        article.setCreele(UtilisateurBean.date());
        article.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            articleFacade.create(article);
            displayInfoMessage("Article inséré avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de l'insertion");
        } finally {
            article = new Article();
            init();
        }
    }
    
    public void deleteArticle(Article art) {
        try {
            articleFacade.delete(art.getCodearticle());
            displayInfoMessage("suppression effectuée avec succès");
            init();
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
    }
    
    public void updateArticle(RowEditEvent event) {
        Article ar = (Article) event.getObject();
        ar.setModifiele(UtilisateurBean.date());
        ar.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            articleFacade.edit((Article) event.getObject());
            displayInfoMessage("article édité  " + ar.getDesignation());
        } catch (Exception e) {
            displayErrorMessage("article non édité  " + ar.getDesignation());
        }
        init();
    }
    
    public void cancelledArticle() {
        displayInfoMessage("vous avez annulez");
    }
    
    public void setSelectedArticle(Article selectedArticle) {
        this.selectedArticle = selectedArticle;
    }
    
    public Article getArticle() {
        return article;
    }
    
    public List<Article> getListeArticle() {
        return listeArticle;
    }
    
    public Article getSelectedArticle() {
        return selectedArticle;
    }
    
    public Type getType() {
        return type;
    }

    public void changeType() {
        type.setArticleCollection(articleFacade.changeGroupe(type));
    }
}
