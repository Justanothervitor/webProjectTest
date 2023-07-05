package com.prototype.webproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.prototype.webproject.entities.CategoryProperties;
import com.prototype.webproject.entities.ClientOrder;
import com.prototype.webproject.entities.OrderItem;
import com.prototype.webproject.entities.ProductProperties;
import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.entities.enums.ClientOrderStatus;
import com.prototype.webproject.repositories.CategoryRepository;
import com.prototype.webproject.repositories.ClientOrderRepository;
import com.prototype.webproject.repositories.OrderItemRepository;
import com.prototype.webproject.repositories.ProductRepository;
import com.prototype.webproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientOrderRepository clientOrderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		

		CategoryProperties c1 = new CategoryProperties(null , "Eletronics");
		CategoryProperties c2 = new CategoryProperties(null , "Books");
		CategoryProperties c3 = new CategoryProperties(null , "Computers");
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		ProductProperties pr1 = new ProductProperties(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		ProductProperties pr2 = new ProductProperties(null,"Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		ProductProperties pr3 = new ProductProperties(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		ProductProperties pr4 = new ProductProperties(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		ProductProperties pr5 = new ProductProperties(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");		
		productRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		pr1.getCategories().add(c2);
		pr2.getCategories().add(c1);
		pr2.getCategories().add(c3);
		pr3.getCategories().add(c1);
		pr3.getCategories().add(c3);
		pr4.getCategories().add(c1);
		pr4.getCategories().add(c3);
		pr5.getCategories().add(c2);
		productRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		UserProperties u1 = new UserProperties(null, "Maria Ana Bragança", "maria@gtreco.com", "64982734212", "252525");
		UserProperties u2 = new UserProperties(null, "Carlos Alberto", "carlao246@gtreco.com", "64971215682", "241253");
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		ClientOrder o1 = new ClientOrder(null, Instant.parse("2023-06-15T16:35:08Z"),u1, ClientOrderStatus.PAID);
		ClientOrder o2 = new ClientOrder(null, Instant.parse("2023-06-15T19:04:08Z"),u2, ClientOrderStatus.WAITING_PAYMENT);
		ClientOrder o3 = new ClientOrder(null, Instant.parse("2023-06-15T23:30:08Z"),u1, ClientOrderStatus.SHIPPED);
		clientOrderRepository.saveAll(Arrays.asList(o1,o2,o3));

		OrderItem oi1 = new OrderItem (o1,pr1,2,pr1.getPrice());
		OrderItem oi2 = new OrderItem (o1,pr3,1,pr3.getPrice());
		OrderItem oi3 = new OrderItem (o2,pr3,2,pr3.getPrice());
		OrderItem oi4 = new OrderItem (o3,pr5,2,pr5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
	
}

