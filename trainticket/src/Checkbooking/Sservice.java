package Checkbooking;

public class Sservice {
	
	String profile,trainname,cabin,sit,date,from,to;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	public Sservice(String profile, String trainname, String cabin, String sit, String date, String from, String to) {
		super();
		this.profile = profile;
		this.trainname = trainname;
		this.cabin = cabin;
		this.sit = sit;
		this.date = date;
		this.from = from;
		this.to = to;
	}
	

}
