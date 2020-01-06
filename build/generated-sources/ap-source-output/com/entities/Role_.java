package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, String> idrole;
	public static volatile SingularAttribute<Role, String> creepar;
	public static volatile SingularAttribute<Role, Date> modifiele;
	public static volatile CollectionAttribute<Role, Affectationrole> affectationroleCollection;
	public static volatile SingularAttribute<Role, String> description;
	public static volatile SingularAttribute<Role, String> modifiepar;
	public static volatile SingularAttribute<Role, Date> creele;
	public static volatile SingularAttribute<Role, String> libellerole;

}

