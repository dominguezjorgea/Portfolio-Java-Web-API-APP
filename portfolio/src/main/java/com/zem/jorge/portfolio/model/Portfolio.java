package com.zem.jorge.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "Portfolio")
public class Portfolio {
	
	@Id
	@Column(name="idportfolio")
	private Long idportfolio;
	
	private String description;
	private String imageUrl;
	private String title;
	private String twitterUserName;

	public Portfolio() {}
	
	public Portfolio(Long idportfolio, String description, String imageUrl, String title, String twitterUserName) {
		super();
		this.idportfolio = idportfolio;
		this.description = description;
		this.imageUrl = imageUrl;
		this.title = title;
		this.twitterUserName = twitterUserName;
	}

	public Long getIdportfolio() {
		return this.idportfolio;
	}

	public void setIdportfolio(Long idportfolio) {
		this.idportfolio = idportfolio;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTwitterUserName() {
		return this.twitterUserName;
	}

	public void setTwitterUserName(String twitterUserName) {
		this.twitterUserName = twitterUserName;
	}

}