/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Bon;
import com.entities.Bondemande;
import com.entities.Bondotation;
import com.entities.Demandedotation;
import com.entities.Dotation;
import com.entities.Equipement;
import com.entities.Magasin;
import com.entities.Structure;
import com.models.BondemandeFacade;
import com.models.BondotationFacade;
import com.models.DotationFacade;
import com.models.EquipementFacade;
import com.models.MagasinFacade;
import com.models.StructureFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "dotationBean")
@SessionScoped
public class DotationBean extends AbstractBean implements Serializable {

    private Equipement equipement = new Equipement();
    private Dotation dotation = new Dotation();
    private List<Equipement> listeEquipBon = null;
    private List<Equipement> equipementsdotes = null;
    private List<Equipement> listeEquipBonT = new ArrayList<Equipement>();
    private List<Bondotation> listeBonAll = null;
    private List<Magasin> principalMagasins = null;
    private Magasin magasin = new Magasin();
    private Magasin magasinP = new Magasin();
    private Structure structure = new Structure();
    private Bon bon = new Bon();
    private DualListModel<Equipement> equipements;
    private Bondotation bondotation = new Bondotation();
    private List<Bondotation> listebon = null;
    @Inject
    private DotationFacade facade;
    @Inject
    private EquipementFacade equipementFacade;
    @Inject
    private BondotationFacade bonFacade;
    @Inject
    private MagasinFacade magasinFacade;
    @Inject
    private StructureFacade structureFacade;

    //demande de dotation
    private Bondemande selectedbondemande = new Bondemande();
    private Bondemande bondemande = new Bondemande();
    private List<Bondemande> listeDemandes = null;
    ;
    @Inject
    private BondemandeFacade bondemandeFacade;
    private Collection<Demandedotation> demandedotations = null;

    public DotationBean(DotationFacade facade) {
        this.facade = facade;
    }

    public DotationBean() {
    }

    @PostConstruct
    public void init() {
        listeDemandes = bondemandeFacade.listeBonNonValides();
        if (bondemande != null) {
            demandedotations = (List<Demandedotation>) bondemande.getDemandeCollection();
        }
        principalMagasins = magasinFacade.MagasinPrincipal();
        if (magasin != null) {
            listeBonAll = bonFacade.findByvalider(magasin);
        } else {
            listeBonAll = new ArrayList<>();
        }
        if (magasinP != null) {
            listeEquipBon = equipementFacade.findByMagasinActuel(magasinP);//equipementFacade.findByBon(bon,magasin);
        } else {
            listeEquipBon = new ArrayList<Equipement>();
        }

        equipements = new DualListModel<Equipement>(listeEquipBon, listeEquipBonT);
        if (magasin != null) {
            listebon = bonFacade.findByvalider(magasin);
        } else {
            listebon = new ArrayList<Bondotation>();
        }
        if (bondotation != null) {
            equipementsdotes = equipementFacade.listeEquipBondotation(bondotation);
        } else {
            equipementsdotes = new ArrayList();
        }
    }

    public void afterSelect() {
        demandedotations = selectedbondemande.getDemandeCollection();
        magasin = selectedbondemande.getMagasin();
        init();
    }

    public void afterDemande() {
        afterSelect();
        selectedbondemande.setValider("true");
        try {
            bondemandeFacade.edit(selectedbondemande);
            System.out.println("succès");
        } catch (Exception e) {
            System.err.println("errroorrrrr");
        }

        init();
    }

    public void button() {
        displayErrorMessage("" + bondotation.getValider());
    }

    public void create() throws Throwable {
        List<Equipement> equips = equipements.getTarget();
        int tot = 0;
        for (int i = 0; i < equips.size(); i++) {
            //displayErrorMessage("-1");
            dotation.setMagasin(magasin);
            dotation.setEquipement(equips.get(i));
            dotation.setCreele(UtilisateurBean.date());
            dotation.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            try {//displayErrorMessage("0");
                facade.create(dotation);
                //displayErrorMessage("1");
                equips.get(i).setMagasinActuel(magasin);
                equips.get(i).setBondotation(bondotation);
                //displayErrorMessage("2");
                equipementFacade.edit(equips.get(i));
            } catch (Exception e) {
                throw e.getCause();
            } finally {
                dotation = new Dotation();
                tot++;
            }
        }
        if (tot != 0 && tot == equips.size()) {
            displayInfoMessage("Dotation effectuée avec succès");
            //equipementsdotes = equipements.getTarget();
            equipements.setTarget(new ArrayList<Equipement>());
        } else {
            displayInfoMessage("Dotation non effectuée");
        }
        init();

    }

    public void ereaseBonDemande() {
        selectedbondemande = new Bondemande();
        magasin = new Magasin();
        init();
    }

    public void changeStructure() {
        structure = structureFacade.findBycodeStructure(structure);
        magasin = structure.getMagasin();
        bon = new Bon();
        init();
    }

    public void printPdf() throws JRException, IOException {
        String filename = "dotation.pdf";
        String jasperPath = "/pages/admin/dotation/reportBonDotation.jasper";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("bon", bondotation.getIdbondotation());
        parameters.put("nommagasin", magasin.getNommagasin());
        PDF(parameters, jasperPath, equipementsdotes, filename);
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public Dotation getDotation() {
        return dotation;
    }

    public List<Equipement> getListeEquipBon() {
        return listeEquipBon;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public Bon getBon() {
        return bon;
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

    public Magasin getMagasinP() {
        return magasinP;
    }

    public void setMagasinP(Magasin magasinP) {
        this.magasinP = magasinP;
    }

    public List<Equipement> getEquipementsdotes() {
        return equipementsdotes;
    }

    //Bon
    public void createBon() {
        try {
            bondotation.setIdcodemagasin(magasin);
            bondotation.setValider("false");
            bonFacade.create(bondotation);
            displayInfoMessage("bon crée");
        } catch (Exception e) {
            displayInfoMessage("bon non crée");
        } finally {
            bondotation = new Bondotation();
            init();
        }
    }

    public void updateBon() throws JRException, IOException {
        try {
            bondotation.setValider("true");
            bonFacade.edit(bondotation);
            displayInfoMessage("Bon " + bondotation.getLibellebondotation() + " validé avec succès");
        } catch (Exception e) {
            displayErrorMessage("Bon " + bondotation.getLibellebondotation() + " non validé");
        } finally {
            bondotation=new Bondotation();
            equipementsdotes=new ArrayList<>();
            init();
        }
    }

    public void updatebon() {
        bondotation = bonFacade.findByid(bondotation);
//        displayErrorMessage("hhh");
        init();
    }

    public Bondotation getBondotation() {
        return bondotation;
    }

    public void setBondotation(Bondotation bondotation) {
        this.bondotation = bondotation;
    }

    public List<Bondotation> getListeBonAll() {
        return listeBonAll;
    }

    public List<Bondotation> getListebon() {
        return listebon;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<Magasin> getPrincipalMagasins() {
        return principalMagasins;
    }

    public void setPrincipalMagasins(List<Magasin> principalMagasins) {
        this.principalMagasins = principalMagasins;
    }

    public List<Bondemande> getListeDemandes() {
        return listeDemandes;
    }

    public void setListeDemandes(List<Bondemande> listeDemandes) {
        this.listeDemandes = listeDemandes;
    }

    public Collection<Demandedotation> getDemandedotations() {
        return demandedotations;
    }

    public void setDemandedotations(List<Demandedotation> demandedotations) {
        this.demandedotations = demandedotations;
    }

    public Bondemande getSelectedbondemande() {
        return selectedbondemande;
    }

    public void setSelectedbondemande(Bondemande selectedbondemande) {
        this.selectedbondemande = selectedbondemande;
    }

    public Bondemande getBondemande() {
        return bondemande;
    }

    public void setBondemande(Bondemande bondemande) {
        this.bondemande = bondemande;
    }
}
