/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bondemande;
import com.entities.Magasin;
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
public class BondemandeFacade extends AbstractFacade<Bondemande> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BondemandeFacade() {
        super(Bondemande.class);
    }
public List<Bondemande> listeDesBons(Magasin magasin){
   try{
       return em.createNamedQuery("Bondemande.findDemande").setParameter("idcodemagasin", magasin.getIdcodemagasin()).getResultList();
   }catch(NoResultException e){
      return  null;
   }
}  

public List<Bondemande> listeBonNonValides(){
   try{
       return em.createNamedQuery("Bondemande.findAllValider").setParameter("valider", "false").getResultList();
   }catch(NoResultException e){
      return  null;
   }
}

public Bondemande getBondemande(Bondemande bondemande){
   try{
       return (Bondemande) em.createNamedQuery("Bonaffectation.findByIdbonaffectation").setParameter("idbonaffectation", bondemande.getIdbondemande()).getSingleResult();
   }catch(NoResultException e){
       return null;
   }
}
}
