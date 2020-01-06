package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Marque.class)
public abstract class Marque_ {

	public static volatile SingularAttribute<Marque, String> nommarque;
	public static volatile SingularAttribute<Marque, String> creepar;
	public static volatile SingularAttribute<Marque, Date> modifiele;
	public static volatile CollectionAttribute<Marque, Equipement> equipementCollection;
	public static volatile SingularAttribute<Marque, String> idmarque;
	public static volatile SingularAttribute<Marque, String> modifiepar;
	public static volatile SingularAttribute<Marque, Date> creele;

}

