package com.prototype.webproject.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.prototype.webproject.entities.UserProperties;
import com.prototype.webproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		UserProperties u1 = new UserProperties(null, "Maria Ana Bragança", "maria@gtreco.com", "64982734212", "252525");
		UserProperties u2 = new UserProperties(null, "Carlos Alberto", "carlao246@gtreco.com", "64971215682", "241253");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
}
