package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Occupation.class)
public abstract class Occupation_ {

	public static volatile SingularAttribute<Occupation, Postedetravail> postedetravail;
	public static volatile SingularAttribute<Occupation, String> creepar;
	public static volatile SingularAttribute<Occupation, Agent> agent;
	public static volatile SingularAttribute<Occupation, Date> modifiele;
	public static volatile SingularAttribute<Occupation, Date> datedebut;
	public static volatile SingularAttribute<Occupation, Date> datefin;
	public static volatile SingularAttribute<Occupation, String> modifiepar;
	public static volatile SingularAttribute<Occupation, Date> creele;
	public static volatile SingularAttribute<Occupation, BigInteger> statut;

}

