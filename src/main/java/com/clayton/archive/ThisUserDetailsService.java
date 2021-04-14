package com.clayton.archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clayton.archive.models.Users;
import com.clayton.archive.repositories.UsersRepository;

@Service
public class ThisUserDetailsService implements UserDetailsService {
	@Autowired
	UsersRepository usersRepo;
	
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}
}
