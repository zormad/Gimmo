/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Singleconnexion;
import com.entities.Bonrestitution;
import com.entities.Equipement;
import com.entities.Magasin;
import com.entities.Postedetravail;
import com.entities.Retourner;
import com.entities.Service;
import com.entities.Structure;
import com.entities.Typeretour;
import com.models.BonrestitutionFacade;
import com.models.EquipementFacade;
import com.models.MagasinFacade;
import com.models.RetournerFacade;
import com.models.ServiceFacade;
import com.models.StructureFacade;
import com.models.TyperetourFacade;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author ZORE
 */
@Named(value = "retournerBean")
@SessionScoped
public class RetournerBean extends AbstractBean implements Serializable {

    private Equipement equipement = new Equipement();
    private Structure structure = new Structure();
    private Structure structureP = new Structure();
    private Structure structureF = new Structure();
    private Service service = new Service();
    private Postedetravail poste = new Postedetravail();
    private List<Equipement> listeEquipBonPoste = null;//source de dualList
    private List<Equipement> listeEquipBonTPoste = null;//target de dualList
    private List<Equipement> equipementsretournesPoste = null;
    private List<Equipement> listeEquipBonMagasin = null;//source de dualList
    private List<Equipement> listeEquipBonTMagasin = null;//target de dualList
    private List<Equipement> equipementsretournesMagasin = null;
    private List<Magasin> MagasinPrincipal = null;
    private Magasin magasin = new Magasin();
    private Magasin magasinD = new Magasin();
    private Bonrestitution bonrestitution = new Bonrestitution();
    private Bonrestitution bonrestitutionP = new Bonrestitution();
    private List<Bonrestitution> listebonPoste = null;
    private List<Bonrestitution> listebonMagasin = null;
    @Inject
    private BonrestitutionFacade bonFacade;
    private DualListModel<Equipement> equipementsPoste;
    private DualListModel<Equipement> equipementsMagasin;
    private List<Bonrestitution> listeBonAllPoste = null;
    private List<Bonrestitution> listeBonAllMagasin = null;
    @Inject
    private StructureFacade structurefacade;
    @Inject
    private ServiceFacade serviceFacade;
    @Inject
    private EquipementFacade equipementFacade;
    @Inject
    private MagasinFacade magasinFacade;

    private Retourner retourner = new Retourner();
    private Retourner selectedRetourner;

    private Typeretour type = new Typeretour();
    private Typeretour type1 = new Typeretour();
    private Typeretour selectedType;
    @Inject
    private TyperetourFacade typeretourFacade;
    @Inject
    private RetournerFacade facade;
    List<Typeretour> listeRetour = null;
    List<Retourner> liste = null;

    public RetournerBean() {
    }

    @PostConstruct
    public void init() {
//        liste = facade.findAll();
      //  System.out.println("1" + equipementsretournesPoste.size());
        MagasinPrincipal = magasinFacade.MagasinPrincipal();
        listeRetour = typeretourFacade.findAll();
        if (poste != null) {
            listeEquipBonPoste = equipementFacade.findByPosteActuel(poste);//equipementFacade.findByBon(bon,magasin);
        } else {
            listeEquipBonPoste = new ArrayList<>();
        }
        listeEquipBonTPoste = new ArrayList<>();
        equipementsPoste = new DualListModel<>(listeEquipBonPoste, listeEquipBonTPoste);

        if (magasinD != null) {
            listeEquipBonMagasin = equipementFacade.findByMagasinActuel(magasinD);//equipementFacade.findByBon(bon,magasin);
        } else {
            listeEquipBonMagasin = new ArrayList<>();
        }
        listeEquipBonTMagasin = new ArrayList<>();

        equipementsMagasin = new DualListModel<>(listeEquipBonMagasin, listeEquipBonTMagasin);

        if (poste != null) {
            listebonPoste = bonFacade.findByvaliderPoste(poste);
            listeBonAllPoste = bonFacade.findByvaliderPoste(poste);
        } else {
            listebonPoste = new ArrayList<>();
            listeBonAllPoste = new ArrayList<>();
        }
        if (magasinD != null) {
            listebonMagasin = bonFacade.findByvaliderMagasin(magasinD);
            listeBonAllMagasin = bonFacade.findByvaliderMagasin(magasinD);
        } else {
            listebonMagasin = new ArrayList<>();
            listeBonAllMagasin = new ArrayList<>();
        }
        if (bonrestitution != null && magasinD.getIdcodemagasin() != null) {
            //equipementsretournesPoste = equipementFacade.listeEquipBonrestitution(bonrestitution);
            equipementsretournesMagasin = equipementFacade.listeEquipBonrestitution(bonrestitution);
        } else {
            equipementsretournesMagasin = new ArrayList();
            //equipementsretournesPoste = new ArrayList();
        }
        if (bonrestitutionP != null && poste.getIdposte() != null) {
            equipementsretournesPoste = equipementFacade.listeEquipBonrestitution(bonrestitutionP);
            System.out.println("2" + equipementsretournesPoste.size());
            // equipementsretournesMagasin = equipementFacade.listeEquipBonrestitution(bonrestitutionP);
        } else {
            //equipementsretournesMagasin = new ArrayList();
            equipementsretournesPoste = new ArrayList();
        }
        
    }

    public void changeValue() {
        if (structureP != null) {
            structureP = structurefacade.findBycodeStructure(structureP);
            magasin = structureP.getMagasin();
            bonrestitutionP = new Bonrestitution();
        }
        service = new Service();
        poste = new Postedetravail();
        init();

    }

    public void changeValueP() {
        if (structure != null) {
            structure = structurefacade.findBycodeStructure(structure);
            magasinD = structure.getMagasin();
            bonrestitution = new Bonrestitution();
        }
        service = new Service();
        poste = new Postedetravail();
        init();

    }

    public void changeValueP2() {
        if (structureF != null) {
            structureF = structurefacade.findBycodeStructure(structureF);
        }
        magasin = new Magasin();
        init();

    }

    public void changeValue2() {

        if (service != null) {
            service = serviceFacade.findBycodeservice(service);
        }
        poste = new Postedetravail();
        init();
    }

    //REtourner
    public void create() throws Throwable {
        List<Equipement> equips = equipementsPoste.getTarget();
        int tot = 0;
        for (int i = 0; i < equips.size(); i++) {
        retourner.setMagasin(magasin);
            retourner.setEquipement(equips.get(i));
            retourner.setDateretourner(UtilisateurBean.date());
            retourner.setIdtyperetour(type1);
            retourner.setCreele(UtilisateurBean.date());
            retourner.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            try {
                facade.create(retourner);
                equips.get(i).setMagasinActuel(magasin);
                equips.get(i).setPosteActuel(null);
                equips.get(i).setBonrestitution(bonrestitutionP);
                equipementFacade.edit(equips.get(i));
                tot++;
            } catch (Exception e) {
            } finally {
                retourner = new Retourner();
            }
        }
        if (tot != 0 && tot == equips.size()) {
            displayInfoMessage("équipements retournés avec succès");
            // equipementsretournesPoste = equipementsPoste.getTarget();
        } else {
            displayInfoMessage("équipements non  retournés");
        }
        init();

    }

    //retourner magasin principal
    public void retournerPrincipal() throws Throwable {
        List<Equipement> equips = equipementsMagasin.getTarget();
        int tot = 0;
        for (int i = 0; i < equips.size(); i++) {
            retourner.setMagasin(magasin);
            retourner.setEquipement(equips.get(i));
            retourner.setDateretourner(UtilisateurBean.date());
            retourner.setIdtyperetour(type1);
            retourner.setCreele(UtilisateurBean.date());
            retourner.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            try {
                facade.create(retourner);
                tot++;
                equips.get(i).setMagasinActuel(magasin);
                equipementFacade.edit(equips.get(i));
                equips.get(i).setBonrestitution(bonrestitution);
                equipementFacade.update(equips.get(i));
            } catch (Exception e) {
            } finally {
                retourner = new Retourner();
            }
        }
        if (tot != 0 && tot == equips.size()) {
            displayInfoMessage("équipements retournés avec succès");
            equipementsretournesMagasin = equipementsMagasin.getTarget();
            equipementsMagasin.setTarget(new ArrayList<>());
        } else {
            displayInfoMessage("équipements non  retournés");
        }
        init();

    }

    public void printPdfPoste() throws JRException, IOException {
////        String filename = "restitutionPoste.pdf";
//        String jasperPath = "/pages/admin/restitution/retournerPoste.jasper";
////        PDF(null, jasperPath, equipementsretournesPoste, filename);
        String jasperPath = "/pages/admin/restitution/retournerPoste.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("bon", bonrestitutionP.getIdbonrestitution());
        parameters.put("nommagasin", magasin.getNommagasin());
        parameters.put("libelleposte", poste.getNomposte());
        Connection conn = Singleconnexion.getConnecter();
        String title = "retournerPoste";
        String chemin = "/pages/admin/restitution/";
        String sql = "select e.idequip, a.designation,e.dateacqui,e.coutacqui,m.nommarque,et.libelleetat,t.libelletyperetour from equipement e inner join article a on a.codearticle = e.codearticle "
                + " inner join etat et on et.idetat = e.idetat "
                + " inner join marque m on m.idmarque = e.idmarque "
                + " inner join bonrestitution b on b.idbonrestitution = e.idbonrestitution "
                + " inner join retourner r on r.idequip = e.idequip "
                + " inner join typeretour t on t.idtyperetour = r.idtyperetour where b.idbonrestitution ='" + bonrestitutionP.getIdbonrestitution() + "'and b.idposte = '" + poste.getIdposte() + "'";
        report(parameters, jasperPath, sql, chemin, title, conn);
    }

    public void printPdfMagasin() throws JRException, IOException {
//        String filename = "restitutionMagasin.pdf";
//        String jasperPath = "/pages/admin/equipements/reportBonEntree.jasper";
//        PDF(null, jasperPath, equipementsretournesMagasin, filename);
        String jasperPath = "/pages/admin/restitution/retournerMagasin.jrxml";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("bon", bonrestitution.getIdbonrestitution());
        parameters.put("nommagasin", magasin.getNommagasin());
        Connection conn = Singleconnexion.getConnecter();
        String title = "retournerMagasin";
        String chemin = "/pages/admin/restitution/";
        String sql = "select e.idequip, a.designation,e.dateacqui,e.coutacqui,m.nommarque,et.libelleetat,t.libelletyperetour from equipement e inner join article a on a.codearticle = e.codearticle "
                + " inner join etat et on et.idetat = e.idetat "
                + " inner join marque m on m.idmarque = e.idmarque "
                + " inner join bonrestitution b on b.idbonrestitution = e.idbonrestitution "
                + " inner join retourner r on r.idequip = e.idequip "
                + " inner join typeretour t on t.idtyperetour = r.idtyperetour where b.idbonrestitution ='" + bonrestitution.getIdbonrestitution() + "' and b.idcodemagasin = '" + magasin.getIdcodemagasin() + "'";
        report(parameters, jasperPath, sql, chemin, title, conn);
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

    // type de Retour
    public void createType() {
        try {
            type.setCreele(UtilisateurBean.date());
            type.setCreepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typeretourFacade.create(type);
            displayInfoMessage("type de Retour inseré");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInfoMessage("type de Retour non inseré");
        } finally {
            type = new Typeretour();
            init();
        }

    }

    public void deleteType(Typeretour sr) {
        try {
            typeretourFacade.remove(sr);
            displayInfoMessage("suppression effectuée avec succès");
        } catch (Exception e) {
            displayErrorMessage("erreur de suppression");
        } finally {
            init();
        }

    }

    public void updateType(RowEditEvent event) {
        Typeretour sr = ((Typeretour) event.getObject());
        try {
            sr.setModifiele(UtilisateurBean.date());
            sr.setModifiepar(UtilisateurBean.getUserConnecte().getLoginuser());
            typeretourFacade.edit(sr);
            displayInfoMessage("type de Retour édité " + sr.getIdtyperetour());
        } catch (Exception e) {
            displayErrorMessage("type de Retour non édité " + sr.getIdtyperetour());
        }
        init();
    }

    public void cancelledType() {
        displayInfoMessage("vous avez annulez");
    }
    //Bon

    public void createBonMagasin() {
        try {
            bonrestitution.setIdcodemagasin(magasin);
            bonrestitution.setValider("false");
            bonFacade.create(bonrestitution);
            displayInfoMessage("bon crée");
        } catch (Exception e) {
            displayInfoMessage("bon non crée");
        } finally {
            bonrestitution = new Bonrestitution();
            init();
        }
    }

    public void createBonPoste() {
        try {
            bonrestitutionP.setPoste(poste);
            bonrestitutionP.setValider("false");
            bonFacade.create(bonrestitutionP);
            displayInfoMessage("bon crée");
        } catch (Exception e) {
            displayInfoMessage("bon non crée");
        } finally {
            bonrestitutionP = new Bonrestitution();
            init();
        }
    }

    public void updateBon() {
        try {
            bonrestitution.setValider("true");
            bonFacade.edit(bonrestitution);
            displayInfoMessage("Bon " + bonrestitution.getLibellebonrestitution() + " validé avec succès");
        } catch (Exception e) {
            displayErrorMessage("Bon " + bonrestitution.getLibellebonrestitution() + " non validé");
        } finally {
            bonrestitution = new Bonrestitution();
            equipementsretournesMagasin = new ArrayList<>();
            equipementsretournesPoste = new ArrayList<>();
            init();
        }
    }

    public void updateBonPoste() {
        try {
            bonrestitutionP.setValider("true");
            bonFacade.edit(bonrestitutionP);
            displayInfoMessage("Bon " + bonrestitutionP.getLibellebonrestitution() + " validé avec succès");
        } catch (Exception e) {
            displayErrorMessage("Bon " + bonrestitutionP.getLibellebonrestitution() + " non validé");
        } finally {
            bonrestitutionP = new Bonrestitution();
            equipementsretournesMagasin = new ArrayList<>();
            equipementsretournesPoste = new ArrayList<>();
            init();
        }
    }

    public void updatebon() {
        bonrestitution = bonFacade.findByid(bonrestitution);
        init();
    }

    public void updatebonPoste() {
        bonrestitutionP = bonFacade.findByid(bonrestitutionP);
        init();
    }

    public Retourner getRetourner() {
        return retourner;
    }

    public Retourner getSelectedRetourner() {
        return selectedRetourner;
    }

    public Structure getStructureF() {
        return structureF;
    }

    public Typeretour getType() {
        return type;
    }

    public Typeretour getSelectedType() {
        return selectedType;
    }

    public List<Typeretour> getListeRetour() {
        return listeRetour;
    }

    public List<Retourner> getListe() {
        return liste;
    }

    public void setSelectedRetourner(Retourner selectedRetourner) {
        this.selectedRetourner = selectedRetourner;
    }

    public void setSelectedType(Typeretour selectedType) {
        this.selectedType = selectedType;
    }

    //retourner getter and setter
    public Equipement getEquipement() {
        return equipement;
    }

    public Structure getStructure() {
        return structure;
    }

    public Service getService() {
        return service;
    }

    public Postedetravail getPoste() {
        return poste;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public Magasin getMagasinD() {
        return magasinD;
    }

    public List<Equipement> getListeEquipBonPoste() {
        return listeEquipBonPoste;
    }

    public void setListeEquipBonPoste(List<Equipement> listeEquipBonPoste) {
        this.listeEquipBonPoste = listeEquipBonPoste;
    }

    public List<Equipement> getListeEquipBonTPoste() {
        return listeEquipBonTPoste;
    }

    public void setListeEquipBonTPoste(List<Equipement> listeEquipBonTPoste) {
        this.listeEquipBonTPoste = listeEquipBonTPoste;
    }

    public List<Equipement> getEquipementsretournesPoste() {
        return equipementsretournesPoste;
    }

    public void setEquipementsretournesPoste(List<Equipement> equipementsretournesPoste) {
        this.equipementsretournesPoste = equipementsretournesPoste;
    }

    public List<Equipement> getListeEquipBonMagasin() {
        return listeEquipBonMagasin;
    }

    public void setListeEquipBonMagasin(List<Equipement> listeEquipBonMagasin) {
        this.listeEquipBonMagasin = listeEquipBonMagasin;
    }

    public List<Equipement> getListeEquipBonTMagasin() {
        return listeEquipBonTMagasin;
    }

    public void setListeEquipBonTMagasin(List<Equipement> listeEquipBonTMagasin) {
        this.listeEquipBonTMagasin = listeEquipBonTMagasin;
    }

    public List<Equipement> getEquipementsretournesMagasin() {
        return equipementsretournesMagasin;
    }

    public void setEquipementsretournesMagasin(List<Equipement> equipementsretournesMagasin) {
        this.equipementsretournesMagasin = equipementsretournesMagasin;
    }

    public DualListModel<Equipement> getEquipementsPoste() {
        return equipementsPoste;
    }

    public void setEquipementsPoste(DualListModel<Equipement> equipementsPoste) {
        this.equipementsPoste = equipementsPoste;
    }

    public DualListModel<Equipement> getEquipementsMagasin() {
        return equipementsMagasin;
    }

    public void setEquipementsMagasin(DualListModel<Equipement> equipementsMagasin) {
        this.equipementsMagasin = equipementsMagasin;
    }

    public List<Bonrestitution> getListebonPoste() {
        return listebonPoste;
    }

    public List<Bonrestitution> getListebonMagasin() {
        return listebonMagasin;
    }

    public List<Bonrestitution> getListeBonAllPoste() {
        return listeBonAllPoste;
    }

    public List<Bonrestitution> getListeBonAllMagasin() {
        return listeBonAllMagasin;
    }

    public Bonrestitution getBonrestitution() {
        return bonrestitution;
    }

    public void setBonrestitution(Bonrestitution bonrestitution) {
        this.bonrestitution = bonrestitution;
    }

    public Typeretour getType1() {
        return type1;
    }

    public void setType1(Typeretour type1) {
        this.type1 = type1;
    }

    public List<Magasin> getMagasinPrincipal() {
        return MagasinPrincipal;
    }

    public void setMagasinPrincipal(List<Magasin> MagasinPrincipal) {
        this.MagasinPrincipal = MagasinPrincipal;
    }

    public Structure getStructureP() {
        return structureP;
    }

    public void setStructureP(Structure structureP) {
        this.structureP = structureP;
    }

    public Bonrestitution getBonrestitutionP() {
        return bonrestitutionP;
    }

    public void setBonrestitutionP(Bonrestitution bonrestitutionP) {
        this.bonrestitutionP = bonrestitutionP;
    }

}
