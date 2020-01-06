/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Magasin;
import com.entities.Structure;
import com.entities.Typemagasin;
import com.models.MagasinFacade;
import com.models.TypemagasinFacade;
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
@Named(value = "magasinBean")
@SessionScoped
public class MagasinBean extends AbstractBean implements Serializable {

    private Magasin magasin = new Magasin();
//    private Magasin magasinD = new Magasin();
//    private Magasin magasinF = new Magasin();
    private Typemagasin typemagasin = new Typemagasin();
    private Magasin selectedmagasin;
    private Typemagasin selectedtype;
    private Structure structure = new Structure();
//    private Structure structureP = new Structure();
//    private Structure structureS = new Structure();
    @Inject
    private MagasinFacade facade;
    @Inject
    private TypemagasinFacade typemagasinFacade;
    private List<Magasin> liste = null;
    private List<Typemagasin> listeTypemagasins = null;

    public MagasinBean() {
    }
    @PostConstruct
    public void init() {
        liste = facade.findAll();
        listeTypemagasins = typemagasinFacade.findAll();
    }

    public void createMagasin() {
        try {
            magasin.setCreele(UtilisateurBean.date());
            magasin.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            magasin.setCodestructure(structure);
            magasin.setIdtypemag(typemagasin);
            facade.create(magasin);
            magasin = new Magasin();
            displayInfoMessage("magasin crée");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de la création du magasin");
        }
        init();
    }

  

    //Magasin type
     public void createTypemagasin() {
        try {
            typemagasin.setCreele(UtilisateurBean.date());
            typemagasin.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typemagasinFacade.create(typemagasin);
            typemagasin = new Typemagasin();
            displayInfoMessage("typemagasin inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("typemagasin non inseré");
        }

        init();
    }

    public void deleteTypemagasin(Typemagasin sr) {
        try {
            typemagasinFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateTypemagasin(RowEditEvent event) {
        Typemagasin sr = ((Typemagasin) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typemagasinFacade.edit(sr);
            displayInfoMessage("typemagasin édité " + sr.getIdtypemag());
        } catch (Exception e) {
            displayErrorMessage("typemagasin non éditée " +sr.getIdtypemag());
        }
        init();
    }

    public void cancelledTypemagasin() {
        displayInfoMessage("vous avez annulez");
    }

    
    public Magasin getMagasin() {
        return magasin;
    }

    public Typemagasin getTypemagasin() {
        return typemagasin;
    }

    public Structure getStructure() {
        return structure;
    }

    public List<Magasin> getListe() {
        return liste;
    }

    public List<Typemagasin> getListeTypemagasins() {
        return listeTypemagasins;
    }

    public void delete(Magasin mg) {
        try {
            facade.delete(mg.getIdcodemagasin());
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }
 
     public void update(RowEditEvent event) {
         Magasin mag=(Magasin) event.getObject();
        try {
            facade.edit(mag);
            displayInfoMessage("magasin édité  "+mag.getIdcodemagasin());
        } catch (Exception e) {
            displayErrorMessage("magasin non édité  "+mag.getIdcodemagasin());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }

    public Magasin getSelectedmagasin() {
        return selectedmagasin;
    }

    public void setSelectedmagasin(Magasin selectedmagasin) {
        this.selectedmagasin = selectedmagasin;
    }

    public Typemagasin getSelectedtype() {
        return selectedtype;
    }

    public void setSelectedtype(Typemagasin selectedtype) {
        this.selectedtype = selectedtype;
    }
    
//public void findStructure(){
//   structure.setMagasinCollection(facade.findByStructure(structure.getCodestructure()));
//   structureP.setMagasinCollection(facade.findByStructure(structureP.getCodestructure()));
//   structureS.setMagasinCollection(facade.findByStructure(structureS.getCodestructure()));
// }

//    public Structure getStructureP() {
//        return structureP;
//    }
//
//    public Structure getStructureS() {
//        return structureS;
//    }
//
//    public Magasin getMagasinD() {
//        return magasinD;
//    }
//
//    public Magasin getMagasinF() {
//        return magasinF;
//    }


}
