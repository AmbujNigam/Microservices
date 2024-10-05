package com.demo.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnr;
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int pnr;
	@Column(nullable = false) 
	private String name;
	@Column(nullable = false) 
	private String flight_name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String meal_type;
	@Column(nullable = false)
	private long phone;
	@Column(nullable = false)
	private double age;
	@Column(nullable = false) 
	private int no_of_businessSeats;
	@Column(nullable = false) 
	private int no_of_genaralSeats;
	@Column(nullable = false) 
	private int seat_number;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMeal_type() {
		return meal_type;
	}
	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}
	
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	/*public int getNo_of_passengers() {
		return no_of_passengers;
	}
	public void setNo_of_passengers(int no_of_passengers) {
		this.no_of_passengers = no_of_passengers;
	} */
	public int getNo_of_businessSeats() {
		return no_of_businessSeats;
	}
	public void setNo_of_businessSeats(int no_of_businessSeats) {
		this.no_of_businessSeats = no_of_businessSeats;
	}
	public int getNo_of_genaralSeats() {
		return no_of_genaralSeats;
	}
	public void setNo_of_genaralSeats(int no_of_genaralSeats) {
		this.no_of_genaralSeats = no_of_genaralSeats;
	}
	
	
	
	
}
