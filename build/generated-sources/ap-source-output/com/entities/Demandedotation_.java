package com.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Demandedotation.class)
public abstract class Demandedotation_ {

	public static volatile SingularAttribute<Demandedotation, BigDecimal> iddemande;
	public static volatile SingularAttribute<Demandedotation, Date> datedemande;
	public static volatile SingularAttribute<Demandedotation, Bondemande> bondemande;
	public static volatile SingularAttribute<Demandedotation, Article> article;
	public static volatile SingularAttribute<Demandedotation, BigInteger> quantite;

}

