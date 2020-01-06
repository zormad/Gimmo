package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SingularAttribute<Service, Agent> idagent;
	public static volatile ListAttribute<Service, Postedetravail> postedetravailCollection;
	public static volatile SingularAttribute<Service, String> creepar;
	public static volatile SingularAttribute<Service, Date> modifiele;
	public static volatile SingularAttribute<Service, String> codeservice;
	public static volatile SingularAttribute<Service, String> modifiepar;
	public static volatile SingularAttribute<Service, Date> creele;
	public static volatile ListAttribute<Service, Agent> agentCollection;
	public static volatile SingularAttribute<Service, Structure> structure;
	public static volatile SingularAttribute<Service, String> libelleservice;

}

