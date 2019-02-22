package com.trivago.challenge.newsfeed.service;

import java.util.Optional;

import com.trivago.challenge.newsfeed.dto.UserDto;
import com.trivago.challenge.newsfeed.model.UserEntity;

public interface UserService {
	public Optional<UserEntity> getUser(String userId);
	public String postUser(UserDto user);
}
