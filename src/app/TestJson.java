package app;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestJson {
    public String urlDataNextPage(String input) {
        JSONObject wholeFile = new JSONObject(input);
        String urlDataNextPage = wholeFile.optString("next");
        return urlDataNextPage;
    }

    public String jsonObjectMerge(String jsonString1, String jsonString2){
        JSONArray jsonArray1 = new JSONArray(jsonString1);
        JSONArray jsonArray2 = new JSONArray(jsonString2);

        JSONArray mergedArray = new JSONArray();

        for (int i = 0; i < jsonArray1.length(); i++){
            mergedArray.put(jsonArray1.getJSONObject(i));
        }
        for (int i = 0; i < jsonArray2.length(); i++){
            mergedArray.put(jsonArray2.getJSONObject(i));
        }

        String mergedJsonStr = mergedArray.toString();
        return mergedJsonStr;
    }

    public String returnDroneData(String input) {
        JSONObject wholeFile = new JSONObject(input);
        JSONArray jsonFile = wholeFile.getJSONArray("results");
        return jsonFile.toString();
    }

    public static void test(String input) {
        JSONObject wholeFile = new JSONObject(input);
        JSONArray jsonFile = wholeFile.getJSONArray("results");
        for (int i = 0; i < jsonFile.length(); i++) {
            JSONObject o = jsonFile.getJSONObject(i);
            if (o.has("carriage_type") && o.has("carriage_weight")) {
                String a = o.getString("carriage_type");
                int b = o.getInt("carriage_weight");
                int id = o.getInt("id");
                System.out.println("Drone " + id + ": carriage type " + a + " (weight: " + b + "g)");
            }
        }
        System.out.println("Test function completed.");
    }

    public static String formatJson(String input) {
        final int indentSpaces = 4;
        Object json = new JSONTokener(input).nextValue();

        if (json instanceof JSONObject) {
            JSONObject o = (JSONObject) json;

            return o.toString(indentSpaces);
        } else if (json instanceof JSONArray) {
            return ((JSONArray) json).toString(indentSpaces);
        } else {
            throw new IllegalArgumentException("Input string is not a valid JSON");
        }
    }

    public String fetchJsonData(String urlToConnect){
        return fetchJsonData(urlToConnect, 100);
    }

    public String fetchJsonData(String urlToConect, int pageLimit) {
        Dotenv dotenv = Dotenv.configure().load();
        String user_agent = dotenv.get("USER_AGENT");
        String urlToConnect = dotenv.get(urlToConect);
        String token = dotenv.get("TOKEN");
        System.out.println("\nStarting getting data from the API: " + urlToConect);

        String jsonData = "[]";
        URL url;
        int page = 0;
        while (!urlToConnect.isEmpty() && page < pageLimit ) {
            try {
                url = new URL(urlToConnect);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", token);
                connection.setRequestProperty("User-Agent", user_agent);

//                int responseCode = connection.getResponseCode();
//                System.out.println("Response Code " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String jsonResponse = response.toString();
//                System.out.println("Connection succesfull: " + urlToConect);
                System.out.println("\t└── Page " + page + " " + jsonResponse);
                jsonData = jsonObjectMerge(jsonData, returnDroneData(jsonResponse));
                urlToConnect = urlDataNextPage(jsonResponse);
                page++;
            } catch (MalformedURLException e) {
                System.err.println("Malformed URL: " + e.getLocalizedMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("General IO Exception: " + e.getLocalizedMessage());
                e.printStackTrace();
            }

        }
        System.out.println("\t\t└── Merge Data: " + jsonData);
        return jsonData;
    }
}
