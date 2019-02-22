package com.trivago.challenge.newsfeed.dto;

import com.trivago.challenge.newsfeed.model.UserEntity;

public class UserDto {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public UserEntity _toConvertUserEntity(){
		UserEntity entity = new UserEntity();
		entity.setEmail(email);
	    return entity ;
	 }
	
}
