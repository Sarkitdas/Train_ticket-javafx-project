package ticketcounter;


public class Service {
	private String trainname;
    private String derived;
    private String arrived;
    private String from_time;
    private String to_time;
    private String price;
    
    
    
    
    
	public String getTrainname() {
		return trainname;
     }





	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}





	public String getFrom_time() {
		return from_time;
	}





	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}





	public String getTo_time() {
		return to_time;
	}





	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}





	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDerived() {
		return derived;
	}





	public void setDerived(String derived) {
		this.derived = derived;
	}





	public String getArrived() {
		return arrived;
	}


	public void setArrived(String arrived) {
		this.arrived = arrived;
	}


	public Service(String trainname, String derived, String arrived, String from_time, String to_time, String price)
	{
		this.trainname = trainname;
		this.from_time = from_time;
		this.to_time = to_time;
		this.price = price;
		this.arrived=arrived;
		this.derived=derived;
		
	}

}





	