package com.trivago.challenge.newsfeed.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trivago.challenge.newsfeed.model.ChannelEntity;

public interface ChannelRepo extends MongoRepository<ChannelEntity, String> {

}
