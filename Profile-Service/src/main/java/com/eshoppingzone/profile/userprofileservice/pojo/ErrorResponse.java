package com.eshoppingzone.profile.userprofileservice.pojo;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ErrorResponse {
	private HttpStatus statusmessage;
	private String message;
	private LocalDateTime datetime;
	
	

}
