package com.prototype.webproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.prototype.webproject.entities.ClientOrder;
import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.repositories.ClientOrderRepository;
import com.prototype.webproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientOrderRepository clientOrderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		UserProperties u1 = new UserProperties(null, "Maria Ana Bragança", "maria@gtreco.com", "64982734212", "252525");
		UserProperties u2 = new UserProperties(null, "Carlos Alberto", "carlao246@gtreco.com", "64971215682", "241253");
		
		ClientOrder o1 = new ClientOrder(null, Instant.parse("2023-06-15T16:35:08Z"),u1);
		ClientOrder o2 = new ClientOrder(null, Instant.parse("2023-06-15T19:04:08Z"),u2);
		ClientOrder o3 = new ClientOrder(null, Instant.parse("2023-06-15T23:30:08Z"),u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		clientOrderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
}
