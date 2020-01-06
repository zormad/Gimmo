package com.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Prestataire.class)
public abstract class Prestataire_ {

	public static volatile SingularAttribute<Prestataire, BigDecimal> idprestataire;
	public static volatile SingularAttribute<Prestataire, String> creepar;
	public static volatile CollectionAttribute<Prestataire, Sortie> sortieCollection;
	public static volatile SingularAttribute<Prestataire, Date> modifiele;
	public static volatile SingularAttribute<Prestataire, String> adresse;
	public static volatile SingularAttribute<Prestataire, BigInteger> tel;
	public static volatile SingularAttribute<Prestataire, String> fax;
	public static volatile SingularAttribute<Prestataire, String> modifiepar;
	public static volatile SingularAttribute<Prestataire, String> libelleprestataire;
	public static volatile SingularAttribute<Prestataire, Date> creele;
	public static volatile SingularAttribute<Prestataire, String> email;

}

