package com.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Equipement.class)
public abstract class Equipement_ {

	public static volatile CollectionAttribute<Equipement, Affectation> affectationCollection;
	public static volatile SingularAttribute<Equipement, Etat> idetat;
	public static volatile SingularAttribute<Equipement, Bon> bon;
	public static volatile SingularAttribute<Equipement, BigDecimal> idequip;
	public static volatile SingularAttribute<Equipement, String> creepar;
	public static volatile SingularAttribute<Equipement, Bonrestitution> bonrestitution;
	public static volatile SingularAttribute<Equipement, Date> modifiele;
	public static volatile SingularAttribute<Equipement, Magasin> magasinEntre;
	public static volatile SingularAttribute<Equipement, Bonaffectation> bonaffectation;
	public static volatile CollectionAttribute<Equipement, Dotation> dotationCollection;
	public static volatile SingularAttribute<Equipement, Marque> idmarque;
	public static volatile SingularAttribute<Equipement, Date> dateacqui;
	public static volatile SingularAttribute<Equipement, Date> creele;
	public static volatile SingularAttribute<Equipement, BigInteger> coutacqui;
	public static volatile SingularAttribute<Equipement, BigInteger> coutcomptablenette;
	public static volatile SingularAttribute<Equipement, Magasin> magasinActuel;
	public static volatile SingularAttribute<Equipement, Bondotation> bondotation;
	public static volatile SingularAttribute<Equipement, Postedetravail> posteActuel;
	public static volatile SingularAttribute<Equipement, String> modifiepar;
	public static volatile SingularAttribute<Equipement, Article> codearticle;
	public static volatile CollectionAttribute<Equipement, Retourner> retournerCollection;
	public static volatile SingularAttribute<Equipement, String> statut;

}

