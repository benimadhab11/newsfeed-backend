package com.trivago.challenge.newsfeed.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import com.trivago.challenge.newsfeed.model.ItemEntity;

@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDto {
	
	 private String title;
	 private String link;
	 private String guidObject;
	 private String description;
	 private String pubDate;
	 
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
	 
	 
	public ItemEntity _toConvertItemEntityy(){
		ItemEntity entity = new ItemEntity();
		entity.setDescription(description);
		entity.setGuidObject(guidObject);
		entity.setLink(link);
		entity.setPubDate(pubDate);
		entity.setTitle(title);
	    return entity ;
	 }
	 

}
