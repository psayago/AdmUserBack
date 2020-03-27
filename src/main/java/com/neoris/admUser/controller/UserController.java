package com.neoris.admUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.admUser.model.User;
import com.neoris.admUser.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "api/authenticate/register", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {

		try {
			return ResponseEntity.ok(userRepository.save(user));

		} catch (Exception e) {
			System.out.println("Hubo un ERROR al guardar la sucursal");
			return null;
		}

	}

	@RequestMapping(value = "api/authenticate/login", method = RequestMethod.POST)
	//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity<User> saveUser(@RequestBody User user) {
//		HttpHeaders responseHeaders = new HttpHeaders();
		
		User usuario = new User();
		
		try {
			usuario = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			return new ResponseEntity<User>(usuario, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
//			responseHeaders.add("Request Method", "POST");
//			responseHeaders.add("Status Code", "200");
//			responseHeaders.add("Content-Type","application/json");
//			Gson gson = new Gson();
//			String json = gson.toJson(user);
//			System.out.println("entro en trueee");
//			return ResponseEntity.ok()
//				      .headers(responseHeaders)
//				      .body( json);
//			
//		} else {
//			responseHeaders.add("Request Method", "POST");
//		    responseHeaders.add("Status Code", "400");
//		    responseHeaders.add("Content-Type","application/json");
//		    System.out.println(responseHeaders);
//			return ResponseEntity.badRequest()
//				      .headers(responseHeaders)
//				      .body("{}");
	    
	}

}
