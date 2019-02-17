package com.trivago.challenge.newsfeed.model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RssEntity")
public class RssEntity {

	@DBRef
	ChannelEntity Channel;
	private String dc;
	private String media;
	private String atom;
	private String nyt;
	private String _version;
	
		
	public RssEntity() {
		super();
	}
	@PersistenceConstructor
	public RssEntity(ChannelEntity channel, String dc, String media, String atom, String nyt, String _version) {
		super();
		Channel = channel;
		this.dc = dc;
		this.media = media;
		this.atom = atom;
		this.nyt = nyt;
		this._version = _version;
	}
	public ChannelEntity getChannel() {
		return Channel;
	}
	public void setChannel(ChannelEntity channel) {
		Channel = channel;
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
	 
	 
}
