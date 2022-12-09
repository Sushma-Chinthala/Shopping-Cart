package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.exception.ProfileAlreadyExistsException;
import com.eshoppingzone.profile.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.pojo.Role;
import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;

@Service
public interface ProfileService {

	public List<UserProfile> getAllProfiles();

	public UserProfile getByProfileId(int profileId)throws ProfileNotFoundException;

	public UserProfile addNewCustomerProfile(UserProfile userProfile);

	public UserProfile updateProfile(UserProfile userProfile)throws ProfileNotFoundException;

	public void deleteProfile(int profileId)throws ProfileNotFoundException;

	public void addNewMerchantProfile(UserProfile userProfile);

	public void addNewDeliveryProfile(UserProfile userProfile);

	
	  
	  // UserProfile findByMobileNo(Long mobileNumber);
	  
	//  public UserProfile getByUserName(String fullName);
	 

}
