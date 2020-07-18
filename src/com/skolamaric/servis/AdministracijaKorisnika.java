package com.skolamaric.servis;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.skolamaric.model.Roles;
import com.skolamaric.model.User;

public class AdministracijaKorisnika {
	private ConcurrentHashMap<String, User> users = new ConcurrentHashMap <>();
	
	public AdministracijaKorisnika() {
		init();
	}

	private void init() {
	
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("pass0");
		admin.setRole(Roles.ADMIN);
		
		users.put(admin.getUsername(), admin);
		
		User user = new User();
		user.setUsername("user");
		user.setPassword("pass1");
		user.setRole(Roles.USER);
		
		users.put(user.getUsername(), user);
		
	}
	
	public boolean isRegistered(String username) {
		return (users.get(username) != null);
	}
	
	public boolean isAuthenticated(String username, String password) {
		User user = users.get(username);
		return ((user != null )&& user.getPassword().equals(password));
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
}
