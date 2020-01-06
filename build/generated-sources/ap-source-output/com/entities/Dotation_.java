package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dotation.class)
public abstract class Dotation_ {

	public static volatile SingularAttribute<Dotation, Date> datedotation;
	public static volatile SingularAttribute<Dotation, String> creepar;
	public static volatile SingularAttribute<Dotation, BigDecimal> iddotation;
	public static volatile SingularAttribute<Dotation, Date> modifiele;
	public static volatile SingularAttribute<Dotation, Equipement> equipement;
	public static volatile SingularAttribute<Dotation, String> codeequip;
	public static volatile SingularAttribute<Dotation, String> modifiepar;
	public static volatile SingularAttribute<Dotation, Magasin> magasin;
	public static volatile SingularAttribute<Dotation, Date> creele;

}

