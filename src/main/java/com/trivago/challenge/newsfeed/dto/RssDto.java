package com.trivago.challenge.newsfeed.dto;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.trivago.challenge.newsfeed.model.ChannelEntity;
import com.trivago.challenge.newsfeed.model.RssEntity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class RssDto {
	 
	 @XmlElement(name="channel")
	 ChannelDto channelObject;
	 
	 private String dc;
	 private String media;
	 private String atom;
	 private String nyt;
	 private String _version;
	 
	
	public ChannelDto getChannelObject() {
		return channelObject;
	}
	public void setChannelObject(ChannelDto channelObject) {
		this.channelObject = channelObject;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getAtom() {
		return atom;
	}
	public void setAtom(String atom) {
		this.atom = atom;
	}
	public String getNyt() {
		return nyt;
	}
	public void setNyt(String nyt) {
		this.nyt = nyt;
	}
	public String get_version() {
		return _version;
	}
	public void set_version(String _version) {
		this._version = _version;
	}
	
	public ChannelEntity getChannelEntity() {
		ChannelEntity channelEntity = new ChannelEntity();
		channelEntity.setCopyright( channelObject.getCopyright());
	    channelEntity.setDescription(channelObject.getDescription());
	    channelEntity.setImageObject( channelObject.getImageObject());
	    channelEntity.setLanguage(channelObject.getLanguage());
	    channelEntity.setLastBuildDate( channelObject.getLastBuildDate());
	    channelEntity.setTitle(channelObject.getTitle());
	    channelEntity.setLink(channelObject.getLink());
		return channelEntity;
	}

	public RssEntity _toConvertRssEntity(){
		RssEntity entity = new RssEntity();
		entity.set_version(_version);
		entity.setAtom(atom);
	//	entity.setChannel(channelObject._toConvertChannelEntity());
		entity.setDc(dc);
		entity.setMedia(media);
		entity.setNyt(nyt);
	    return entity ;
	 }
	 
}
