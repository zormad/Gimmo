package com.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Affectationutilisateur.class)
public abstract class Affectationutilisateur_ {

	public static volatile SingularAttribute<Affectationutilisateur, Date> dateaffectation;
	public static volatile SingularAttribute<Affectationutilisateur, String> creepar;
	public static volatile SingularAttribute<Affectationutilisateur, Agent> agent;
	public static volatile SingularAttribute<Affectationutilisateur, Date> modifiele;
	public static volatile SingularAttribute<Affectationutilisateur, Utilisateur> utilisateur;
	public static volatile SingularAttribute<Affectationutilisateur, Date> datefin;
	public static volatile SingularAttribute<Affectationutilisateur, String> modifiepar;
	public static volatile SingularAttribute<Affectationutilisateur, Date> creele;
	public static volatile SingularAttribute<Affectationutilisateur, BigInteger> statut;

}

