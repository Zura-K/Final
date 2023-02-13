package main.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Boolean> role;
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

