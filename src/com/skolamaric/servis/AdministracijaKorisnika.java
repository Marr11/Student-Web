package com.skolamaric.servis;

import java.util.HashMap;

import com.skolamaric.model.Roles;
import com.skolamaric.model.User;

public class AdministracijaKorisnika {
	private HashMap<String, User> users = new HashMap<>();
	
	public AdministracijaKorisnika() {
		init();
	}

	private void init() {
	
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("password0");
		admin.setRole(Roles.ADMIN);
		
		users.put(admin.getUsername(), admin);
		
		User user = new User();
		user.setUsername("user");
		user.setPassword("password1");
		user.setRole(Roles.USER);
		
		users.put(user.getUsername(), user);
		
	}
}
