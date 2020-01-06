/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Sortie;
import com.entities.Typedesortie;
import java.math.BigDecimal;
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
public class SortieFacade extends AbstractFacade<Sortie> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SortieFacade() {
        super(Sortie.class);
    }

    public void delete(BigDecimal id) {
        em.createNamedQuery("Sortie.delete").setParameter("id", id).executeUpdate();

    }
    public List<Sortie> typSorties(Typedesortie type) {
       try{
          return em.createNamedQuery("Sortie.findBytypesortie").setParameter("typesortie", type.getIdtypesortie()).getResultList();
       }catch(NoResultException e){
           return null;
       }
    }
     public List<Sortie> reparationValider() {
       try{
          return em.createNamedQuery("Sortie.findBytypesortieValider").setParameter("typesortie", "repare").setParameter("valider", "true").getResultList();
       }catch(NoResultException e){
           return null;
       }
     }
     public List<Sortie> missionValider() {
       try{
          return em.createNamedQuery("Sortie.findBytypesortieValider").setParameter("typesortie", "mssion").setParameter("valider", "true").getResultList();
       }catch(NoResultException e){
           return null;
       }
     }
    public int updateValider(Sortie sortie){
        return em.createNativeQuery("Update sortie set valider ='"+"true"+"' where idsortie= '"+sortie.getIdsortie()+"'").executeUpdate();
    }
}
