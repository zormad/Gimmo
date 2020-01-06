package com.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Utilisateur.class)
public abstract class Utilisateur_ {

	public static volatile SingularAttribute<Utilisateur, String> loginuser;
	public static volatile SingularAttribute<Utilisateur, BigInteger> connecte;
	public static volatile SingularAttribute<Utilisateur, BigDecimal> iduser;
	public static volatile SingularAttribute<Utilisateur, String> creepar;
	public static volatile CollectionAttribute<Utilisateur, Affectationutilisateur> affectationutilisateurCollection;
	public static volatile SingularAttribute<Utilisateur, Date> modifiele;
	public static volatile SingularAttribute<Utilisateur, Profil> idprofil;
	public static volatile SingularAttribute<Utilisateur, String> loginpasswd;
	public static volatile SingularAttribute<Utilisateur, Date> derniereconnexion;
	public static volatile SingularAttribute<Utilisateur, String> modifiepar;
	public static volatile SingularAttribute<Utilisateur, Date> creele;

}

