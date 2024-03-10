package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.SetLocationBody;
import pojo.SetRequestBody;

public class TestDataBuild {
	
	public SetRequestBody addPlacePayload(String name, String language, String address) {
		
		//rest assured will convert the java object into json - put that java object in the body
				SetRequestBody p = new SetRequestBody();
				p.setAccuracy(50);
				p.setAddress(address);
				p.setLanguage(language);
				p.setName(name);
				p.setPhone_number("(+91) 983 893 3937");
				p.setWebsite("http://google.com");
				List<String> myList = new ArrayList<String>();
				myList.add("shoe park");
				myList.add("shop");
				p.setType(myList);
				SetLocationBody l = new SetLocationBody();
				l.setLat(-38.383494);
				l.setLng(33.427362);
				p.setLocation(l);
				return p;
	}
	
	public String deletePlacePayload(String placeId) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}\r\n"
				+ "";
		
	}

}
