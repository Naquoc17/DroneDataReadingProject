package dataFunction;

import java.util.ArrayList;
import java.util.List;
import java.time.ZonedDateTime;

import org.json.*;

public class ParserJson
{
    public static List<DroneData> parseJsonToDroneData(String jsonData)  {
        List<DroneData> droneDataList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                DroneData droneData = new DroneData(
                        jsonObject.getInt("id"),
                        jsonObject.getString("dronetype"),
                        jsonObject.getString("created"),
                        jsonObject.getString("serialnumber"),
                        jsonObject.getInt("carriage_weight"),
                        jsonObject.getString("carriage_type")
                );
                droneDataList.add(droneData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("ParserJsonToDroneData successful");
        return droneDataList;
    }


    public static List<DroneDynamics> parseJsonToDroneDynamics(String jsonData) {
        List<DroneDynamics> droneDynamicsList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                DroneDynamics droneDynamics = new DroneDynamics(
                        ZonedDateTime.parse(jsonObject.getString("timestamp")),
                        jsonObject.getString("drone"),
                        jsonObject.getInt("speed"),
                        jsonObject.getDouble("align_roll"),
                        jsonObject.getDouble("align_pitch"),
                        jsonObject.getDouble("align_yaw"),
                        jsonObject.getDouble("longitude"),
                        jsonObject.getDouble("latitude"),
                        jsonObject.getInt("battery_status"),
                        ZonedDateTime.parse(jsonObject.getString("last_seen")),
                        jsonObject.getString("status")
                );
                droneDynamicsList.add(droneDynamics);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("parseJsonToDroneDynamics successful");
        return droneDynamicsList;
    }

    public static List<DroneTypes> parseJsonToDroneTypes(String jsonData){
        List<DroneTypes> droneTypesList = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                DroneTypes droneTypes = new DroneTypes(
                        jsonObject.

                                getInt("control_range"),
                        jsonObject.getInt("max_carriage"),
                        jsonObject.getInt("weight"),
                        jsonObject.getInt("max_speed"),
                        jsonObject.getInt("id"),
                        jsonObject.getInt("battery_capacity"),
                        jsonObject.getString("typename"),
                        jsonObject.getString("manufacturer")
                );
                droneTypesList.add(droneTypes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("parseJsonToDroneTypes successful");
        return droneTypesList;
    }

}
