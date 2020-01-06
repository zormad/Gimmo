package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Famille.class)
public abstract class Famille_ {

	public static volatile SingularAttribute<Famille, String> creepar;
	public static volatile SingularAttribute<Famille, Date> modifiele;
	public static volatile SingularAttribute<Famille, Groupe> idgroupe;
	public static volatile SingularAttribute<Famille, String> modifiepar;
	public static volatile SingularAttribute<Famille, Date> creele;
	public static volatile SingularAttribute<Famille, String> codefamille;
	public static volatile SingularAttribute<Famille, String> nomfamille;
	public static volatile ListAttribute<Famille, Type> typeCollection;

}

