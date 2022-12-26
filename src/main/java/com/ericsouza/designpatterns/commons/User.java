package com.ericsouza.designpatterns.commons;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private Long id;
	private String name;
	private String role = "normal";

	public User() {}

	public boolean isCompanyOwner() {
		return "owner".equals(this.role);
	}

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
