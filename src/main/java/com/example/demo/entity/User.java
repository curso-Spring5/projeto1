package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity // - MySQL
@Document // - MongDB
public class User {

		//@GeneratedValue(strategy = GenerationType.AUTO) // - MySQL
		@Id
		private String id;
		
		private String name;
		private String email;
		
		public User(){
		}
		public User(String name, String email) {
			super();
			this.name = name;
			this.email = email;
		}
		//@ManyToMany // - MySQL
		private Set<Role> roles;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public Set<Role> getRoles() {
			return roles;
		}
		
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	
}
