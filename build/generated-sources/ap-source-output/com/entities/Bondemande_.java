package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bondemande.class)
public abstract class Bondemande_ {

	public static volatile SingularAttribute<Bondemande, String> valider;
	public static volatile SingularAttribute<Bondemande, String> creepar;
	public static volatile SingularAttribute<Bondemande, BigDecimal> idbondemande;
	public static volatile CollectionAttribute<Bondemande, Demandedotation> demandeCollection;
	public static volatile SingularAttribute<Bondemande, Magasin> magasin;
	public static volatile SingularAttribute<Bondemande, Date> creele;

}

