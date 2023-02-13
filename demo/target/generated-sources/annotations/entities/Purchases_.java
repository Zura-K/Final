package entities;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Purchases.class)
public abstract class Purchases_ {

	public static volatile SingularAttribute<Purchases, LocalDateTime> purchaseDate;
	public static volatile SingularAttribute<Purchases, Product> productId;
	public static volatile SingularAttribute<Purchases, Double> totalPurchasePrice;
	public static volatile SingularAttribute<Purchases, Integer> purchaseQuantity;
	public static volatile SingularAttribute<Purchases, Integer> id;
	public static volatile SingularAttribute<Purchases, Double> purchasePrice;

	public static final String PURCHASE_DATE = "purchaseDate";
	public static final String PRODUCT_ID = "productId";
	public static final String TOTAL_PURCHASE_PRICE = "totalPurchasePrice";
	public static final String PURCHASE_QUANTITY = "purchaseQuantity";
	public static final String ID = "id";
	public static final String PURCHASE_PRICE = "purchasePrice";

}

