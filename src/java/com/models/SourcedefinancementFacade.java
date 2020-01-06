/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Sourcedefinancement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class SourcedefinancementFacade extends AbstractFacade<Sourcedefinancement> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SourcedefinancementFacade() {
        super(Sourcedefinancement.class);
    }
    
}
