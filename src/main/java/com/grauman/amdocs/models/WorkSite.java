package com.grauman.amdocs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WorkSite {
	private Integer id;
	private String name;
	private Country country;
	private String city;
	
	public WorkSite(Integer id, String name) {
		this.id = id;
		this.name =  name;
	}
	public WorkSite(Integer id,Country country) {
		this.id=id;
		this.country=country;
	}
	public WorkSite(String name,String city) {
		this.name=name;
		this.city=city;
	}
	public WorkSite(String name, String city, Country country) {
		this.name = name;
		this.city = city;
		this.country = country;
	}
}