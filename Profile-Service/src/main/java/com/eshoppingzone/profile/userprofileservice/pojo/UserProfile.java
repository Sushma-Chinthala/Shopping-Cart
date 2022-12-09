package com.eshoppingzone.profile.userprofileservice.pojo;


import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter

@Document(collection="userprofile")
public class UserProfile {
	@Id
	private  int profileId;
	
	@NotEmpty(message="Name should not be empty")
	private String fullName;
	
	private String image;
	
	@Email(message="Email must be valid")
	@NotEmpty(message="Email cannot be empty")
	@Indexed(unique=true)
	private String emailId;
	
	@NotNull
	private Long mobileNumber;
	private String about;
	//private LocalDate dateOfBirth;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	private String gender;
	
	@NotEmpty
	private String role;
	@Size(min=8,message="length must be greater then 8")
	private String password;
	
	private Address address;
	

}
