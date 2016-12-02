package com.dacheng.entity;

public class Trip {
	private int tripid;
	private Car car;
	private String starttime;
	private String endtime;
	private String score;
	private String fuelclass;
	private String driveclass;
	private String mileage;
	private String triptime;
	private String averagespeed;
	private String averagefuel;
	private String tripfuel;
	private String topSpeed;
	private String topRPM;
	private int idletime;
	
	public String getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}
	public String getTopRPM() {
		return topRPM;
	}
	public void setTopRPM(String topRPM) {
		this.topRPM = topRPM;
	}
	private String fuelfee;
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getFuelclass() {
		return fuelclass;
	}
	public void setFuelclass(String fuelclass) {
		this.fuelclass = fuelclass;
	}
	public String getDriveclass() {
		return driveclass;
	}
	public void setDriveclass(String driveclass) {
		this.driveclass = driveclass;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getTriptime() {
		return triptime;
	}
	public void setTriptime(String triptime) {
		this.triptime = triptime;
	}
	public String getAveragespeed() {
		return averagespeed;
	}
	public void setAveragespeed(String averagespeed) {
		this.averagespeed = averagespeed;
	}
	public String getAveragefuel() {
		return averagefuel;
	}
	public void setAveragefuel(String averagefuel) {
		this.averagefuel = averagefuel;
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
	public int getIdletime() {
		return idletime;
	}
	public void setIdletime(int idletime) {
		this.idletime = idletime;
	}
}