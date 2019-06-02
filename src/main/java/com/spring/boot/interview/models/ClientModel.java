package com.spring.boot.interview.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.spring.boot.interview.enums.GenderEnum;

@Entity(name = "Cliente")
public class ClientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name = "";
	private GenderEnum gender;
	private Date dtBirth;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	private CityModel city;

	public Long getId() {
		return id;
	}

	public void setId(Long idParam) {
		this.id = idParam;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameParam) {
		this.name = nameParam;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum genderParam) {
		this.gender = genderParam;
	}

	public Date getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(Date dtBirthParam) {
		this.dtBirth = dtBirthParam;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int ageParam) {
		this.age = ageParam;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel cityParam) {
		this.city = cityParam;
	}

}
