package com.trivago.challenge.newsfeed.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trivago.challenge.newsfeed.model.RssEntity;



@Repository
public interface RssRepo extends MongoRepository<RssEntity, String> {


}
