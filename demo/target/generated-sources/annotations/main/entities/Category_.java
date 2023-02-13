package main.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SingularAttribute<Category, Integer> markerID;
	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, Integer> parentID;

	public static final String ID = "id";
	public static final String MARKER_ID = "markerID";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String PARENT_ID = "parentID";

}

