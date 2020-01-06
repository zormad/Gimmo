package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Postedetravail.class)
public abstract class Postedetravail_ {

	public static volatile CollectionAttribute<Postedetravail, Affectation> affectationCollection;
	public static volatile SingularAttribute<Postedetravail, String> creepar;
	public static volatile SingularAttribute<Postedetravail, Date> modifiele;
	public static volatile SingularAttribute<Postedetravail, Service> service;
	public static volatile CollectionAttribute<Postedetravail, Occupation> occupationCollection;
	public static volatile SingularAttribute<Postedetravail, String> nomposte;
	public static volatile SingularAttribute<Postedetravail, BigDecimal> idposte;
	public static volatile SingularAttribute<Postedetravail, String> modifiepar;
	public static volatile SingularAttribute<Postedetravail, Date> creele;

}

