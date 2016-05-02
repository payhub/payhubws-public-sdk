/**
 * 
 */
package com.payhub.ws.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.omg.CORBA.portable.OutputStream;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payhub.ws.api.Errors;
import com.payhub.ws.api.SaleResponseInformation;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * @author agustin
 *
 */
public class WsConnections {
	private static String token;
	public static String getToken() {
        return token;
}
	public WsConnections(){}
	public WsConnections(String token){
		this.token=token;
	}
	private void setToken(String token) {
		// TODO Auto-generated method stub
		this.token=token;
	}
	public HttpURLConnection setHeadersPost(String operationUrl, String token) throws IOException
    {
		this.setToken(token);
		URL connection = new URL(operationUrl);
		HttpURLConnection request = (HttpURLConnection)connection.openConnection();
		request.setDoOutput(true);
        request.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        request.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        request.setRequestMethod("POST");
        request.setRequestProperty("Authorization", "Bearer " + token);
        request.setRequestProperty("Accept","application/json");
        return request;
    }
    
	public HttpURLConnection setHeadersGet(String operationUrl, String token) throws IOException
    {
    	//setToken(token);
    	URL connection = new URL(operationUrl);
		HttpURLConnection request = (HttpURLConnection)connection.openConnection();
		request.setDoOutput(true);
        request.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        request.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        request.setRequestMethod("GET");
        request.setRequestProperty("Authorization", "Bearer " + token);
        request.setRequestProperty("Accept","application/json");
        return request;
    }
	protected HttpURLConnection setHeadersPut(String metadataUrl, String token) throws IOException {
		URL connection = new URL(metadataUrl);
		HttpURLConnection request = (HttpURLConnection)connection.openConnection();
		request.setDoOutput(true);
        request.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        request.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        request.setRequestMethod("PUT");
        request.setRequestProperty("Authorization", "Bearer " + token);
        request.setRequestProperty("Accept","application/json");
        return request;
	}
	
    public String doPost(HttpURLConnection request, String _url)
    {
        String result = null;
        String responseObject;
        try
        {               
        	int statusCode = request.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + _url);
			System.out.println("Response Code : " + statusCode);
			
			InputStream is = null;
			if (statusCode >= 200 && statusCode < 400) {
				   // Create an InputStream in order to extract the response object
					is = request.getInputStream();
				   	BufferedReader in = new BufferedReader(new InputStreamReader(is));
					String inputLine;
					StringBuffer response = new StringBuffer();
					
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					
					String completePath = request.getHeaderField("Location");
					int lastSlash = completePath.lastIndexOf("/");
		            String transactionId = completePath.substring(lastSlash + 1);
		            String token = getToken();
		            HttpURLConnection responseDataRequest = setHeadersGet(_url + transactionId, token);
		            return responseObject=doGet(responseDataRequest);
				}
				else {
					is = request.getErrorStream();
					StringBuffer response = new StringBuffer();   	
	            	BufferedReader er = new BufferedReader(new InputStreamReader(is));	            	
				   try {
					     int c = 0;
					     while((c = er.read()) != -1) {					         
					          response.append((char)c);
					     }
	 						result = response.toString(); 
	 				} catch (IOException e) {
	 					// TODO Auto-generated catch block
	 					System.out.println(e.getMessage());
	 				}
				   
				   if(statusCode==401){
					    JSONObject errors = new JSONObject();
						ObjectMapper mapper = new ObjectMapper();
					    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				    	Errors _error  = mapper.readValue(result, Errors.class);
				    	List<Errors>error = new ArrayList<Errors>();
				    	error.add(_error);
				    	errors.put("errors",error);
				    	result = errors.toString();
				   }if(statusCode==400 && StringUtils.isNotBlank(result)){
					   JSONObject aux = new JSONObject(result);
					   if(aux.get("errors")!=null){
						   return result;
					   }
					    JSONObject errors = new JSONObject();
						ObjectMapper mapper = new ObjectMapper();
					    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				    	Errors _error  = mapper.readValue(result, Errors.class);
				    	List<Errors>error = new ArrayList<Errors>();
				    	error.add(_error);
				    	errors.put("errors",error);
				    	result = errors.toString();
				   }else{
					   JSONObject errors = new JSONObject();
					   Errors _error = new Errors();
                       _error.setStatus("BAD_REQUEST");
                       _error.setCode("9995");
                       _error.setLocation("404 not found.");
                       _error.setReason("404 There aren't results");
                       _error.setSeverity("ERROR");
                       List<Errors>error = new ArrayList<Errors>();
				    	error.add(_error);
				    	errors.put("errors",error);
				    	result = errors.toString();
				   }
				   	
	                return result;
				}
        }
        catch (IOException wex)
        {
            if (!wex.getMessage().isEmpty())
            {
            	result=wex.getMessage();
            	System.out.println(wex.getMessage());
            }
        }
        return result;
    }
    public String doGet(HttpURLConnection responseDataRequest)
    {
    	//StringBuffer response = new StringBuffer();  
    	String result = null;
        try
        {
        	int statusCode=responseDataRequest.getResponseCode();
        	InputStream is=null;
        	if (statusCode >= 200 && statusCode < 400) {
        		// Create an InputStream in order to extract the response object
				is = responseDataRequest.getInputStream();
	        	BufferedReader in = new BufferedReader(new InputStreamReader(is));
	        	String line;
	        	StringBuffer response = new StringBuffer();
	        	while ((line = in.readLine()) != null){ 
	        		response.append(line); 
	        	}
	        		in.close();
	                return response.toString();
        	}else{
				is = responseDataRequest.getErrorStream();
				StringBuffer response = new StringBuffer();   	
				if(is!=null){
					BufferedReader er = new BufferedReader(new InputStreamReader(is));	            	
					   try {
						     int c = 0;
						     while((c = er.read()) != -1) {					         
						          response.append((char)c);
						     }
		 						result = response.toString(); 
		 				} catch (IOException e) {
		 					// TODO Auto-generated catch block
		 					System.out.println(e.getMessage());
		 				}
					   
				}
            	
			   if(statusCode==401){
				    JSONObject errors = new JSONObject();
					ObjectMapper mapper = new ObjectMapper();
				    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			    	Errors _error  = mapper.readValue(result, Errors.class);
			    	List<Errors>error = new ArrayList<Errors>();
			    	error.add(_error);
			    	errors.put("errors",error);
			    	result = errors.toString();
			   }if(statusCode==400 && StringUtils.isNotBlank(result)){
				   JSONObject errors = new JSONObject();
					ObjectMapper mapper = new ObjectMapper();
				    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			    	Errors _error  = mapper.readValue(result, Errors.class);
			    	List<Errors>error = new ArrayList<Errors>();
			    	error.add(_error);
			    	errors.put("errors",error);
			    	result = errors.toString();
			   }else{
				   JSONObject errors = new JSONObject();
				   Errors _error = new Errors();
                   _error.setStatus("BAD_REQUEST");
                   _error.setCode("9995");
                   _error.setLocation("404 not found.");
                   _error.setReason("404 There aren't results");
                   _error.setSeverity("ERROR");
                   List<Errors>error = new ArrayList<Errors>();
			    	error.add(_error);
			    	errors.put("errors",error);
			    	result = errors.toString();
			   }
			   	
                return result;
			}
        }
        catch (IOException wex)
             {
                 if (!wex.getMessage().isEmpty())
                 {
                	 StringBuffer response = new StringBuffer();  
                	 try {
       
	                 	BufferedReader er = new BufferedReader(new InputStreamReader(responseDataRequest.getErrorStream()));
	                 	String line;
	                 	
	                 		int c = 0;
						     while((c = er.read()) != -1) {					         
						          response.append((char)c);
						     }					    
	     						 
	     				} catch (IOException e) {
	     					// TODO Auto-generated catch block
	     					e.printStackTrace();
	     				}
                    return response.toString();
                 }
        }
        return null;
    }
    public String doPut(HttpURLConnection responseDataRequest,String json) throws IOException
    {
    	DataOutputStream wr;
    	wr = new DataOutputStream(responseDataRequest.getOutputStream());
		wr.writeBytes(json);
		wr.flush();
		wr.close();	
		
    	StringBuffer response = new StringBuffer();   	
    	int statusCode = responseDataRequest.getResponseCode();
		System.out.println("\nSending 'Put' request to URL");
		System.out.println("Response Code : " + statusCode);
		if (statusCode >= 200 && statusCode < 400) {
			return "";
		}else{
			BufferedReader er = new BufferedReader(new InputStreamReader(responseDataRequest.getErrorStream()));
         	String line;
         	try {
         		int c = 0;
			     while((c = er.read()) != -1) {					         
			          response.append((char)c);
			     }					    
						 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            return response.toString();
		}  	           
    }
    public String findTransactionReports(HttpURLConnection responseDataRequest,String json) throws IOException
    {
    	DataOutputStream wr;
    	wr = new DataOutputStream(responseDataRequest.getOutputStream());
		wr.writeBytes(json);
		wr.flush();
		wr.close();	
		
    	StringBuffer response = new StringBuffer();   	
    	int statusCode = responseDataRequest.getResponseCode();
		System.out.println("Response Code : " + statusCode);
		if (statusCode >= 200 && statusCode < 400) {
			BufferedReader in = new BufferedReader(new InputStreamReader(responseDataRequest.getInputStream()));
        	String line;
        	while ((line = in.readLine()) != null){ 
        		response.append(line); 
        	}
        		in.close();
                return response.toString();   	
		}else{
			BufferedReader er = new BufferedReader(new InputStreamReader(responseDataRequest.getErrorStream()));
         	String line;
         	try {
         		int c = 0;
			     while((c = er.read()) != -1) {					         
			          response.append((char)c);
			     }					    
						 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            return response.toString();
		}  	           
    }
    
    public String doPatch(String url,String token,String json) throws IOException
    {
    	OkHttpClient client = new OkHttpClient();

    	MediaType mediaType = MediaType.parse("application/json");
    	RequestBody body = RequestBody.create(mediaType, json);
    	Request request = new Request.Builder().url(url)
    	  .patch(body)
    	  .addHeader("accept", "application/json")
    	  .addHeader("content-type", "application/json")
    	  .addHeader("authorization", "Bearer "+token)
    	  .addHeader("cache-control", "no-cache")
    	  .build();

    	Response responseDataRequest = client.newCall(request).execute();   
    	int statusCode = responseDataRequest.code();
    	if (statusCode >= 200 && statusCode < 400) {
    		return "";
    	}else{
			String bodys = responseDataRequest.body().toString();			
		   if(statusCode==401){
			    JSONObject errors = new JSONObject();
				ObjectMapper mapper = new ObjectMapper();
			    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		    	Errors _error  = mapper.readValue(bodys, Errors.class);
		    	List<Errors>error = new ArrayList<Errors>();
		    	error.add(_error);
		    	errors.put("errors",error);
		    	return errors.toString();
		   }if(statusCode==400 && StringUtils.isNotBlank(bodys)){
			   JSONObject errors = new JSONObject();
				ObjectMapper mapper = new ObjectMapper();
			    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		    	Errors _error  = mapper.readValue(bodys, Errors.class);
		    	List<Errors>error = new ArrayList<Errors>();
		    	error.add(_error);
		    	errors.put("errors",error);
		    	return errors.toString();
		   }else{
			   JSONObject errors = new JSONObject();
			   Errors _error = new Errors();
               _error.setStatus("BAD_REQUEST");
               _error.setCode("9995");
               _error.setLocation("404 not found.");
               _error.setReason("404 There aren't results");
               _error.setSeverity("ERROR");
               List<Errors>error = new ArrayList<Errors>();
		    	error.add(_error);
		    	errors.put("errors",error);
		    	return errors.toString();
		   }		   	
		}
    }
    public String doPostForUserRole(String url,String token,String json) throws IOException
    {
    	OkHttpClient client = new OkHttpClient();

    	MediaType mediaType = MediaType.parse("application/json");
    	RequestBody body = RequestBody.create(mediaType, json);
    	Request request = new Request.Builder().url(url)
    	  .post(body)
    	  .addHeader("accept", "application/json")
    	  .addHeader("content-type", "application/json")
    	  .addHeader("authorization", "Bearer "+token)
    	  .addHeader("cache-control", "no-cache")
    	  .build();

    	Response response = client.newCall(request).execute();   
    	if(response.code()>=200 && response.code()<400){
    		return "";
    	}else{    		
	    	StringBuffer responseB = new StringBuffer();   	
	    	BufferedReader er = new BufferedReader(new InputStreamReader(response.body().byteStream()));
	     	String line;
	     	try {
	     		int c = 0;
			     while((c = er.read()) != -1) {					         
			    	 responseB.append((char)c);
			     }					    
						 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        return responseB.toString();
    	}
    }
}
