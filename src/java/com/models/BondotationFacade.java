/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Bondotation;
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
public class BondotationFacade extends AbstractFacade<Bondotation> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BondotationFacade() {
        super(Bondotation.class);
    }
public List<Bondotation> findByvalider(Magasin magasin){
        try{
            return em.createNamedQuery("Bondotation.findByvalider").setParameter("valider", "false").setParameter("magasin", magasin.getIdcodemagasin()).getResultList();
        }catch(NoResultException e){
            return null;
        }
    }    

    public Bondotation findByid(Bondotation bon){
        try{
            return (Bondotation) em.createNamedQuery("Bondotation.findByIdbondotation").setParameter("idbondotation", bon.getIdbondotation()).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

}
