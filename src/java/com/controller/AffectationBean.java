/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Affectation;
import com.entities.Bonaffectation;
import com.entities.Equipement;
import com.entities.Magasin;
import com.entities.Postedetravail;
import com.entities.Service;
import com.entities.Structure;
import com.models.AffectationFacade;
import com.models.BonaffectationFacade;
import com.models.EquipementFacade;
import com.models.PostedetravailFacade;
import com.models.ServiceFacade;
import com.models.StructureFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author ZORE
 */
@Named(value = "affectationBean")
@SessionScoped
public class AffectationBean extends AbstractBean implements Serializable {

    private Equipement equipement = new Equipement();
    private Structure structure = new Structure();
    private Service service = new Service();
    private Postedetravail poste = new Postedetravail();
    private Affectation affectation = new Affectation();
    private List<Equipement> listeEquipBon = null;//source de dualList
    private List<Equipement> listeEquipBonT = null;//target de dualList
    private List<Equipement> equipementsaffectes = null;
    private Magasin magasin = new Magasin();
    private DualListModel<Equipement> equipements;
    private Bonaffectation bonaffectation=new Bonaffectation();
    @Inject
    private BonaffectationFacade bonfacade;
    private List<Bonaffectation> listebonAll=null;
    private List<Bonaffectation> listebon=new ArrayList<Bonaffectation>();
    @Inject
    private AffectationFacade facade;
    @Inject
    private StructureFacade structurefacade;
    @Inject
    private ServiceFacade serviceFacade;
    @Inject
    private EquipementFacade equipementFacade;
    @Inject
    private PostedetravailFacade posteFacade;

    public AffectationBean() {
    }

    @PostConstruct
    public void init() {
        if(magasin!=null){
            listeEquipBon = equipementFacade.findByMagasinActuel(magasin);//equipementFacade.findByBon(bon,magasin);
        }else{
            listeEquipBon=new ArrayList<Equipement>();
        }
        if (poste != null) {
            
            listebon = bonfacade.findByvalider(poste);
            listebonAll = bonfacade.findByvalider(poste);
        } else {
            listebon = new ArrayList<Bonaffectation>();
            listebonAll = new ArrayList<Bonaffectation>();
        }
        listeEquipBonT = new ArrayList<Equipement>();
        equipements = new DualListModel<Equipement>(listeEquipBon, listeEquipBonT);
        if (bonaffectation != null) {
            equipementsaffectes = equipementFacade.listeEquipBonaffectation(bonaffectation);
        } else {
            equipementsaffectes = new ArrayList();
        }
        if(poste.getIdposte()!=null) changePoste();
    }
    public void changePoste(){
        poste=posteFacade.getPostedetravail(poste);
    }
     public void printPdf() throws JRException, IOException {
        String filename = "affectation.pdf";
        String jasperPath = "/pages/admin/affectation/affectationjasper.jasper";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("idBon", bonaffectation.getIdbonaffectation());
         parameters.put("idposte",poste.getIdposte());
         parameters.put("libelleposte",poste.getNomposte());
         parameters.put("libelleservice",service.getLibelleservice());
         parameters.put("libellestructure",structure.getLibellestructure());
         parameters.put("libellebon", bonaffectation.getLibellebonaffectation());
         parameters.put("dateaffectation", bonaffectation.getCreele());
        PDF(parameters, jasperPath, equipementsaffectes, filename);
    }

    public void changeValue() {
        if (structure != null) {
            structure = structurefacade.findBycodeStructure(structure);
            magasin=structure.getMagasin();
        }
        service = new Service();
        poste = new Postedetravail();
        init();
    }

    public void changeValue2() {

        if (service != null) {
            service = serviceFacade.findBycodeservice(service);
        }
        poste = new Postedetravail();
        init();
    }

    public void create() {
        List<Equipement> equips = equipements.getTarget();
        int tot = 0;
        for (int i = 0; i < equips.size(); i++) {
            affectation.setPostedetravail(poste);
            affectation.setEquipement(equips.get(i));
            affectation.setCreele(UtilisateurBean.date());
            affectation.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            try {
                facade.create(affectation);
                tot++;
                equips.get(i).setMagasinActuel(null);
                equips.get(i).setPosteActuel(poste);
                equips.get(i).setBonaffectation(bonaffectation);
                equipementFacade.edit(equips.get(i));
            } catch (Exception e) {
            } finally {
                affectation = new Affectation();
            } 
        }
        if (tot!=0&&tot == equips.size()) {
            displayInfoMessage("équipements affectés avec succès");
            //equipementsaffectes = equipements.getTarget();
            equipements.setTarget(new ArrayList<Equipement>());
        } else {
            displayInfoMessage("équipements non  affectés");
        }
        init();

    }

    public Equipement getEquipement() {
        return equipement;
    }

    public List<Equipement> getListeEquipBon() {
        return listeEquipBon;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public DualListModel<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(DualListModel<Equipement> equipements) {
        this.equipements = equipements;
    }

//picklist
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Equipement) item).getIdequip()).append(" ");
        }
        displayInfoMessage(builder.toString());
    }

    public void onSelect(SelectEvent event) {
        displayInfoMessage("Equipement selectionné");
    }

    public void onUnselect(UnselectEvent event) {
        displayInfoMessage("Equipement deselectionné");
    }

    public void onReorder() {
        displayInfoMessage("Liste Réordonnée");
    }
    
    //Bon
    public void createBon() {
        try {
            bonaffectation.setPoste(poste);
            bonaffectation.setValider("false");
            bonfacade.create(bonaffectation);
            displayInfoMessage("bon crée");
        } catch (Exception e) {
            displayInfoMessage("bon non crée");
        } finally {
            bonaffectation = new Bonaffectation();
            init();
        }
    }

    public void updateBon() throws JRException, IOException {
        try {bonaffectation.setValider("true");
            bonfacade.edit(bonaffectation);
            displayInfoMessage("Bon " + bonaffectation.getLibellebonaffectation()+ " validé avec succès");
        } catch (Exception e) {
            displayErrorMessage("Bon " + bonaffectation.getLibellebonaffectation() + " non validé");
        } finally {
            bonaffectation=new Bonaffectation();
            equipementsaffectes=new ArrayList<>();
            init();
        }
        
    }

    public void updatebon() {
        bonaffectation = bonfacade.findByid(bonaffectation);
        init();
    }


    public Magasin getMagasinP() {
        return magasin;
    }

    public void setMagasinP(Magasin magasin) {
        this.magasin = magasin;
    }

    public List<Equipement> getEquipementsdotes() {
        return equipementsaffectes;
    }

    public Postedetravail getPoste() {
        return poste;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public List<Equipement> getEquipementsaffectes() {
        return equipementsaffectes;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Service getService() {
        return service;
    }

    public List<Bonaffectation> getListebonAll() {
        return listebonAll;
    }

    public List<Bonaffectation> getListebon() {
        return listebon;
    }

    public Bonaffectation getBonaffectation() {
        return bonaffectation;
    }

}
