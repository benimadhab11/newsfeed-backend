package com.trivago.challenge.newsfeed.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trivago.challenge.newsfeed.dto.CredentialsDto;
import com.trivago.challenge.newsfeed.dto.ErrorsDto;
import com.trivago.challenge.newsfeed.dto.UserDto;
import com.trivago.challenge.newsfeed.model.UserEntity;
import com.trivago.challenge.newsfeed.service.UserService;


@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth")
	@ResponseBody
	public ResponseEntity<?> loginUser(@Valid @RequestBody CredentialsDto credentials) {
		Optional<UserEntity> foundUser  = userService.getUser(credentials.getCredentials().getEmail());

		UserDto userResult = new UserDto();
		if(foundUser.isPresent()) {
			CredentialsDto result = new CredentialsDto();
			userResult.setEmail(foundUser.get().getEmail());
			result.setCredentials(userResult);
			return new ResponseEntity<CredentialsDto>(result, HttpStatus.OK);
		}
		else {
			ErrorsDto resultError = new ErrorsDto();
			userResult.setEmail("The email does not exist. Please sign up!");
			resultError.setErrors(userResult);
			return new ResponseEntity<ErrorsDto>(resultError, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users")
	@ResponseBody
	public ResponseEntity<?> signUpUser(@Valid @RequestBody CredentialsDto credentials) {
		Optional<UserEntity> foundUser  = userService.getUser(credentials.getCredentials().getEmail());
		UserDto userResult = new UserDto();
		
		if(foundUser.isPresent()) {
			ErrorsDto resultError = new ErrorsDto();
			
			userResult.setEmail("The email is already taken");
			resultError.setErrors(userResult);
			return new ResponseEntity<ErrorsDto>(resultError, HttpStatus.NOT_FOUND);
		}
		else {
			CredentialsDto resultSuccess = new CredentialsDto();
			userService.postUser(credentials.getCredentials());
			userResult.setEmail(credentials.getCredentials().getEmail());
			resultSuccess.setCredentials(userResult);
			return new ResponseEntity<CredentialsDto>(resultSuccess, HttpStatus.OK);
		}
	}
}
