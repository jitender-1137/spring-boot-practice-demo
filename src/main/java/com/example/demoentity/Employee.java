package com.example.demoentity;

import javax.persistence.*;

@Entity
@Table(name = " employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "skills")
	private String skills;

	@Column(name = "designation")
	private String designation;

	public Employee() {
	}

	public Employee(Long id, String name, String skills, String designation) {
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.designation = designation;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
