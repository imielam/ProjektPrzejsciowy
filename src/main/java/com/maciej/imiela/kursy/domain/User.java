/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author Maciej
 */
public class User {

	private Long id;
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must contain only alphanumerlical sighns without a space.")
	private String username;
	@Size(min = 6, max = 20, message = "Password must have length between 6 to 20 sighns")
	private String password;
	private boolean verified = false;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", verified=" + verified + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if ((this.username == null) ? (other.username != null) : !this.username
				.equals(other.username)) {
			return false;
		}
		if ((this.password == null) ? (other.password != null) : !this.password
				.equals(other.password)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
