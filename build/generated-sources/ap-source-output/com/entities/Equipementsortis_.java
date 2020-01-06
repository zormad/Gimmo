package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Equipementsortis.class)
public abstract class Equipementsortis_ {

	public static volatile SingularAttribute<Equipementsortis, String> creepar;
	public static volatile SingularAttribute<Equipementsortis, Date> modifiele;
	public static volatile SingularAttribute<Equipementsortis, Equipement> equipement;
	public static volatile SingularAttribute<Equipementsortis, Sortie> sortie;
	public static volatile SingularAttribute<Equipementsortis, BigDecimal> idequipsorti;
	public static volatile CollectionAttribute<Equipementsortis, Equipementreparation> equipementreparationCollection;
	public static volatile SingularAttribute<Equipementsortis, String> modifiepar;
	public static volatile SingularAttribute<Equipementsortis, Date> creele;

}

