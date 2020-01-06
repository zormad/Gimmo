/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Singleconnexion;
import com.entities.Magasin;
import com.entities.Structure;
import com.models.AffectationFacade;
import com.models.DotationFacade;
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
@Named(value = "journalMouvement")
@SessionScoped
public class JournalMouvement extends AbstractBean implements Serializable {

    @Inject
    private AffectationFacade affectationFacade;
    @Inject
    private DotationFacade dotationFacade;
    private String choix;
    private Magasin magasin=new Magasin();
    private Structure structure=new Structure();
    @Inject
    private StructureFacade structureFacade;
    @Inject
    private MagasinFacade magasinFacade;
    private List<Magasin> listeMagasinP=new ArrayList<>();
    private List<Structure> listeStructure=new ArrayList<>();

    public JournalMouvement(AffectationFacade affectationFacade, DotationFacade dotationFacade, String choix, StructureFacade structureFacade) {
        this.affectationFacade = affectationFacade;
        this.dotationFacade = dotationFacade;
        this.choix = choix;
        this.structureFacade = structureFacade;
    }
    @PostConstruct
    public void init(){
        listeMagasinP=magasinFacade.MagasinPrincipal();
        listeStructure=structureFacade.findAll();
    }
    public JournalMouvement() {
    }
//imprimer de journal de mouvements d'équipement
    public void printPdfJournalAffectation() throws JRException, IOException {
        String jasperPath = "/pages/admin/journalDeMouvement/journalAffectation.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("libellestructure", structure.getLibellestructure());
        parameters.put("nommagasin", magasin.getNommagasin());
        Connection conn = Singleconnexion.getConnecter();
        String title = "journalAffectation";
        String chemin = "/pages/admin/journalDeMouvement/";
        String sql = "select a.creele, p.nomposte,e.idequip, ar.designation"
                + " from affectation a inner join equipement e on e.idequip = a.idequip"
                + " inner join postedetravail p on p.idposte = a.idposte inner join"
                + " article ar on ar.codearticle = e.codearticle inner join service s on s.codeservice = p.codeservice inner join"
                + " structure st on st.codestructure = s.codestructure where st.codestructure= '"+structure.getCodestructure()+"' order by e.idequip";
                 //PDF2(parameters, jasperPath, sql, chemin, filename, conn);
        report(parameters, jasperPath, sql, chemin, title, conn);
    }
    public void printPdfJournalDotation() throws JRException, IOException {
        String jasperPath = "/pages/admin/journalDeMouvement/journalDeDotation.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
//        parameters.put("idsortie", selectedSortie.getIdsortie());
//        parameters.put("libellesortie", selectedSortie.getLibellesortie());
//        parameters.put("nomagent", selectedSortie.getIdagent().getNom() + " " + selectedSortie.getIdagent().getPrenom());
        Connection conn = Singleconnexion.getConnecter();
        String title = "journalDeDotation";
        String chemin = "/pages/admin/journalDeMouvement/";
        String sql = "select d.creele,ar.designation,e.idequip,m.nommagasin from dotation d inner join equipement e on e.idequip = d.idequip inner join article ar on ar.codearticle = e.codearticle inner join magasin m on m.idcodemagasin = d.idcodemagasin order by e.idequip"; //PDF2(parameters, jasperPath, sql, chemin, filename, conn);
        report(parameters, jasperPath, sql, chemin, title, conn);
    }
    public void printPdfJournalRestitution() throws JRException, IOException {
        String jasperPath = "/pages/admin/journalDeMouvement/journalDeRestitution.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
//        parameters.put("idsortie", selectedSortie.getIdsortie());
//        parameters.put("libellesortie", selectedSortie.getLibellesortie());
//        parameters.put("nomagent", selectedSortie.getIdagent().getNom() + " " + selectedSortie.getIdagent().getPrenom());
        Connection conn = Singleconnexion.getConnecter();
        String title = "journalDeRestitution";
        String chemin = "/pages/admin/journalDeMouvement/";
        String sql = "select e.idequip, ar.designation,r.creele,et.libelleetat,t.libelletyperetour from retourner r inner join equipement e on e.idequip = r.idequip inner join article ar on ar.codearticle = e.codearticle inner join typeretour t on t.idtyperetour = r.idtyperetour inner join etat et on e.idetat = et.idetat order by e.idequip";
        report(parameters, jasperPath, sql, chemin, title, conn);
    }
    
    //changer de valeur
    public void changeValues(){
        structure=structureFacade.findBycodeStructure(structure);
        magasin=structure.getMagasin();
    }
//getter and setters

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<Magasin> getListeMagasinP() {
        return listeMagasinP;
    }

    public void setListeMagasinP(List<Magasin> listeMagasinP) {
        this.listeMagasinP = listeMagasinP;
    }

    public List<Structure> getListeStructure() {
        return listeStructure;
    }

    public void setListeStructure(List<Structure> listeStructure) {
        this.listeStructure = listeStructure;
    }

   
    
}
