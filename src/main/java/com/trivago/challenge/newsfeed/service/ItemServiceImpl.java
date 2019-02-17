package com.trivago.challenge.newsfeed.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.trivago.challenge.newsfeed.model.ItemEntity;
import com.trivago.challenge.newsfeed.model.UserRatingEntity;
import com.trivago.challenge.newsfeed.repo.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService{
	
	public List<ItemEntity> sortedItems = new ArrayList<>();

	public List<ItemEntity> getSortedItems() {
		return sortedItems;
	}

	public void setSortedItems(List<ItemEntity> sortedItems) {
		this.sortedItems = sortedItems;
	}

	@Autowired
	private ItemRepo itemRepo;
	
	public List<ItemEntity> getAllItems() {
		return itemRepo.findAll();
	}
	
	public Optional<ItemEntity> getItemByGuid(String guidObject) {
		
		return itemRepo.findById(guidObject);
          
	}
	
	public String postUserRating(String guidObject,UserRatingEntity userRating) {
		Optional<ItemEntity> itemEntity = itemRepo.findById(guidObject);
		List<UserRatingEntity> listofUsersRater = itemEntity.get().getUserRating();
		if(listofUsersRater == null) {
			listofUsersRater = new ArrayList<>();
		}
		boolean isPresent = false;
		for(UserRatingEntity user:listofUsersRater) {
			if(user.getUserId().equals(userRating.getUserId())){
				user.setRating(userRating.getRating());
				isPresent = true;
				break;
			}
		}
		if(!isPresent) {
			listofUsersRater.add(userRating);
		}
		float rating = 0;
		int noOfUsers = listofUsersRater.size();
		for(UserRatingEntity user:listofUsersRater) {
			rating += user.getRating();
		}
		itemEntity.get().setRating(rating/noOfUsers);
		itemEntity.get().setUserRating(listofUsersRater);
		itemRepo.save(itemEntity.get());
		
		return "Success!";
       
	}
	
	 public List<ItemEntity>  getBestRatedItems() {
			return sortedItems;
	}
	 
	@Scheduled(cron="0 0/5 * * * *")
	public void cronBestFiveItems() {
		System.out.println("cro");
		sortedItems= itemRepo.findAll()
							 .stream()
							 .sorted(Comparator.comparing(ItemEntity::getRating).reversed())
						     .collect(Collectors.toList()).subList(0, 5);
		
	}

	
}
