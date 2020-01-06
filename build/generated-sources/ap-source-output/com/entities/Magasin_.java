package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Magasin.class)
public abstract class Magasin_ {

	public static volatile SingularAttribute<Magasin, Typemagasin> idtypemag;
	public static volatile SingularAttribute<Magasin, String> creepar;
	public static volatile SingularAttribute<Magasin, Date> modifiele;
	public static volatile CollectionAttribute<Magasin, Bon> bonCollection;
	public static volatile CollectionAttribute<Magasin, Dotation> dotationCollection;
	public static volatile SingularAttribute<Magasin, String> idcodemagasin;
	public static volatile SingularAttribute<Magasin, Structure> codestructure;
	public static volatile SingularAttribute<Magasin, String> modifiepar;
	public static volatile SingularAttribute<Magasin, Date> creele;
	public static volatile CollectionAttribute<Magasin, Retourner> retournerCollection;
	public static volatile CollectionAttribute<Magasin, Inventairemagasin> inventairemagasinCollection;
	public static volatile SingularAttribute<Magasin, String> nommagasin;

}

