package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.Scanner;

import javax.naming.ContextNotEmptyException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Weather
 */
@WebServlet("/Weather")
public class Weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String city=request.getParameter("city");
		String api_key="3f946c88f3ae1806cb2a503c4d190ae9";
		String url="https://api.openweathermap.org/data/2.5/weather?q=" + city+ "&appid=" + api_key;
		
		try {
			URL url1=new URL(url);
			HttpURLConnection url2=(HttpURLConnection)url1.openConnection();
			url2.setRequestMethod("GET");
			InputStream input=url2.getInputStream();
			InputStreamReader inputReader=new InputStreamReader(input);
			StringBuilder responsecontent=new StringBuilder();
			Scanner sc=new Scanner(inputReader);
			while(sc.hasNext()) {
				responsecontent.append(sc.nextLine());
			}
			//out.print(responsecontent);
			
			  Gson gson = new Gson();
		        JsonObject jsonObject = gson.fromJson(responsecontent.toString(), JsonObject.class);

		        // Extract specific values
		        JsonObject coord = jsonObject.getAsJsonObject("coord");
		        double lon = coord.get("lon").getAsDouble();
		        double lat = coord.get("lat").getAsDouble();

		        JsonArray weatherArray = jsonObject.getAsJsonArray("weather");
		        JsonObject weatherObj = weatherArray.get(0).getAsJsonObject();
		        String description = weatherObj.get("description").getAsString();

		        JsonObject main = jsonObject.getAsJsonObject("main");
		        double temperature = main.get("temp").getAsDouble();
		        int humidity = main.get("humidity").getAsInt();

		        // You can extract more values similarly

		        // Example usage:
				/*
				 * out.println("Longitude: " + lon); out.println("Latitude: " + lat);
				 * out.println("Description: " + description); out.println("Temperature: " +
				 * temperature); out.println("Humidity: " + humidity);
				 */
			
		        
		        request.setAttribute("lon", lon);
		        request.setAttribute("lat", lat);
		        request.setAttribute("description", description);
		        request.setAttribute("temperature", temperature);
		        request.setAttribute("humidity", humidity);

		        // Forward the request to the JSP page
		        RequestDispatcher dispatcher = request.getRequestDispatcher("Output.jsp");
		        dispatcher.forward(request, response);
		       
			
			
			
		}
		catch(Exception e) {
		 e.printStackTrace();
			
		}
	}

}
