package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Retourner.class)
public abstract class Retourner_ {

	public static volatile SingularAttribute<Retourner, String> libelleretourner;
	public static volatile SingularAttribute<Retourner, String> creepar;
	public static volatile SingularAttribute<Retourner, Date> modifiele;
	public static volatile SingularAttribute<Retourner, Equipement> equipement;
	public static volatile SingularAttribute<Retourner, BigInteger> idretourner;
	public static volatile SingularAttribute<Retourner, Date> dateretourner;
	public static volatile SingularAttribute<Retourner, Typeretour> idtyperetour;
	public static volatile SingularAttribute<Retourner, String> positioninitial;
	public static volatile SingularAttribute<Retourner, String> modifiepar;
	public static volatile SingularAttribute<Retourner, Magasin> magasin;
	public static volatile SingularAttribute<Retourner, Date> creele;

}

