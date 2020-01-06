package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bon.class)
public abstract class Bon_ {

	public static volatile SingularAttribute<Bon, String> valider;
	public static volatile SingularAttribute<Bon, String> creepar;
	public static volatile SingularAttribute<Bon, BigDecimal> numbon;
	public static volatile SingularAttribute<Bon, String> modifierpar;
	public static volatile SingularAttribute<Bon, Magasin> idcodemagasin;
	public static volatile SingularAttribute<Bon, String> libelle;
	public static volatile SingularAttribute<Bon, Date> modifierle;
	public static volatile SingularAttribute<Bon, Sourcedefinancement> idsource;
	public static volatile SingularAttribute<Bon, Fournisseur> idfournisseur;
	public static volatile SingularAttribute<Bon, Date> creele;

}

