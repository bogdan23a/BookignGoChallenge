import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import part1.JSONParser;
import part1.Location;
import part1.RideOption;
import part1.RideResponse;

/*
 * Program solving the part 1 of the BookingGo Technical Test
 */
public class Part1{

    public static void main(String[] args) throws Exception{
    	
    	processInput(args);

    }
    
    public static boolean processInput(String[] args) throws Exception{
    	
    	if(args.length > 7) {
    		System.out.println("Too many arguments given!");
    		return false;
    	}
    	else if(args.length < 1) {
    		System.out.println("Please specify type of request(dave/cheapest)");
    		return false;
    	}
    	else if (args.length < 4) {
    		
    		System.out.println("Please give the location as a 4 number pair!");
    		return false;
    	}
    	else if(args.length < 6) {
    		System.out.println("Please give the number of passangers!");
    		return false;
    	}
    	
    	String requestType = args[0];
    	
    	// get locations from user input
    	try {
    		
    		Double l1 = Double.parseDouble(args[1]);
    		Double l2 = Double.parseDouble(args[2]);
    		Double l3 = Double.parseDouble(args[3]);
    		Double l4 = Double.parseDouble(args[4]);
    		
    	}
    	catch(Exception e) {
    		
    		System.out.println("Invalid Given Location!");
    		return false;
    	}
    	
    	Location newLocation = new Location(args[1], args[2], args[3], args[4]);
    	
    	
        // get number of seats
        int numberOfSeats = 1;
        
        try {
        	
        	numberOfSeats = Integer.parseInt(args[5]);
        }
        catch(Exception e) {
        	
        	System.out.println("Invalid Given Number of Seats!");
        	return false;
        }
        
        ArrayList<RideOption> response = null;
        
        if(requestType.equals("dave")) {
        	
        	//get only daves' response cars
        	response = getDaveRides(newLocation);
        	System.out.println("Daves' rides are: ");
        }
        else {
        	
        	//get a sorted array of cheapest cars available
	        response = decideSupplier(newLocation);
	        System.out.println("Cheapest rides found are: ");
        }
        // print every car available with the corresponding price
        for(RideOption option : response)
        	if(option.car_Type.seats > numberOfSeats)
	            System.out.println(option.car_Type + " - " + 
	            					option.supplier + " - " + 
	            					option.price);
        
        return true;
    	
    }
    
    public static ArrayList<RideOption> getDaveRides(Location location) throws Exception{
    	
    	RideResponse daveResponse = getRideResponse(location, "dave");
    	
    	ArrayList<RideOption> daveRides = new ArrayList<RideOption>();
    	
    	if(daveResponse != null)
    		daveRides.addAll(daveResponse.rides);
    	
    	Collections.sort(daveRides);
    	
    	return daveRides;    	
    }
    public static ArrayList<RideOption> decideSupplier(Location location) throws Exception{
    	
    	// get each supplier 
 
    	// request options for each
    	RideResponse daveResponse = getRideResponse(location, "dave");
        RideResponse ericResponse = getRideResponse(location, "eric");
        RideResponse jeffResponse = getRideResponse(location, "jeff");
        
        // save all the options in one pool
        ArrayList<RideOption> pool = new ArrayList<RideOption>();
    	
        if(daveResponse != null)
        	pool.addAll(daveResponse.rides);
        
        if(ericResponse != null)
        	pool.addAll(ericResponse.rides);
        
    	if(jeffResponse != null)
    		pool.addAll(jeffResponse.rides);
    	
    	// order the array to get the cheapest options
    	Collections.sort(pool);
    	
    	// keep just the first occurrences and delete all else
    	pool = removeDuplicates(pool);
    	
    	return pool;
    }
    
    
    private static ArrayList<RideOption> removeDuplicates(ArrayList<RideOption> options) {
		
    	int currentIndex = 0;
    	
    	while(currentIndex <= options.size()) {
    		
	    	for(int i = currentIndex + 1; i < options.size(); i++) {
	    		
	    		if(options.get(i).car_Type == options.get(currentIndex).car_Type) {
	    		
	    			options.remove(i);
	    			i--;
	    		}
	    		
	    	}
	    	currentIndex++;
    	}
    	return options;
    	
		
	}

	public static RideResponse getRideResponse(Location location, String supplier) throws Exception{
    	
		URL url = new URL("https://techtest.rideways.com/" + supplier + "?pickup=" 
                + location.getPickupLatitude() + "," 
                + location.getPickupLongitude() + "&dropoff=" 
                + location.getDropoffLatitude() + "," 
                + location.getDropoffLongitude());
		
    	HttpURLConnection conn = null;
    	RideResponse response = null;
    	
        // create the connection to the URL
        try {
        	
        	conn = (HttpURLConnection) url.openConnection();
        	conn.setRequestMethod("GET");
        	
        	// retrieve the JSON information from the source
            String rawJSON = getResponse(conn);
            
            // parse the rawJSON into a RideResponse object            
            if(!rawJSON.isEmpty())
            	response = JSONParser.parseString(rawJSON);
        	
        }
        catch(UnknownHostException e) {
        	
        	System.out.println("Check Internet Connection!" + e.getMessage());
        	
        }
        catch(Exception ex) {
        	
        	System.out.println("Unknown Error" + ex.getMessage());
        }
        
        return response;    	
    }
    
    public static String getResponse(HttpURLConnection conn) throws IOException {

    	BufferedReader br = null;
    	StringBuffer response = new StringBuffer();
    	
    	try {
    		
    		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String inputLine;

            while((inputLine = br.readLine()) != null){

                response.append(inputLine);

            }
            br.close();
    	}
    	catch(Exception e){
    		
    		System.out.println("Connection error!");
    	}
        
		    	
        return response.toString();
    }

}
