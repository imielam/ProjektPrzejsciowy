package com.maciej.imiela.kursy.domain;

public class Message {
	protected String message = "";

	public Message() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

}
