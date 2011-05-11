package com.ezadyra.tools.daotesthelper.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author eugene zadyra
 */
@Entity
public class CompactDisk {

	@Id
	private String title;
	private String artist;
	private String country;
	private String company;
	private Double price;
	private Integer year;

	public CompactDisk(){}

	public CompactDisk(String title){
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
