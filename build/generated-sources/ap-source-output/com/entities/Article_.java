package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ {

	public static volatile SingularAttribute<Article, String> creepar;
	public static volatile SingularAttribute<Article, Date> modifiele;
	public static volatile SingularAttribute<Article, Type> codetype;
	public static volatile CollectionAttribute<Article, Equipement> equipementCollection;
	public static volatile SingularAttribute<Article, String> designation;
	public static volatile CollectionAttribute<Article, Previsions> previsionsCollection;
	public static volatile SingularAttribute<Article, String> modifiepar;
	public static volatile SingularAttribute<Article, BigDecimal> codearticle;
	public static volatile SingularAttribute<Article, Date> creele;
	public static volatile CollectionAttribute<Article, Inventairemagasin> inventairemagasinCollection;

}

