package main.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Long> quantity;
	public static volatile SingularAttribute<Product, String> eanCode;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Maker> maker;
	public static volatile SingularAttribute<Product, Double> sellPrice;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, String> productName;

	public static final String QUANTITY = "quantity";
	public static final String EAN_CODE = "eanCode";
	public static final String DESCRIPTION = "description";
	public static final String MAKER = "maker";
	public static final String SELL_PRICE = "sellPrice";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_NAME = "productName";

}

