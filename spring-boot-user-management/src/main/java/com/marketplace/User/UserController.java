package com.marketplace.User;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService = new UserService();

	@GetMapping(value = "/users")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while fetching all Users data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while fetching all Users data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<?> findById(@PathVariable final long id) {
		try {
			return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while fetching User data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while fetching User data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/userByRole/{role}")
	public ResponseEntity<?> getUserByRole(@PathVariable("role") String role) {
		try {
			return new ResponseEntity<>(userService.getUserByRole(role), HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while fetching user data: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while fetching user data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping(value = "/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
		}
		catch(Exception e){
			logger.error("Error occurred while creating User: " + e.getMessage());
            return new ResponseEntity<>("Error occurred while creating User", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PutMapping(value = "/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable long id){
		try {
			return new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("Error occurred while updating User: Id Not Found, " + e.getMessage());
            return new ResponseEntity<>("Error occurred while updating User : Id Not Found ", HttpStatus.NOT_FOUND);
        }
	}
	
	 @DeleteMapping("/user/{id}")
	 public ResponseEntity<?> deleteUser(@PathVariable long id) {
			try {
				return new ResponseEntity<>(userService.delUserById(id), HttpStatus.OK);
			}
			catch(Exception e){
				logger.error("Error While Deleting : ID not found " + e.getMessage());
	            return new ResponseEntity<>("Error while Deleting User : ID not found ", HttpStatus.NOT_FOUND);
			}
	 }

}
