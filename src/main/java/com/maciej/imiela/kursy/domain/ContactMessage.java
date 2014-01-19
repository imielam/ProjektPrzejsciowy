package com.maciej.imiela.kursy.domain;

public class ContactMessage extends Message {

	protected String email = "";

	@Override
	public String toString() {
		return "ContactMessage [email=" + email + ", message=" + message + "]";
	}

	public ContactMessage() {
		super();
	}

	public ContactMessage(String message, String email) {
		super(message);
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
