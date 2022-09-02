package com.example.final_spring.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Utils {
	public String getDataTypeGet(String url) {
		StringBuilder reponseData = new StringBuilder();
		try {
			URL newURL = new URL(url); 
			HttpURLConnection connection = (HttpURLConnection) newURL.openConnection(); 
			connection.setRequestMethod("GET");
			
			InputStream inputStream = connection.getInputStream();
			
			InputStreamReader reader = new InputStreamReader(inputStream);

			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line = "";
	
			while ((line = bufferedReader.readLine()) != null) {
				reponseData.append(line);
			}

			bufferedReader.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reponseData.toString();

	}
}
