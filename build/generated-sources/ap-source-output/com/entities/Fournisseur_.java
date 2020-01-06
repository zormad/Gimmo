package com.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fournisseur.class)
public abstract class Fournisseur_ {

	public static volatile SingularAttribute<Fournisseur, String> creepar;
	public static volatile SingularAttribute<Fournisseur, Date> modifiele;
	public static volatile CollectionAttribute<Fournisseur, Bon> bonCollection;
	public static volatile SingularAttribute<Fournisseur, String> adresse;
	public static volatile SingularAttribute<Fournisseur, String> libellefournisseur;
	public static volatile SingularAttribute<Fournisseur, BigInteger> tel;
	public static volatile SingularAttribute<Fournisseur, BigDecimal> idfournisseur;
	public static volatile SingularAttribute<Fournisseur, String> fax;
	public static volatile SingularAttribute<Fournisseur, String> modifiepar;
	public static volatile SingularAttribute<Fournisseur, Date> creele;
	public static volatile SingularAttribute<Fournisseur, String> email;

}

