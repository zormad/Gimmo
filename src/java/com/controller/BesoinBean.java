/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Annee;
import com.entities.Article;
import com.entities.Besoins;
import com.entities.BesoinsPK;
import com.entities.Service;
import com.entities.Structure;
import com.models.ArticleFacade;
import com.models.BesoinsFacade;
import com.models.ServiceFacade;
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
@Named(value = "besoinBean")
@SessionScoped
public class BesoinBean extends  AbstractBean implements Serializable {

    private Besoins besoins = new Besoins();
   // private Article article = new Article();
    private Article a=new Article();
    private Structure structure = new Structure();
    @Inject
    private BesoinsFacade facade;
    @Inject
    private ServiceFacade serviceFacade;
    @Inject
    private ArticleFacade articleFacade;
    private List<Besoins> listedesbesoins = new ArrayList<>();
    private List<Article> listedesArticles=null;
    private List<Article> articlesToremove=null;
    private Service selectedService;
    private List<Integer> listeannee=null;
    @Inject
    private StructureFacade structureFacade;
    //private int annee;
    private Annee selectedAnnee;
     List<Besoins> listeb=new ArrayList<>();

    public BesoinBean() {
    }

    @PostConstruct
    public void init() {
        if(structure!=null){
            listeannee=null;//facade.Annee(structure);
        }else{
            listeannee= new ArrayList<>();
        }
    }
    public void setArticle(){
        a=articleFacade.getArticle(a);
    }
    public void setBesoinCollection(){
        System.out.println("1");
        selectedService=serviceFacade.findBycodeservice(selectedService);
        System.out.println("2");
        listeb=facade.listeBesoinsParService(selectedService, selectedAnnee);
        System.out.println("3");
        //selectedService.setBesoinsCollection(listeb);
        System.out.println("4");
        setListeArticle();
        System.out.println("5");
        for (int i=0;i<listeb.size();i++) {
            Article art=new Article();
            art.setCodearticle(listeb.get(i).getBesoinsPK().getCodearticle());
            art=articleFacade.getArticle(art);
        listedesArticles.remove(art);
        System.out.println("1i"+i);
        }
    }
    public void changeValues(){
        structure=structureFacade.findBycodeStructure(structure);
    }

    public void addToBesoins(){
        //listedesbesoins=facade.listeBesoinsParService(selectedService, selectedAnnee);
        //selectedService.setBesoinsCollection(listedesbesoins);
        try {BesoinsPK pk=new BesoinsPK();
        pk.setAnneebesoin(selectedAnnee.getAnneeid());
        a=articleFacade.getArticle(a);
        pk.setCodearticle(a.getCodearticle());
        pk.setCodeservice(selectedService.getCodeservice());
        besoins.setBesoinsPK(pk);
        besoins.setArticle(a);
            // besoins.setAnneebesoin(selectedAnnee);
        besoins.setCreele(UtilisateurBean.date());
        besoins.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
       // besoins.setService(selectedService);
       // listedesbesoins.add(besoins);
        listeb.add(besoins);
        //selectedService.setBesoinsCollection(listedesbesoins);
        facade.create(besoins);
        listedesArticles.remove(a);
        displayInfoMessage("bésoin ajouté");
        } catch (Exception e) {displayErrorMessage("besoin non ajouté");
        }finally{
            a=new Article();
        besoins=new Besoins();
        }
       
    }
    
    //actions sur les besoins
      public void delete(Besoins bes) {
        try {
            facade.remove(bes);
            listedesArticles.add(bes.getArticle());
            listeb.remove(bes);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        Besoins bes = (Besoins) event.getObject();
        bes.setModifiele(UtilisateurBean.date());
        bes.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
        try {
            facade.edit(bes);
            displayInfoMessage("besoin édité  ");
        } catch (Exception e) {
            displayErrorMessage("besoin non édité  ");
        }
        bes = new Besoins();
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }
    public Besoins getBesoins() {
        return besoins;
    }
    public void setListeArticle(){
    listedesArticles=articleFacade.findAll();
    }

    public void setBesoins(Besoins besoins) {
        this.besoins = besoins;
    }

    
    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<Besoins> getListedesbesoins() {
        return listedesbesoins;
    }

    public void setListedesbesoins(List<Besoins> listedesbesoins) {
        this.listedesbesoins = listedesbesoins;
    }

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    public List<Integer> getListeannee() {
        return listeannee;
    }

    public void setListeannee(List<Integer> listeannee) {
        this.listeannee = listeannee;
    }

//    public int getAnnee() {
//        return annee;
//    }
//
//    public void setAnnee(int annee) {
//        this.annee = annee;
//    }

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

//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }

    public Article getA() {
        return a;
    }

    public void setA(Article a) {
        this.a = a;
    }

    public List<Besoins> getListeb() {
        return listeb;
    }

    public void setListeb(List<Besoins> listeb) {
        this.listeb = listeb;
    }
    
}
