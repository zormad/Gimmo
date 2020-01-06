package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inventairestructure.class)
public abstract class Inventairestructure_ {

	public static volatile SingularAttribute<Inventairestructure, String> creepar;
	public static volatile SingularAttribute<Inventairestructure, Date> dateinv;
	public static volatile SingularAttribute<Inventairestructure, Date> modifiele;
	public static volatile SingularAttribute<Inventairestructure, String> modifiepar;
	public static volatile SingularAttribute<Inventairestructure, Date> creele;
	public static volatile SingularAttribute<Inventairestructure, Structure> structure;
	public static volatile SingularAttribute<Inventairestructure, BigInteger> idinventaire;
	public static volatile SingularAttribute<Inventairestructure, BigInteger> quantite;

}

