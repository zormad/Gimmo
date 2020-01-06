package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inventairemagasin.class)
public abstract class Inventairemagasin_ {

	public static volatile SingularAttribute<Inventairemagasin, BigInteger> idinv;
	public static volatile SingularAttribute<Inventairemagasin, String> creepar;
	public static volatile SingularAttribute<Inventairemagasin, Date> dateinv;
	public static volatile SingularAttribute<Inventairemagasin, Date> modifiele;
	public static volatile SingularAttribute<Inventairemagasin, String> modifiepar;
	public static volatile SingularAttribute<Inventairemagasin, Magasin> magasin;
	public static volatile SingularAttribute<Inventairemagasin, Date> creele;
	public static volatile SingularAttribute<Inventairemagasin, Article> article;
	public static volatile SingularAttribute<Inventairemagasin, BigInteger> quantite;

}

