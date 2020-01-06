/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bonaffectation;
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
public class BonaffectationFacade extends AbstractFacade<Bonaffectation> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonaffectationFacade() {
        super(Bonaffectation.class);
    }

public Bonaffectation findByid(Bonaffectation bon){
        try{
            return (Bonaffectation) em.createNamedQuery("Bonaffectation.findByIdbonaffectation").setParameter("idbonaffectation", bon.getIdbonaffectation()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }    

public List<Bonaffectation> findByvalider(Postedetravail poste){
        try{
            return em.createNamedQuery("Bonaffectation.findByvalider").setParameter("valider", "false").setParameter("poste", poste.getIdposte()).getResultList();
        }catch(NoResultException e){
            return null;
        }
    }    
}
