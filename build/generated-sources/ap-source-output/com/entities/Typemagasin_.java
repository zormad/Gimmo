package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Typemagasin.class)
public abstract class Typemagasin_ {

	public static volatile SingularAttribute<Typemagasin, String> idtypemag;
	public static volatile SingularAttribute<Typemagasin, String> creepar;
	public static volatile SingularAttribute<Typemagasin, Date> modifiele;
	public static volatile SingularAttribute<Typemagasin, String> libelletypemag;
	public static volatile CollectionAttribute<Typemagasin, Magasin> magasinCollection;
	public static volatile SingularAttribute<Typemagasin, String> modifiepar;
	public static volatile SingularAttribute<Typemagasin, Date> creele;

}

