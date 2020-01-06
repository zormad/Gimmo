package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bonrestitution.class)
public abstract class Bonrestitution_ {

	public static volatile SingularAttribute<Bonrestitution, BigDecimal> idbonrestitution;
	public static volatile SingularAttribute<Bonrestitution, String> libellebonrestitution;
	public static volatile SingularAttribute<Bonrestitution, String> valider;
	public static volatile SingularAttribute<Bonrestitution, String> creepar;
	public static volatile SingularAttribute<Bonrestitution, Date> modifiele;
	public static volatile SingularAttribute<Bonrestitution, Magasin> idcodemagasin;
	public static volatile SingularAttribute<Bonrestitution, Postedetravail> poste;
	public static volatile SingularAttribute<Bonrestitution, String> modifiepar;
	public static volatile SingularAttribute<Bonrestitution, Date> creele;

}

