package coeur;

import java.awt.Window;

import fonctionscommunes.CommonFunction;

public class ApiData {
	public static void main(String args[]){
		CommonFunction commonfunction = new CommonFunction();

//		Dbvalidations.crxdeDataExtraction();
	
		RestassuredApi service = new RestassuredApi();
		String getURI = "https://restapi.demoqa.com/utilities/weather/city";
		String postURI = "https://restapi.demoqa.com/customer";
		
		int code=service.getData(postURI);
		System.out.println("This is the status code: "+code);	
}
	
	
	
	
	
	
	
}