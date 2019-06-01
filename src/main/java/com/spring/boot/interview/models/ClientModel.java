package com.spring.boot.interview.models;

import java.util.Date;

import com.spring.boot.interview.enums.SexoEnum;

public class ClientModel {

	private String name = "";
	private SexoEnum gender;
	private Date dtBirth;
	private int age;
	private String city = "";

	public String getName() {
		return name;
	}

	public void setName(String nameParam) {
		this.name = nameParam;
	}

	public SexoEnum getGender() {
		return gender;
	}

	public void setGender(SexoEnum genderParam) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String cityParam) {
		this.city = cityParam;
	}

}
