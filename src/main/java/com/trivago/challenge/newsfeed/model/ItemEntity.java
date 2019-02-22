package com.trivago.challenge.newsfeed.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ItemEntity")
public class ItemEntity {

	private String title;
	private String link;
	@Id
	private String guidObject;
	private String description;
	private String pubDate;
	private String creator;
	
	private List<UserRatingEntity> userRating;
	
	private float rating;
	
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getGuidObject() {
		return guidObject;
	}
	public void setGuidObject(String guidObject) {
		this.guidObject = guidObject;
	}
	public List<UserRatingEntity> getUserRating() {
		return userRating;
	}
	public void setUserRating(List<UserRatingEntity> userRating) {
		this.userRating = userRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	

}
