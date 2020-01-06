package com.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Profil.class)
public abstract class Profil_ {

	public static volatile CollectionAttribute<Profil, Utilisateur> utilisateurCollection;
	public static volatile SingularAttribute<Profil, String> creepar;
	public static volatile SingularAttribute<Profil, String> idprofil;
	public static volatile CollectionAttribute<Profil, Affectationrole> affectationroleCollection;
	public static volatile SingularAttribute<Profil, String> libelleprofil;
	public static volatile SingularAttribute<Profil, Date> modifierle;
	public static volatile SingularAttribute<Profil, String> modifiepar;
	public static volatile SingularAttribute<Profil, Date> creele;

}

