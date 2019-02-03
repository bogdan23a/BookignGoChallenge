package part1;
import org.json.JSONArray;
import org.json.JSONObject;



public class JSONParser{

    public static RideResponse parseString(String rawJSON)
    			  throws Exception{

        JSONObject obj = new JSONObject(rawJSON);

        JSONArray arr = obj.getJSONArray("options");

        CarType[] carTypes = new CarType[arr.length()];
        int[] prices = new int[arr.length()];

        for(int i = 0; i < arr.length(); i++){
        	
            carTypes[i] = CarType.toCarType(arr.getJSONObject(i).getString("car_type"));
            prices[i] = arr.getJSONObject(i).getInt("price");
    
        }

        RideResponse response = new RideResponse(obj.getString("supplier_id").toString(),
                                                 obj.getString("pickup").toString(),
                                                 obj.getString("dropoff").toString(),
                                                 carTypes,
                                                 prices);

        return response;
    }
}