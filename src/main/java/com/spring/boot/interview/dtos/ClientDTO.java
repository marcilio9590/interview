package com.spring.boot.interview.dtos;

public class ClientDTO {

	private String name = "";
	private String gender;
	private String dtBirth;
	private int age;
	private String city = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(String dtBirth) {
		this.dtBirth = dtBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
