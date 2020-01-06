/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Famille;
import com.entities.Type;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class TypeFacade extends AbstractFacade<Type> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeFacade() {
        super(Type.class);
    }
  
     public void delete(String id){
    em.createNamedQuery("Type.delete").setParameter("id", id).executeUpdate();
    
}
     public List<Type> changeGroupe(Famille f){
        return (List<Type>) em.createNamedQuery("Type.findFamille").setParameter("code",f.getCodefamille()).getResultList();
    }
}
