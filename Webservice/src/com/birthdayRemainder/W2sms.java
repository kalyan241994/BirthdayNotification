package com.birthdayRemainder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.codehaus.jettison.json.JSONObject;

public class W2sms {

	public String ConnectW2sms(String phoneNumber, String personName)
	{
		String url = "https://www.way2sms.com";
		try{
	          // construct data
	        JSONObject urlParameters = new JSONObject();
	        urlParameters.put("apikey","");
	        urlParameters.put("secret","");
	        urlParameters.put("usetype","stage");
	        urlParameters.put("phone",phoneNumber);
	        String message="Wish you many more Returns of the day: "+personName+ "\n By\n Gopichand";
	        urlParameters.put("message", URLEncoder.encode(message,"UTF-8"));
	        urlParameters.put("senderid","Bdynof");
	        URL obj = new URL(url + "/api/v1/sendCampaign");
	          // send data
	        HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
	        httpConnection.setDoOutput(true);
	        httpConnection.setRequestMethod("POST");
	        DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
	        wr.write(urlParameters.toString().getBytes());
	        // get the response  
	        BufferedReader bufferedReader = null;
	        if (httpConnection.getResponseCode() == 200) {
	            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
	        } else {
	            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
	        }
	        StringBuilder content = new StringBuilder();
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            content.append(line).append("\n");
	        }
	        bufferedReader.close();
	        return content.toString();
	      }catch(Exception ex){
	        System.out.printf("Exception at:",ex);
	        return "{'status':500,'message':'Internal Server Error'}";
	     }
	}

}
