package com.jpa.jpabasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.jpabasics.entity.User;
import com.jpa.jpabasics.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log =
			LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOservice;

	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jack", "Admin");
		long insert = userDAOservice.insert(user);
		log.info("New user is created : " + user);
	}
	
}
