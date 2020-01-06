package com.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agent.class)
public abstract class Agent_ {

	public static volatile SingularAttribute<Agent, String> creepar;
	public static volatile CollectionAttribute<Agent, Affectationutilisateur> affectationutilisateurCollection;
	public static volatile SingularAttribute<Agent, String> matricule;
	public static volatile CollectionAttribute<Agent, Occupation> occupationCollection;
	public static volatile SingularAttribute<Agent, String> sexe;
	public static volatile SingularAttribute<Agent, Date> modifierle;
	public static volatile SingularAttribute<Agent, String> nom;
	public static volatile SingularAttribute<Agent, Date> creele;
	public static volatile CollectionAttribute<Agent, Service> serviceCollection;
	public static volatile SingularAttribute<Agent, BigDecimal> idagent;
	public static volatile CollectionAttribute<Agent, Sortie> sortieCollection;
	public static volatile SingularAttribute<Agent, String> modifierpar;
	public static volatile SingularAttribute<Agent, Service> service;
	public static volatile SingularAttribute<Agent, Date> datenaissance;
	public static volatile SingularAttribute<Agent, Structure> codestructure;
	public static volatile CollectionAttribute<Agent, Agentcat> agentcatCollection;
	public static volatile SingularAttribute<Agent, String> telagent;
	public static volatile SingularAttribute<Agent, String> prenom;
	public static volatile CollectionAttribute<Agent, Structure> structureCollection;

}

