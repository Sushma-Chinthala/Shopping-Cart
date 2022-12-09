package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;

@Service
@Component
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired 
	ProfileRepository profileRepository;

	
	@Override
	public List<UserProfile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public UserProfile getByProfileId(int profileId) {
		Optional<UserProfile> findByProfileId = profileRepository.findById(profileId);
		UserProfile p= null;
		if(findByProfileId.isPresent()) {
			p=findByProfileId.get();
		}
		return p;
	}
	
	@Override
	public UserProfile addNewCustomerProfile(UserProfile userProfile) {
		return profileRepository.insert(userProfile);
	}
	

	@Override
	public UserProfile updateProfile(UserProfile userProfile) {
		return profileRepository.save(userProfile);
	}
	
	@Override
	public void deleteProfile(int profileId) {
		profileRepository.deleteById(profileId);
	}

	
	@Override 
	  public void addNewMerchantProfile(UserProfile userProfile) {
	   profileRepository.save(userProfile);
	  
	  }
	  
	  @Override 
	  public void addNewDeliveryProfile(UserProfile userProfile) {
	  profileRepository.save(userProfile);
	  
	  }


		
		/*
		 * public UserProfile getByUserName(String fullName) { return
		 * profileRepository.findByUserName(fullName); }
		 */
		 
	  
		
		/*
		 * @Override public UserProfile findByMobileNo(Long mobileNumber) { return
		 * profileRepository.findByMobileNumber(mobileNumber); }
		 * 
		 * @Override public UserProfile getByUserName(String fullName) { return
		 * profileRepository.findByUserName(fullName); }
		 */
		 
	 

}
