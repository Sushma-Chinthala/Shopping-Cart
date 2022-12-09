package com.eshoppingzone.profile.userprofileservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;
import com.eshoppingzone.profile.userprofileservice.service.ProfileService;
import com.eshoppingzone.profile.userprofileservice.service.ProfileServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileResource {
	
	@Autowired
	private ProfileServiceImpl profileServiceImpl;
	
	@Autowired
	ProfileRepository profileRepository;
	
	
	//To get all profiles
	@GetMapping("/users")
	public List<UserProfile> getAllProfiles(){
		return profileServiceImpl.getAllProfiles();
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getByProfileId(@PathVariable("id")int id) {
		return profileServiceImpl.getByProfileId(id);
	}
	
	@PostMapping("/add")
	public UserProfile addNewCustomerProfile(@RequestBody UserProfile add) {
		return profileServiceImpl.addNewCustomerProfile(add);
	}
	
	@PutMapping("/update")
	public UserProfile updateProfile(@RequestBody UserProfile u) {
		return profileServiceImpl.updateProfile(u);
	}
	
	@DeleteMapping("/users/{profileId}")
	public void deleteProfile(@PathVariable("profileId") int profileId) {
		profileServiceImpl.deleteProfile(profileId);
	}
	 
	
	//Adding new merchant
	@PostMapping("/merchant")
	public void addNewMerchantProfile(@RequestBody UserProfile userProfile) {
		profileServiceImpl.addNewMerchantProfile(userProfile);
	}
	
	
	//Adding new Delivery Agent
	@PostMapping("/delivery")
	public void addNewDeliveryProfile(@RequestBody UserProfile userProfile ) {
		profileServiceImpl.addNewDeliveryProfile(userProfile);
	}
	
	
	
	  //To get user profile by mobile number
	  
		/*
		 * @GetMapping("/user/{mobileNumber}") public UserProfile
		 * findByMobileNo(@PathVariable Long mobileNumber) { return
		 * profileServiceImpl.findByMobileNo(mobileNumber); }
		 */
	
		/*
		 * @GetMapping("/user/{fullName}") public UserProfile
		 * getByUserName(@PathVariable("fullName") String fullName ) { return
		 * profileServiceImpl.getByUserName(fullName); }
		 */
	 
	 

}