/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Agent;
import com.entities.Magasin;
import com.entities.Structure;
import com.entities.Typemagasin;
import com.entities.Typestructure;
import com.models.MagasinFacade;
import com.models.StructureFacade;
import com.models.TypestructureFacade;
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
@Named(value = "structureBean")
@SessionScoped
public class StructureBean extends AbstractBean implements Serializable {

    private Structure structure = new Structure();
//    private Structure structureP = new Structure();
//    private Structure structureS = new Structure();
    private Magasin magasin=new Magasin();
    private Agent agent = new Agent();
    private Structure selectedStructure;
    private Structure selectedStructure2;
    private Typestructure selectedtype;
    private Typestructure ts = new Typestructure();
    @Inject
    private StructureFacade facade;
    @Inject
    private MagasinFacade magasinfacade;
    @Inject
    private TypestructureFacade typestructureFacade;
    private List<Structure> liste = null;
//    private List<Structure> listeP = null;
//    private List<Structure> listeS = null;
    private List<Typestructure> listeTypestructures = null;

    /**
     * Creates a new instance of StructureBean
     */
    public StructureBean() {
    }
    @PostConstruct
    public void init() {
        liste = facade.findAll();
        listeTypestructures = typestructureFacade.findAll();
//        listeP=facade.findStrucP();
//        listeS=facade.findStrucS();
    }
    public void test(){
        displayInfoMessage(""+selectedStructure2);
    }

    public void createStructure() {
        try {
            structure.setCreele(UtilisateurBean.date());
            structure.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            structure.setIdagent(agent);
            structure.setIdtypestruct(ts);
            facade.create(structure);
            structure=new Structure();
            displayInfoMessage("structure créee");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de la création du structure");
        }
        init();
    }
    
    public void delete(Structure st) {
        try {
            facade.delete(st.getCodestructure());
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void update(RowEditEvent event) {
        try {
            facade.edit((Structure) event.getObject());
            displayInfoMessage("structure éditée  "+((Structure) event.getObject()).getCodestructure());
        } catch (Exception e) {
            displayErrorMessage("structure non éditée  "+((Structure) event.getObject()).getCodestructure());
        }
        init();
    }

    public void cancelled() {
        displayInfoMessage("vous avez annulez");
    }



    //TYpe STRUCTURE
     public void createTypestructure() {
        try {
            ts.setCreele(UtilisateurBean.date());
            ts.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typestructureFacade.create(ts);
            ts = new Typestructure();
            displayInfoMessage("type structure inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("type structure non inseré");
        }

        init();
    }
     

    public void deleteTypestructure(Typestructure sr) {
        try {
            typestructureFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        }
        init();
    }

    public void updateTypestructure(RowEditEvent event) {
        Typestructure sr = ((Typestructure) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typestructureFacade.edit(sr);
            displayInfoMessage("type structure édité " + sr.getIdtypestruct());
        } catch (Exception e) {
            displayErrorMessage("type structure non éditée " +sr.getIdtypestruct());
        }
        init();
    }

    public void cancelledTypestructure() {
        displayInfoMessage("vous avez annulez");
    }

    
    public Structure getStructure() {
        return structure;
    }

    public Agent getAgent() {
        return agent;
    }

    public Typestructure getTs() {
        return ts;
    }
    public List<Structure> getListe() {
        return liste;
    }

    public List<Typestructure> getListeTypestructures() {
        return listeTypestructures;
    }
    public Structure getSelectedStructure() {
        return selectedStructure;
    }

    public void setSelectedStructure(Structure selectedStructure) {
        this.selectedStructure = selectedStructure;
    }

    public Structure getSelectedStructure2() {
        return selectedStructure2;
    }

    public void setSelectedStructure2(Structure selectedStructure2) {
        this.selectedStructure2 = selectedStructure2;
    }

    public Typestructure getSelectedtype() {
        return selectedtype;
    }

    public void setSelectedtype(Typestructure selectedtype) {
        this.selectedtype = selectedtype;
    }
public void prepareMagasin(){
    Typemagasin type=new Typemagasin();
    type.setIdtypemag("second");
    magasin=new Magasin();
    magasin.setIdtypemag(type);
    magasin.setNommagasin("magasin "+selectedStructure2.getLibellestructure());
    magasin.setIdcodemagasin("m"+selectedStructure2.getCodestructure());
    magasin.setCodestructure(selectedStructure2);
}
public void createMagasin() {
        try {
            magasin.setCreele(UtilisateurBean.date());
            magasin.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            magasinfacade.create(magasin);
            selectedStructure2.setMagasin(magasin);
            facade.edit(selectedStructure2);
            magasin = new Magasin();
            displayInfoMessage("magasin crée");
        } catch (Exception e) {
            displayErrorMessage("erreur lors de la création du magasin");
        }finally{
            init();
        }
    }
//    public Structure getStructureP() {
//        return structureP;
//    }
//
//    public Structure getStructureS() {
//        return structureS;
//    }

//    public List<Structure> getListeP() {
//        return listeP;
//    }
//
//    public List<Structure> getListeS() {
//        return listeS;
//    }

    public Magasin getMagasin() {
        return magasin;
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

   
}
