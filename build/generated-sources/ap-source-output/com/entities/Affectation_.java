package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Affectation.class)
public abstract class Affectation_ {

	public static volatile SingularAttribute<Affectation, Date> dateaffectation;
	public static volatile SingularAttribute<Affectation, Postedetravail> postedetravail;
	public static volatile SingularAttribute<Affectation, String> creepar;
	public static volatile SingularAttribute<Affectation, Date> modifiele;
	public static volatile SingularAttribute<Affectation, Equipement> equipement;
	public static volatile SingularAttribute<Affectation, String> codeequip;
	public static volatile SingularAttribute<Affectation, BigDecimal> idbonaffectation;
	public static volatile SingularAttribute<Affectation, Date> datefin;
	public static volatile SingularAttribute<Affectation, String> modifiepar;
	public static volatile SingularAttribute<Affectation, Date> creele;
	public static volatile SingularAttribute<Affectation, BigDecimal> statut;

}

