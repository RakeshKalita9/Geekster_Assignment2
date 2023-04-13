package com.Geekster_Assignment.Geekster_Assignment2;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class GeeksterAssignment2Application {

	public static void main(String[] args) throws Exception {

		URL getUrl = new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");


		int responseCode = connection.getResponseCode();

		if (responseCode == 200) {


			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;


			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}

			in.close();
			JSONObject masterData = new JSONObject(jsonResponseData.toString());

			System.out.println("post code->"+masterData.get("post code"));
			System.out.println("country->"+masterData.get("country"));
			System.out.println("country abbreviation->"+masterData.get("country abbreviation"));
			System.out.println("places->"+masterData.get("places"));
		}
		else {
			System.out.println("This is not valid URL- " + responseCode);
		}


	}

}