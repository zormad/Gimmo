package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Besoins.class)
public abstract class Besoins_ {

	public static volatile SingularAttribute<Besoins, BesoinsPK> besoinsPK;
	public static volatile SingularAttribute<Besoins, String> creepar;
	public static volatile SingularAttribute<Besoins, Date> modifiele;
	public static volatile SingularAttribute<Besoins, Service> service;
	public static volatile SingularAttribute<Besoins, String> modifiepar;
	public static volatile SingularAttribute<Besoins, Date> creele;
	public static volatile SingularAttribute<Besoins, Article> article;
	public static volatile SingularAttribute<Besoins, BigInteger> quantite;

}

