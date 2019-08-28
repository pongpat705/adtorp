package com.fluke.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.fluke.entity.MasterUser;
import com.fluke.entity.UserRole;
import com.fluke.repository.MasterUserRepository;
import com.fluke.repository.UserRoleRepository;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private MasterUserRepository masterUserRepository;
	@Autowired private UserRoleRepository userRoleRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = String.valueOf(authentication.getPrincipal());
		String password = String.valueOf(authentication.getCredentials());
		log.info(" userName {} password {}", username, password);
		boolean authenticated = false;
		
		//contain object
		List<Authorities> authorities = new ArrayList<Authorities>();
		//contain user detail
		AppUserDetail details = new AppUserDetail();
		//??
		//contain usernamePassword
		AppCredential credentials = new AppCredential();
		
		MasterUser masterUser = masterUserRepository.findByUserNameAndPassword(username, password);
		if(null != masterUser) {
			log.info(masterUser.toString());
			authenticated = true;
			credentials.setUsername(masterUser.getUserName());
			credentials.setPassword(masterUser.getPassword());
			
			List<UserRole> userRoles = userRoleRepository.findByUserCode(masterUser.getUserName());
			if(!userRoles.isEmpty()) {
				log.info(userRoles.toString());
				for (UserRole userRole : userRoles) {
					authorities.add(new Authorities(userRole.getRoleName()));
				}
			}
		}
		
		Authentication authentication2 = new AppAuthentication(username, credentials, authorities, authenticated, details, password);
        return  authentication2;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
