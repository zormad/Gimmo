/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bon;
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
public class BonFacade extends AbstractFacade<Bon> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonFacade() {
        super(Bon.class);
    }
    public List<Bon> findByvalider(Magasin magasin){
        try{
            return em.createNamedQuery("Bon.findByvalider").setParameter("valider", "false").setParameter("magasin", magasin.getIdcodemagasin()).getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    public Bon findByid(Bon bon){
        try{
            return (Bon) em.createNamedQuery("Bon.findByNumbon").setParameter("numbon", bon.getNumbon()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
