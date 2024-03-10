package stepDefs;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	//run this only when you want to run one test case (deleteplace), instead of running all
	//reusing the tests that are prerequisites for deleteplace test
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException{
		
		StepDef m = new StepDef();
		if(StepDef.placeId==null) {
		m.add_place_payload_with("lilac house","gujarati","empire center");
		m.user_calls_api_using_http_request("AddPlaceAPI", "POST");
		m.verify_if_place_id_created_maps_to_the_using("lilac house", "GetPlaceAPI");
		
		}
		
	}

}
