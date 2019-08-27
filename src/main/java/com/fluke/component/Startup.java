package com.fluke.component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fluke.entity.MasterUser;
import com.fluke.entity.UserRole;
import com.fluke.repository.MasterUserRepository;
import com.fluke.repository.UserRoleRepository;


@Component
public class Startup {
	
	
	@Autowired private MasterUserRepository masterUserRepository;
	
	@Autowired private UserRoleRepository userRoleRepository;
	
	@Transactional
	@PostConstruct
	public void init() {
		
		MasterUser masterUser = new MasterUser();
		masterUser.setUserName("hello");
		masterUser.setPassword("password");
		masterUserRepository.save(masterUser);
		
		UserRole userRole = new UserRole();
		userRole.setUserCode(masterUser.getUserName());
		userRole.setRoleName("ROLE_STAFF");
		userRole.setObjectName("INQUIRY");
		userRoleRepository.save(userRole);
		
	}
	

}
