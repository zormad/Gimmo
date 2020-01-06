/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Postedetravail;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class PostedetravailFacade extends AbstractFacade<Postedetravail> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    public PostedetravailFacade() {
    super(Postedetravail.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    public Postedetravail getPostedetravail(Postedetravail poste){
        try{
            return (Postedetravail) em.createNamedQuery("Postedetravail.findByIdposte").setParameter("idposte", poste.getIdposte()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
