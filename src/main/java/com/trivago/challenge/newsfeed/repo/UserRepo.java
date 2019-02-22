package com.trivago.challenge.newsfeed.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trivago.challenge.newsfeed.model.UserEntity;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {

}
