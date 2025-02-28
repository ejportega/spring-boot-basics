package com.spring.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public Optional<User> getUser(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}		
		return user;
	} 
	
	@PostMapping(path = "/users")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
//		service.save(user);
		userRepository.save(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
//		User user = service.deleteById(id);
		userRepository.deleteById(id);
		
//		if (user == null) {
////			throw new UserNotFoundException("id-" + id);
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
//		}		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
//		userOptional.get().getPost();
		return userOptional.get().getPost();
	} 
	
	@PostMapping(path = "/users/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
