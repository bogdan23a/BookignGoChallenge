package part1;
import java.util.ArrayList;

public class RideResponse{

    public String supplier_id;
    public String pickup;
    public String dropoff;
    public ArrayList<RideOption> rides;

    public RideResponse(String supplier_id, String pickup, String dropoff, 
    					CarType[] carsType, int[] prices){

        this.supplier_id = supplier_id;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.rides = new ArrayList<RideOption>();
        for(int i = 0; i < carsType.length; i++)
            this.rides.add(new RideOption(carsType[i], prices[i], supplier_id));

    }
    
    public RideResponse(RideOption[] rides){

    this.rides = new ArrayList<RideOption>();
	for(int i = 0; i < rides.length; i++)
		this.rides.add(new RideOption(rides[i].car_Type, 
									   rides[i].price, 
									   rides[i].supplier));

    }
}