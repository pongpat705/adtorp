package com.fluke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fluke.entity.MasterUser;

@Repository
public interface MasterUserRepository extends JpaRepository<MasterUser, Long> {

	MasterUser findByUserNameAndPassword(String userName, String password);
}
