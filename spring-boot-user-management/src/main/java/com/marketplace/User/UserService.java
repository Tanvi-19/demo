package com.marketplace.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private EncryptDecrypt encrypt;
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}

	public List<User> getUserByRole(String role) {
		return userRepository.findUserByRole(role);
	}

	public User createUser(User user) {
		String encodedPassword = encrypt.encrypt(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	public Optional<User> updateUser(User newUser, long id) {
		String encodedPassword = encrypt.encrypt(newUser.getPassword());
		newUser.setPassword(encodedPassword);
		
		Optional<User> user = Optional.ofNullable(new User());
		user = findUserById(id);
		User user1 = user.get();
		user1.setUsername(newUser.getUsername());
		user1.setPassword(newUser.getPassword());
		user1.setRole(newUser.getRole());
		user1.setUserAddress(newUser.getUserAddress());
		user1.setUserEmail(newUser.getUserEmail());
		user1.setUserMobileNo(newUser.getUserMobileNo());
		user1.setUserPincod(newUser.getUserPincod());
		userRepository.save(user1);
		return userRepository.findById(id);
	}

	public Optional<User> delUserById(long id) {
		Optional<User> user = Optional.ofNullable(new User());
		user = findUserById(id);
		if (user != null) {
			userRepository.deleteById(id);
		}
		return user;

	}
}
