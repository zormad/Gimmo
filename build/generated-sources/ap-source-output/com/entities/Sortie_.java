package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sortie.class)
public abstract class Sortie_ {

	public static volatile SingularAttribute<Sortie, String> valider;
	public static volatile SingularAttribute<Sortie, String> creepar;
	public static volatile SingularAttribute<Sortie, Prestataire> idprestataire;
	public static volatile SingularAttribute<Sortie, Date> datesortie;
	public static volatile SingularAttribute<Sortie, Date> modifiele;
	public static volatile SingularAttribute<Sortie, BigDecimal> idsortie;
	public static volatile SingularAttribute<Sortie, Date> creele;
	public static volatile SingularAttribute<Sortie, String> descriptionsortie;
	public static volatile SingularAttribute<Sortie, Agent> idagent;
	public static volatile SingularAttribute<Sortie, Date> dateretour;
	public static volatile SingularAttribute<Sortie, String> libellesortie;
	public static volatile SingularAttribute<Sortie, Typedesortie> idtypesortie;
	public static volatile SingularAttribute<Sortie, Date> dateprevuretour;
	public static volatile CollectionAttribute<Sortie, Equipementsortis> equipementsortisCollection;
	public static volatile SingularAttribute<Sortie, String> modifiepar;

}

