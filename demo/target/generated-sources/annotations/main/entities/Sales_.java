package main.entities;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sales.class)
public abstract class Sales_ {

	public static volatile SingularAttribute<Sales, Double> totalSellPrice;
	public static volatile SingularAttribute<Sales, Long> sellQuantity;
	public static volatile SingularAttribute<Sales, String> ENACode;
	public static volatile SingularAttribute<Sales, Double> sellPrice;
	public static volatile SingularAttribute<Sales, LocalDateTime> sellDate;
	public static volatile SingularAttribute<Sales, Integer> id;

	public static final String TOTAL_SELL_PRICE = "totalSellPrice";
	public static final String SELL_QUANTITY = "sellQuantity";
	public static final String E_NA_CODE = "ENACode";
	public static final String SELL_PRICE = "sellPrice";
	public static final String SELL_DATE = "sellDate";
	public static final String ID = "id";

}

