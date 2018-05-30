package com.backbase.atm.dto;

import javax.persistence.*;

/**
 * Created by AIRSoftware on 10/02/2018.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

	public static Long ADMIN = 1l;

	public UserRole() {
	}

	public UserRole(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
