package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "employees"
})
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@OneToMany(
	        mappedBy = "company", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
    @JsonManagedReference
	private List<Employee> employees;
	
	public Company() {
		
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("employees")
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
