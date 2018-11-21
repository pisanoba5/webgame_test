package com.mvc.board.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class InformationDto {
	@NotEmpty
	@Size(min = 4, max = 12)
	String id;
	@NotEmpty
	@Size(min = 4, max = 12)
	String password;
	@NotEmpty
	String name;
	@NotEmpty
	String gender;
	@NotEmpty
	String month;
	@NotEmpty
	String email;

	public void Information(String id, String password, String name, String gender, String month, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.month = month;
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
