/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Equipement;
import com.entities.Equipementreparation;
import com.entities.Equipementsortis;
import com.entities.Sortie;
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
public class EquipementsortisFacade extends AbstractFacade<Equipementsortis> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipementsortisFacade() {
        super(Equipementsortis.class);
    }

    public List<Equipement> equipementsortis(Sortie sortie) {
        try {
            return em.createNamedQuery("Equipementsortis.findBySortie").setParameter("idsortie", sortie.getIdsortie()).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public BigDecimal getEquipementReparation(Equipementsortis equipementsortis) {
        try {
            return (BigDecimal) em.createNativeQuery("select idreparation from equipementsortis where idequipsorti='" + equipementsortis.getIdequipsorti() + "'").getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public int setReparation(Equipementreparation equipementreparation, Equipementsortis equipementsortis) {
        return em.createNativeQuery("update equipementsortis set idreparation ='" + equipementreparation.getIdreparation() + "' where idequipsorti='" + equipementsortis.getIdequipsorti() + "'").executeUpdate();
    }

    public List<?> liste(Sortie sortie) {
        String sql = "select a.designation as DESIGNATION ,m.nommarque as NONMARQUE,et.libelleetat as LIBELLEETAT,e.idequip as IDEQUIP from equipementsortis es inner join equipement e on e.idequip=es.idequip "
                + "           inner join sortie s on s.idsortie=es.idsortie "
                + "inner join article a on a.codearticle=e.codearticle "
                + "inner join marque m on m.idmarque=e.idmarque "
                + "inner join etat et on et.idetat=e.idetat "
                + "where s.idsortie='" + sortie.getIdsortie() + "'";
        try {
            return (List<Object>) em.createNativeQuery(sql).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
