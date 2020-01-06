/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Magasin;
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
public class MagasinFacade extends AbstractFacade<Magasin> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagasinFacade() {
        super(Magasin.class);
    }

    public void delete(String id) {
        em.createNamedQuery("Magasin.delete").setParameter("id", id).executeUpdate();

    }

    public List<Magasin> MagasinPrincipal() {
        try {
            return (List<Magasin>) em.createNamedQuery("Magasin.findPrincipal").setParameter("type", "prim").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Magasin> MagasinSecondaire() {
        try {
            return (List<Magasin>) em.createNamedQuery("Magasin.findPrincipal").setParameter("type", "second").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Magasin getMagasin(Magasin m) {
        try {
            return (Magasin) em.createNamedQuery("Magasin.findByIdcodemagasin").setParameter("idcodemagasin", m.getIdcodemagasin()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public int createViews(Structure structure) {
        if (em.createNativeQuery("create or replace VIEW view_previsions "
                + " as select to_char(p.creele,'yyyy') as annee,ar.designation,p.quantite,s.libellestructure from previsions p inner join structure s on s.codestructure = p.codestructure inner join article ar on ar.codearticle= p.codearticle where p.codestructure = '"+structure.getCodestructure()+"'").executeUpdate()
                > 0) {
             em.createNativeQuery("create or replace VIEW view_besoins "
                    + "as select a.designation,count(*) as dotation from article a inner join equipement e on e.codearticle = a.codearticle "
                    + " where e.posteactuel in(select p.idposte from postedetravail p inner join affectation af on af.idposte = p.idposte "
                    + " where to_char(af.creele,'yyyy')=2018 "
                    + " group by p.idposte,af.creele  "
                    + " having af.creele = max(af.creele ) ) or e.magasinactuel in(select m.idcodemagasin from magasin m inner join dotation d on d.idcodemagasin = m.idcodemagasin "
                    + " where to_char(d.creele,'yyyy')=2018 "
                    + " group by m.idcodemagasin,d.creele "
                    + " having d.creele=max(d.creele) and m.codestructure = '"+structure.getCodestructure()+"' ) "
                    + "group by a.designation").executeUpdate();
        }
        return 1;
    }
    public List executeNativeQuery(String sql){
        try{
           return em.createNativeQuery(sql).getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
//public List<Magasin> findByStructure(String id){
//    try {
//         return (List<Magasin>)em.createNamedQuery("Magasin.findByStructure").setParameter("code", id).getResultList();
//    } catch (NoResultException e) {
//        return null;
//    }
//    
//}
}
