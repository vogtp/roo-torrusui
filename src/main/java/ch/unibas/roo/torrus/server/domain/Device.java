package ch.unibas.roo.torrus.server.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Device {

	@NotBlank
	private String name;

	// public static List Topping.findAllToppings() {
	// return entityManager().createQuery("SELECT o FROM Topping o",
	// Topping.class).getResultList();
	// }

}
