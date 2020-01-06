package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Etat.class)
public abstract class Etat_ {

	public static volatile SingularAttribute<Etat, String> idetat;
	public static volatile SingularAttribute<Etat, String> creepar;
	public static volatile SingularAttribute<Etat, Date> modifiele;
	public static volatile CollectionAttribute<Etat, Equipement> equipementCollection;
	public static volatile SingularAttribute<Etat, String> libelleetat;
	public static volatile SingularAttribute<Etat, String> modifiepar;
	public static volatile SingularAttribute<Etat, Date> creele;

}

