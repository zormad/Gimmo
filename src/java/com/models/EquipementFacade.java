/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bon;
import com.entities.Bonaffectation;
import com.entities.Bondotation;
import com.entities.Bonrestitution;
import com.entities.Equipement;
import com.entities.Magasin;
import com.entities.Postedetravail;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class EquipementFacade extends AbstractFacade<Equipement> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipementFacade() {
        super(Equipement.class);
    }

    public List listeEquipBon(Bon bon) {
//         "
//                + ", "
//                + " "

//                + " "
        //               + " where e.bon.numbon in (select b.numbon from Bon b where b.numbon = :bon)"
//                + " "
//                + " "
//                + "  ,"
        return em.createNativeQuery("select count(*) as quantite,sum(e.coutacqui)*count(*) as couttotal,"
                + " a.codearticle as codearticle,a.designation as designation,m.nommarque as marque,e.coutacqui as cout"
                + " from Equipement e inner join Marque m on e.idmarque=m.idmarque "
                + "inner join Article a on a.codearticle =e.codearticle "
                + "group by e.coutacqui, a.codearticle,a.designation,m.nommarque,e.numbon "
        ).getResultList();//
    }
  public List listeEquipBondotation(Bondotation bondotation) {
        return em.createNamedQuery("Equipement.findByBondotation" ).setParameter("idbondotation", bondotation.getIdbondotation()).getResultList();//
    }
    public List listeEquipBonaffectation(Bonaffectation bonaffectation) {
        return em.createNamedQuery("Equipement.findByBonaffectation" ).setParameter("idbonaffectation", bonaffectation.getIdbonaffectation()).getResultList();//
    }
      public List listeEquipBonrestitution(Bonrestitution bonrestitution) {
        return em.createNamedQuery("Equipement.findByBonrestitution" ).setParameter("idbonrestitution", bonrestitution.getIdbonrestitution()).getResultList();//
    }
      

    public List<Equipement> findByIdequip(Equipement equipement, Magasin magasin) {
        return em.createNamedQuery("Equipement.findByIdequip").setParameter("magasin", magasin.getIdcodemagasin()).setParameter("idequip", equipement.getIdequip()).getResultList();
    }

    public List<Equipement> findByBon(Bon bon) {
        return (List<Equipement>) em.createNamedQuery("Equipement.findByBon").setParameter("bon", bon.getNumbon()).getResultList();
    }
    //dotation

    public List<Equipement> findByMagasinActuel(Magasin magasin) {
        return (List<Equipement>) em.createNamedQuery("Equipement.findByMagasinActuel").setParameter("valider", "true").setParameter("magasin", magasin.getIdcodemagasin()).getResultList();
    }
    public int update(Equipement equipement) throws Throwable{
       try{
         return em.createNativeQuery("update equipement set idbonrestitution='"+equipement.getBonrestitution().getIdbonrestitution()+"' where idequip='"+equipement.getIdequip()+"'").executeUpdate();
       
       }catch(Exception e){
           return 0;
       }
    }
    public List<Equipement> findByPosteActuel(Postedetravail poste) {
        return (List<Equipement>) em.createNamedQuery("Equipement.findByPosteActuel").setParameter("poste", poste.getIdposte()).getResultList();
    }
    public List<Equipement> listeAll(){
        try{
            return em.createNamedQuery("Equipement.findAllActif").setParameter("statut", "actif").getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    public Equipement getEquipement(Equipement equipement){
        try{
            return (Equipement) em.createNamedQuery("Equipement.findByIdequip").setParameter("idequip", equipement.getIdequip()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    public int updateStatut(Equipement equipement){
      return  em.createNativeQuery("Update equipement set statut = '"+equipement.getStatut()+"' where idequip ='"+equipement.getIdequip()+"'").executeUpdate();
    }
}
