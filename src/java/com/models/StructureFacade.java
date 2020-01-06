/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

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
public class StructureFacade extends AbstractFacade<Structure> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StructureFacade() {
        super(Structure.class);
    }

    public void delete(String code) {
        em.createNamedQuery("Structure.delete").setParameter("codestructure", code).executeUpdate();

    }
//public List<Structure> findStrucP(){
//    return em.createNamedQuery("Structure.findAllP").getResultList();
//}
//public List<Structure> findStrucS(){
//    return em.createNamedQuery("Structure.findAllS").getResultList();
//}

    public Structure findBycodeStructure(Structure structure) {
        try {
            return (Structure) em.createNamedQuery("Structure.findByCodestructure").setParameter("codestructure", structure.getCodestructure()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
