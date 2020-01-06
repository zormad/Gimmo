package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agentcat.class)
public abstract class Agentcat_ {

	public static volatile SingularAttribute<Agentcat, String> creepar;
	public static volatile SingularAttribute<Agentcat, Agent> agent;
	public static volatile SingularAttribute<Agentcat, Categorie> categorie;
	public static volatile SingularAttribute<Agentcat, BigInteger> dateaff;
	public static volatile SingularAttribute<Agentcat, String> modifierpar;
	public static volatile SingularAttribute<Agentcat, Date> modifierle;
	public static volatile SingularAttribute<Agentcat, Date> creele;

}

