/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Annee;
import com.entities.Besoins;
import com.entities.Service;
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
public class BesoinsFacade extends AbstractFacade<Besoins> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BesoinsFacade() {
        super(Besoins.class);
    }

//    public List<Integer> Annee(Structure structure) {
//        try {
//            return em.createNativeQuery("select b.anneebesoin from besoins b inner join service s on s.codeservice=b.codeservice where s.codestructure ='" + structure.getCodestructure() + "'").getResultList();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }

//    public List<Besoins> listebBesoinses(Structure structure, int date) {
//        try {
//            return em.createNamedQuery("Besoins.findByAnneeStructure").setParameter("codestructure", structure.getCodestructure()).setParameter("anneeBesoin", date).getResultList();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }
    public List<Besoins> listeBesoinsParService(Service service,Annee annee){
        try {
          return em.createNamedQuery("Besoins.findByServiceAnnee").setParameter("anneebesoin", annee.getAnneeid()).setParameter("codeservice", service.getCodeservice()).getResultList();
       
        } catch (NoResultException e) {
            return null;
        }
     
}
}
