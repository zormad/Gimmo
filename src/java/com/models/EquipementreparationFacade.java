/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Equipementreparation;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class EquipementreparationFacade extends AbstractFacade<Equipementreparation> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipementreparationFacade() {
        super(Equipementreparation.class);
    }
   public Equipementreparation getEquipementreparation(BigDecimal idreparation){
       try{
           return (Equipementreparation) em.createNamedQuery("Equipementreparation.findByIdreparation").setParameter("idreparation", idreparation).getSingleResult();
       }catch(NoResultException e){
           return null;
       }
   } 
}
