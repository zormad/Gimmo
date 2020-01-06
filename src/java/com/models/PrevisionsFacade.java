/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Annee;
import com.entities.Previsions;
import com.entities.Structure;
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
public class PrevisionsFacade extends AbstractFacade<Previsions> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrevisionsFacade() {
        super(Previsions.class);
    }
    public List<Previsions> listeBesoinsParStructure(Structure structure,Annee annee){
        try {
          return em.createNamedQuery("Previsions.findByStructureAnnee").setParameter("anneeprevision", annee.getAnneeid()).setParameter("codestructure", structure.getCodestructure()).getResultList();
       
        } catch (NoResultException e) {
            return null;
        }
     
}
}
