/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Article;
import com.entities.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZORE
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "gimmo3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
   
    public void delete(BigDecimal id){
    em.createNamedQuery("Article.delete").setParameter("id", id).executeUpdate();
    
}
     public List<Article> changeGroupe(Type t){
        return (List<Article>) em.createNamedQuery("Article.findType").setParameter("code",t.getCodetype()).getResultList();
    }
     public Article getArticle(Article a){
         return (Article) em.createNamedQuery("Article.findByCodearticle").setParameter("codearticle", a.getCodearticle()).getSingleResult();
     }
}
