package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sourcedefinancement.class)
public abstract class Sourcedefinancement_ {

	public static volatile SingularAttribute<Sourcedefinancement, String> creepar;
	public static volatile SingularAttribute<Sourcedefinancement, Date> modifiele;
	public static volatile CollectionAttribute<Sourcedefinancement, Bon> bonCollection;
	public static volatile SingularAttribute<Sourcedefinancement, BigDecimal> idsource;
	public static volatile SingularAttribute<Sourcedefinancement, String> modifiepar;
	public static volatile SingularAttribute<Sourcedefinancement, String> libellesource;
	public static volatile SingularAttribute<Sourcedefinancement, Date> creele;

}

