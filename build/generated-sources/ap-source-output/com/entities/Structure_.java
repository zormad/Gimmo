package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Structure.class)
public abstract class Structure_ {

	public static volatile SingularAttribute<Structure, String> creepar;
	public static volatile SingularAttribute<Structure, Date> modifiele;
	public static volatile SingularAttribute<Structure, String> libellestructure;
	public static volatile SingularAttribute<Structure, Typestructure> idtypestruct;
	public static volatile ListAttribute<Structure, Previsions> previsionsCollection;
	public static volatile SingularAttribute<Structure, Magasin> magasin;
	public static volatile SingularAttribute<Structure, Date> creele;
	public static volatile ListAttribute<Structure, Agent> agentCollection;
	public static volatile ListAttribute<Structure, Service> serviceCollection;
	public static volatile SingularAttribute<Structure, Agent> idagent;
	public static volatile ListAttribute<Structure, Inventairestructure> inventairestructureCollection;
	public static volatile SingularAttribute<Structure, String> codestructure;
	public static volatile SingularAttribute<Structure, String> modifiepar;

}

