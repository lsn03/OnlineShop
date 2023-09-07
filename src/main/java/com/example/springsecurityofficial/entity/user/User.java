package com.example.springsecurityofficial.entity.user;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Transient
	private String confirmPassword;
	
	public User() {
	}
	
	public User(String login, String password, Role role, String confirmPassword) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				'}';
	}
}
