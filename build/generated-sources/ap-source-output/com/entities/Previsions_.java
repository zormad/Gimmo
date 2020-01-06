package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Previsions.class)
public abstract class Previsions_ {

	public static volatile SingularAttribute<Previsions, String> creepar;
	public static volatile SingularAttribute<Previsions, Date> modifiele;
	public static volatile SingularAttribute<Previsions, PrevisionsPK> previsionsPK;
	public static volatile SingularAttribute<Previsions, String> modifiepar;
	public static volatile SingularAttribute<Previsions, Date> creele;
	public static volatile SingularAttribute<Previsions, Article> article;
	public static volatile SingularAttribute<Previsions, Structure> structure;
	public static volatile SingularAttribute<Previsions, BigInteger> quantite;

}

