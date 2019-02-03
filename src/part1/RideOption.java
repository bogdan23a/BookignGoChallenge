package part1;
public class RideOption implements Comparable<RideOption>{

    public CarType car_Type;
    public int price;
    public String supplier;

    public RideOption(CarType carType, int price){

        this.car_Type = carType;
        this.price = price;
    }
    
    public RideOption(CarType carType, int price, String supplier){

        this.car_Type = carType;
        this.price = price;
        this.supplier = supplier;
    }
    
    public void addSupplier(String supplier) {
    	
    	this.supplier = supplier;
    }
    
	@Override
	public int compareTo(RideOption o) {
		// TODO Auto-generated method stub
		return Integer.compare(price, o.price);
	}
}