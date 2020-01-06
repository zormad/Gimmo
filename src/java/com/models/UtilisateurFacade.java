/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Utilisateur;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    //chercher en fonction de l'id
    public Utilisateur findByLogin(String login) {
        try {
            return createNamedQuery("Utilisateur.findByLoginuser").setParameter("loginuser", login).getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    public BigDecimal findByLogin(String login,String password) {
        try {
            return   (BigDecimal) em.createNativeQuery("SELECT iduser FROM Utilisateur  WHERE loginuser = '"+login+"' AND loginpasswd = hash_key('"+password+"')").getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    public String passwd_hash(String passwd){
        return (String) em.createNativeQuery("select hash_key('"+passwd+"') from dual").getSingleResult();
    }
    public void hash_passwd(Utilisateur utilisateur) throws Throwable{
        try{
            em.createNativeQuery("update Utilisateur set loginpasswd=hash_key('"+utilisateur.getLoginpasswd()+"') where loginuser='"+utilisateur.getLoginuser()+"'").executeUpdate();
        }catch(Exception e){
            throw e.getCause();
        }
    }

    //chercher en fonction de l'id
    public Utilisateur findByIdUser(BigDecimal id) {
        try {
            return createNamedQuery("Utilisateur.findByIduser").setParameter("iduser", id).getSingleResult();
        } catch (NoResultException e) {
            return null;

        }
    }

    //chercher en fonction de la date de creation
    public Utilisateur findByCreeLe(Date creeLe) {
        try {
            return createNamedQuery("Utilisateur.findByCreeLe").setParameter("CreeLe", creeLe).getSingleResult();

        } catch (NoResultException e) {
            return null;

        }
    }
    //chercher en fonction de de la personne qui a créee

    public Utilisateur findByCreePar(String creePar) {
        try {
            return createNamedQuery("Utilisateur.findByCreePar").setParameter("CreePar", creePar).getSingleResult();
        } catch (NoResultException e) {
            return null;

        }
    }
    //chercher en fonction de la date de modification

    public Utilisateur findByModifieLe(Date modifieLe) {
        try {
            return createNamedQuery("Utilisateur.findByModifieLe").setParameter("modifieLe", modifieLe).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    //chercher en fonction de de la personne qui a modifiée

    public Utilisateur findByModifiePar(String modifiePar) {
        try {
            return createNamedQuery("Utilisateur.findByModifiePar").setParameter("modifiePar", modifiePar).getSingleResult();

        } catch (NoResultException e) {
            return null;

        }
    }

}
