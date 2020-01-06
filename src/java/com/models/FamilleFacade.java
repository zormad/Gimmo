/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Famille;
import com.entities.Groupe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class FamilleFacade extends AbstractFacade<Famille> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamilleFacade() {
        super(Famille.class);
    }
   public List<Famille> listeFamille(String idgroupe){idgroupe="MOB";
      return  em.createNamedQuery("Famille.findByGroupe").setParameter("idgroupe", idgroupe).getResultList();
    }
    public void delete(String id){
    em.createNamedQuery("Famille.delete").setParameter("id", id).executeUpdate();
    
}
    public List<Famille> changeGroupe(Groupe p){
        return (List<Famille>) em.createNamedQuery("Famille.findByGroupe").setParameter("code",p.getIdgroupe()).getResultList();
    }
}
