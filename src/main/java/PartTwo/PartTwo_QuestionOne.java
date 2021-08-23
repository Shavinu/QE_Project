package PartTwo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PartTwo_QuestionOne {

	public static void main(String[] args) {
		try 
		{
			String url = "https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			List<String> list = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			
			//Type define
			con.setRequestMethod("GET");
			//Request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			//Repetition to append all
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			// print in String
			System.out.println(response.toString());
			System.out.println("\n");
			JSONObject myresponse = new JSONObject(response.toString());

			//Getting the "Suggesstions" details
			JSONArray jsonArray = myresponse.getJSONArray("suggestions");
			for (int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.getJSONObject(i).getString("term"));
				System.out.println(jsonArray.getJSONObject(i).getString("term")); // display term field
			}
			
			System.out.println("\n");
			
			//Getting the "Titles"containing "Wiley" keyword			
			JSONArray jsonArray2 = myresponse.getJSONArray("pages");
			for (int i = 0; i < jsonArray2.length(); i++) {
				list2.add(jsonArray2.getJSONObject(i).getString("title"));
				System.out.println(jsonArray2.getJSONObject(i).getString("title")+" - is the word contains wiley -  "
				+jsonArray2.getJSONObject(i).getString("title").toLowerCase().contains("wiley")); // display title
			}
		} 		
		catch (Exception e) {
			System.err.println(e);
		}
	}
}
