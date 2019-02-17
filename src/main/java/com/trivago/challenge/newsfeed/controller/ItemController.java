package com.trivago.challenge.newsfeed.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trivago.challenge.newsfeed.model.ItemEntity;
import com.trivago.challenge.newsfeed.model.UserRatingEntity;
import com.trivago.challenge.newsfeed.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/getitems", method = RequestMethod.GET)
	public List<ItemEntity> getItems() {
		return itemService.getAllItems();
	}
	
	@RequestMapping(value = "/getitems/{guidObject}", method = RequestMethod.GET)
    public Optional<ItemEntity> getItem(@PathVariable @NotNull String guidObject) {
		return itemService.getItemByGuid(guidObject);
	}
	
	@RequestMapping(value = "/getitems/{guidObject}", method = RequestMethod.POST)
    public ResponseEntity<String> postRating(@PathVariable @NotNull String guidObject,@Valid @RequestBody UserRatingEntity userRating) {
		String result = itemService.postUserRating(guidObject,userRating);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}	
	
	@RequestMapping(value = "/getitems/bestrated", method = RequestMethod.GET)
    public List<ItemEntity>  getBRItems() {
		return itemService.getBestRatedItems();
	}
		
}

