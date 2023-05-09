package com.gowtham.chat;

public class Details {
	String Name;
	String Message;
	String Time;
	
	public Details(String Name,String Message, String Time){
		this.Name = Name;
		this.Message = Message;
		this.Time= Time;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
}
