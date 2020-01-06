/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Singleconnexion;
import com.entities.Magasin;
import com.entities.Structure;
import com.models.MagasinFacade;
import com.models.StructureFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author ZORE
 */
@Named(value = "etatExecution")
@SessionScoped
public class EtatExecution extends AbstractBean implements Serializable {

    private Magasin magasin=new Magasin();
    @Inject
    private MagasinFacade magasinFacade;
    private List<Magasin> listeMagasin=new ArrayList<>();
    //private Structure structure=new Structure();
     private Structure structure1=new Structure();
    @Inject
    private StructureFacade structureFacade;
    private List<Structure> listeStructure=new ArrayList<>();

    
    @PostConstruct
    public void init(){
        listeMagasin=magasinFacade.findAll();
        listeStructure=structureFacade.findAll();
    }
    public EtatExecution() {
    }
//imprimer de journal de mouvements d'équipement
    public void printPdfEtatExecution() throws JRException, IOException {
        magasinFacade.createViews(structure1);
        String jasperPath = "/pages/admin/etatExecution/etatExecution.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("libellestructure", structure1.getLibellestructure());
        Connection conn = Singleconnexion.getConnecter();
        String title = "etatExecution";
        String chemin = "/pages/admin/etatExecution/";
        String sql = "select p.libellestructure, p.designation,p.quantite,b.dotation from view_previsions p inner join view_besoins b on b.designation = p.designation";
//PDF2(parameters, jasperPath, sql, chemin, filename, conn);
        report(parameters, jasperPath, sql, chemin, title, conn);
    }
    
    
    
    
    //changer de valeur
    public void changeValues(){
        structure1=structureFacade.findBycodeStructure(structure1);
        magasin=structure1.getMagasin();
    }
//getter and setters

   
    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public List<Magasin> getListeMagasin() {
        return listeMagasin;
    }

    public void setListeMagasin(List<Magasin> listeMagasin) {
        this.listeMagasin = listeMagasin;
    }

    public Structure getStructure1() {
        return structure1;
    }

    public void setStructure1(Structure structure1) {
        this.structure1 = structure1;
    }
    
    

//    public Structure getStructure() {
//        return structure;
//    }
//
//    public void setStructure(Structure structure) {
//        this.structure = structure;
//    }

    public List<Structure> getListeStructure() {
        return listeStructure;
    }

    public void setListeStructure(List<Structure> listeStructure) {
        this.listeStructure = listeStructure;
    }
   
    
}
