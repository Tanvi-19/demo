package com.marketplace.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptDecrypt {

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String encrypt(String password) {
		try {
			String encodedPassword = this.passwordEncoder.encode(password);
			return encodedPassword;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}
	
}
