package com.trivago.challenge.newsfeed.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trivago.challenge.newsfeed.model.ItemEntity;

public interface ItemRepo extends MongoRepository<ItemEntity, String>{

}
