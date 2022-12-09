package com.eshoppingzone.profile.userprofileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;

@Repository
public interface ProfileRepository extends MongoRepository<UserProfile, Integer>{

	
	
	 // UserProfile findByMobileNumber(Long mobileNumber);
	  
	  
	  //UserProfile findByUserName(String fullname);
	 
	 

}
