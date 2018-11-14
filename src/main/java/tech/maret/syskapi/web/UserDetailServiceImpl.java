package tech.maret.syskapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.maret.syskapi.domain.UserAPI;
import tech.maret.syskapi.domain.UserAPIRepository;



/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserAPIRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserAPIRepository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	UserAPI curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 
