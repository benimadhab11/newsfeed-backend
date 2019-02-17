package com.trivago.challenge.newsfeed.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "ChannelEntity")
public class ChannelEntity {

	@Id 
	private String title;
	ArrayList < Object > link = new ArrayList < Object > ();
	private String description;
	private String language;
	private String copyright;
	private String lastBuildDate;
	Image ImageObject;
	
	@DBRef
	private List<ItemEntity> items;
	 
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Object> getLink() {
		return link;
	}
	public void setLink(ArrayList<Object> link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public Image getImageObject() {
		return ImageObject;
	}
	public void setImageObject(Image imageObject) {
		ImageObject = imageObject;
	}
	 
	 
}
