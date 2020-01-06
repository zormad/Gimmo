/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Article;
import com.entities.Bondemande;
import com.entities.Demandedotation;
import com.entities.Magasin;
import com.entities.Structure;
import com.models.ArticleFacade;
import com.models.BondemandeFacade;
import com.models.StructureFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author ZORE
 */
@Named(value = "demandedotationBean")
@SessionScoped
public class DemandedotationBean extends AbstractBean implements Serializable {

    private Bondemande bondemande = new Bondemande();
    private Demandedotation demande = new Demandedotation();
    private Magasin magasin = new Magasin();
    private Structure structure = new Structure();
    @Inject
    private ArticleFacade articleFacade;
    @Inject
    private StructureFacade structureFacade;
    private Article article = new Article();
    @Inject
    private BondemandeFacade bonfacade;
    @Inject
    private BondemandeFacade facade;
    private List<Demandedotation> liste = new ArrayList<>();
    private List<Demandedotation> listeToremove = new ArrayList<>();
    private List<Article> listeToAdd = new ArrayList<>();
    private List<Bondemande> listedesbons=null;
    private Bondemande selectedBon;
    @Inject
    private DotationBean dotationBean;

    public DemandedotationBean() {
    }

    public void EnregistrerDemande() {
        bondemande.setMagasin(magasin);
        bondemande.setCreele(UtilisateurBean.date());
        try {
            facade.create(bondemande);
            displayInfoMessage(" demande enregistrée  avec succès");
            liste=new ArrayList<>();
            bondemande=new Bondemande();
        } catch (Exception e) {
            displayErrorMessage("demande non enregistrée");
        }finally{
            init();
            dotationBean.init();
        }
    }

    @PostConstruct
    public void init() {
        listeToAdd=articleFacade.findAll();
    if(structure!=null&&magasin!=null){
        listedesbons=facade.listeDesBons(magasin);
    }else{
        listedesbons=null;
    }
    }

    public void changeStruture() {
        structure = structureFacade.findBycodeStructure(structure);
        magasin = structure.getMagasin();
        init();
    }

    public void sort() {
        Collections.sort(liste, new Comparator<Demandedotation>() {
            @Override
            public int compare(Demandedotation t, Demandedotation t1) {
                return t.getArticle().getCodearticle().compareTo(t1.getArticle().getCodearticle());
            }

        });
    }
    
    // Pour que lea articlea ajoutés ne se repetent pas dans la liste
   
    public void ajouterArticle() {
//        demande.setIddemande(BigDecimal.ONE);
        listeToremove = new ArrayList<>();
        article = articleFacade.getArticle(article);
        demande.setArticle(article);
        demande.setDatedemande(UtilisateurBean.date());
        demande.setBondemande(bondemande);
        liste.forEach((n) -> contains(n));
        if (listeToremove.size() > 0) {
            listeToremove.forEach((i) -> liste.remove(i));
        }
        liste.add(demande);
        listeToAdd.remove(article);
        sort();
        displayInfoMessage("demande ajoutée avec succès");
        demande = new Demandedotation();
        article = new Article();
        bondemande.setDemandeCollection(liste);

    }

    public void contains(Demandedotation d) {
        if (d.getArticle().getCodearticle().toBigInteger() == demande.getArticle().getCodearticle().toBigInteger()) {
            listeToremove.add(d);
        }
    }

    public Bondemande getBondemande() {
        return bondemande;
    }

    public void setBondemande(Bondemande bondemande) {
        this.bondemande = bondemande;
    }

    public Demandedotation getDemande() {
        return demande;
    }

    public void setDemande(Demandedotation demande) {
        this.demande = demande;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Demandedotation> getListe() {
        return liste;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<Bondemande> getListedesbons() {
        return listedesbons;
    }

    public void setListedesbons(List<Bondemande> listedesbons) {
        this.listedesbons = listedesbons;
    }
  
    public Bondemande getSelectedBon() {
        return selectedBon;
    }
  
    public void setSelectedBon(Bondemande selectedBon) {
        this.selectedBon = selectedBon;
    }

    public List<Article> getListeToAdd() {
        return listeToAdd;
    }

    public void setListeToAdd(List<Article> listeToAdd) {
        this.listeToAdd = listeToAdd;
    }

}
