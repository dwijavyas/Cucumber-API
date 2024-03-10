package stepDefs;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
// static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.SetLocationBody;
import pojo.SetRequestBody;
import resources.HttpReq;
import resources.TestDataBuild;
import resources.Utils;

public class StepDef extends Utils{

	public ResponseSpecification resSpec;
	public RequestSpecification res;
	public Response response;
	TestDataBuild data = new TestDataBuild();
	//add static to access the placeId in all the test cases for one particular run
	static String placeId;

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		//Add Place - POST
		res = given().log().all().spec(reqSpecification()).body(data.addPlacePayload(name, language, address));
			
	}
	
	@When("user calls {string} API using {string} http request")
	public void user_calls_api_using_http_request(String resource, String method) {
				
		//create object to call the method 
		HttpReq httpresource = HttpReq.valueOf(resource);
				
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (method.equalsIgnoreCase("POST"))	
		response = res.when().post(httpresource.getresource());
		else if (method.equalsIgnoreCase("GET"))
		response = res.when().get(httpresource.getresource());
		
		}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    
		assertEquals(response.getStatusCode(),200);
		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String actualKey, String expectedValue) {
	    	
		assertEquals(getJsonPath(response,actualKey).toString(), expectedValue);
	
	}

	@Then("verify if place_id created maps to the {string} using {string}")
	public void verify_if_place_id_created_maps_to_the_using(String expectedName, String resource) throws IOException {
	    	   
		placeId =getJsonPath(response,"place_id");
		res = given().log().all().spec(reqSpecification()).queryParam("place_id", placeId);
		user_calls_api_using_http_request(resource, "GET");
		String actualName =getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
		
	}
		
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {

		res = given().log().all().spec(reqSpecification()).body(data.deletePlacePayload(placeId));
		
	}
	}


