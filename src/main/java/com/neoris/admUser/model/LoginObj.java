package com.neoris.admUser.model;

public class LoginObj {

	private String username;
	private String password;

	public LoginObj(String username, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassoword() {
		return password;
	}

	public void setPassoword(String passoword) {
		this.password = passoword;
	}

}
