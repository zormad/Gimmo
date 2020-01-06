/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Annee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class AnneeFacade extends AbstractFacade<Annee> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnneeFacade() {
        super(Annee.class);
    }
    public Annee getAnnee(Annee annee){
        try{
            return (Annee) em.createNamedQuery("Annee.findByAnneeid").setParameter("anneeid", annee.getAnneeid()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
