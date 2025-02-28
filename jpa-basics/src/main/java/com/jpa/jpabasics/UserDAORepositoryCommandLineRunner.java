package com.jpa.jpabasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.jpabasics.entity.User;
import com.jpa.jpabasics.service.UserDAOService;
import com.jpa.jpabasics.service.UserRepository;

@Component
public class UserDAORepositoryCommandLineRunner implements CommandLineRunner {
	private static final Logger log =
			LoggerFactory.getLogger(UserDAORepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New user is created : " + user);
	}
	
}
