package com.example.personal.Dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "member")
//@Builder
@Data
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Boot시, Insert를 할 경우에는 해당 GenerateValue를 주석처리 해준다. (속성값을 제대로 받기 위하여)
	@Column(length=100)
	private String id;

	@Column(length=100)
	private String password;

	@Column(length=100)
	private String name;

	/*
	 * Insert need to no props Constructor
	 **/
	public Member() {
	}

	public Member(String password, String name) {
		this.id = "TEST";
		this.password = password;
		this.name = name;
	}

	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
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
