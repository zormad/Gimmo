package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Groupe.class)
public abstract class Groupe_ {

	public static volatile SingularAttribute<Groupe, String> creepar;
	public static volatile SingularAttribute<Groupe, Date> modifiele;
	public static volatile SingularAttribute<Groupe, String> idgroupe;
	public static volatile SingularAttribute<Groupe, String> modifiepar;
	public static volatile SingularAttribute<Groupe, String> nomgroupe;
	public static volatile SingularAttribute<Groupe, Date> creele;
	public static volatile CollectionAttribute<Groupe, Famille> familleCollection;

}

