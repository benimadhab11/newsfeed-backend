package com.trivago.challenge.newsfeed.dto;

import java.awt.Image;
import javax.xml.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import com.trivago.challenge.newsfeed.model.ChannelEntity;
import com.trivago.challenge.newsfeed.model.ItemEntity;


@XmlAccessorType(XmlAccessType.FIELD)
public class ChannelDto {
	
	 private String title;
	 ArrayList < Object > link = new ArrayList < Object > ();
	 private String description;
	 private String language;
	 private String copyright;
	 private String lastBuildDate;
	 Image ImageObject;
	 
	 @XmlElement(name="item")
	 private ItemDto[] items;

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

	public ItemDto[] getItems() {
		return items;
	}
	public List<ItemEntity> getItemEntities() {
		List<ItemEntity> itemEntityList = new ArrayList<>();
		
		for(ItemDto item: items) {
			ItemEntity itemEntity = item._toConvertItemEntityy();
			itemEntityList.add(itemEntity);
		}
		return itemEntityList;
	}

	public void setItems(ItemDto[] items) {
		this.items = items;
	}
	 
	
	public ChannelEntity _toConvertChannelEntity(){
		ChannelEntity entity = new ChannelEntity();
		entity.setCopyright(copyright);
		entity.setDescription(description);
		entity.setImageObject(getImageObject());
		entity.setLanguage(language);
		entity.setLastBuildDate(lastBuildDate);
		entity.setLink(link);
		entity.setTitle(title);
		//entity.setItems(getItemEntities());
	    return entity ;
	 }
	 

}
