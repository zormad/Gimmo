/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bonrestitution;
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
public class BonrestitutionFacade extends AbstractFacade<Bonrestitution> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonrestitutionFacade() {
        super(Bonrestitution.class);
    }

public Bonrestitution findByid(Bonrestitution bon){
        try{
            return (Bonrestitution) em.createNamedQuery("Bonrestitution.findByIdbonrestitution").setParameter("idbonrestitution", bon.getIdbonrestitution()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }  
 public List<Bonrestitution> findByvaliderMagasin(Magasin magasinS){
        try{
            return em.createNamedQuery("Bonrestitution.findByvaliderMagasin").setParameter("valider", "false").setParameter("magasin", magasinS.getIdcodemagasin()).getResultList();
        }catch(NoResultException e){
            return null;
        }
    } 
    public List<Bonrestitution> findByvaliderPoste(Postedetravail poste){
        try{
            return em.createNamedQuery("Bonrestitution.findByvaliderPoste").setParameter("valider", "false").setParameter("poste", poste.getIdposte()).getResultList();
        }catch(NoResultException e){
            return null;
        }
    } 
}
