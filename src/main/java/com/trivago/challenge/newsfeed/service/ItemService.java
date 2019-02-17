package com.trivago.challenge.newsfeed.service;

import java.util.List;
import java.util.Optional;

import com.trivago.challenge.newsfeed.model.ItemEntity;
import com.trivago.challenge.newsfeed.model.UserRatingEntity;

public interface ItemService {

	public List<ItemEntity> getAllItems() ;
	public Optional<ItemEntity> getItemByGuid(String guidObject);
	public String postUserRating(String guidObject,UserRatingEntity userRating);
	public List<ItemEntity>  getBestRatedItems();
	public void cronBestFiveItems();
	public void setSortedItems(List<ItemEntity> sortedItems);
}
