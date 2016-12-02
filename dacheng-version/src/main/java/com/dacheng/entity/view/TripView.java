package com.dacheng.entity.view;

import java.util.List;

import com.dacheng.entity.Trip;

public class TripView {
	private String mileage;
	private String tripfuel;
	private String fuelfee;
	private List<Trip> trips;
	
	public TripView() {}
	
	public TripView(String mileage, String tripfuel, String fuelfee, List<Trip> trips) {
		this.mileage = mileage;
		this.tripfuel = tripfuel;
		this.fuelfee = fuelfee;
		this.trips = trips;
	}

	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getTripfuel() {
		return tripfuel;
	}
	public void setTripfuel(String tripfuel) {
		this.tripfuel = tripfuel;
	}
	public String getFuelfee() {
		return fuelfee;
	}
	public void setFuelfee(String fuelfee) {
		this.fuelfee = fuelfee;
	}
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
}