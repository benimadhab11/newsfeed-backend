package com.trivago.challenge.newsfeed.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivago.challenge.newsfeed.dto.UserDto;
import com.trivago.challenge.newsfeed.model.UserEntity;
import com.trivago.challenge.newsfeed.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	public Optional<UserEntity> getUser(String userId){
		
		return userRepo.findById(userId);
		
	}

	@Override
	public String postUser(UserDto user) {
		
		userRepo.save(user._toConvertUserEntity());
		return "Success!";
	}
}
