package resources;

public enum HttpReq {

	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;
	
	HttpReq(String resource) {
		
		this.resource = resource;
		
	}
	
	public String getresource(){
		
		return resource;
	}
	
	
}
