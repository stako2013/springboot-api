package com.paloit.model;

import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;
	
	@Transient
	private String name;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setName() {
		this.name = this.firstName + " " + this.lastName;
	}
	
	public String getName() {
		return name;
	}

	@Column(name = "last_name")
	private String lastName;

	@Override
	public String toString() {
		return "{ id: " + this.id + ", first_name:" + this.firstName + ", last_name:" + this.lastName + " }";
	}
}