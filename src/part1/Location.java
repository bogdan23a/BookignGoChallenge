package part1;
public class Location {

    private String pickupLatitude;
    private String dropoffLatitude;
    private String pickupLongitude;
    private String dropoffLongitude;

    public Location(){


    }
    public Location(String pickupLatitude, String dropoffLatitude, String pickupLongitude, String dropoffLongitude){

        this.pickupLatitude = pickupLatitude;
        this.dropoffLatitude = dropoffLatitude;
        this.pickupLongitude = pickupLongitude;
        this.dropoffLongitude = dropoffLongitude;
        
    }

    public void addPickupLatitude(String pickupLatitude){

        this.pickupLatitude = pickupLatitude;
    }

    public void addPickupLongitude(String pickupLongitude){

        this.pickupLongitude = pickupLongitude;
    }

    public void addDropoffLatitude(String dropoffLatitude){

        this.dropoffLatitude = dropoffLatitude;
    }

    public void addDropoffLongitude(String dropoffLongitude){

        this.dropoffLongitude = dropoffLongitude;
    }

    public String getPickupLatitude(){

        return pickupLatitude;
    }

    public String getDropoffLatitude(){

        return dropoffLatitude;
    }

    public String getPickupLongitude(){

        return pickupLongitude;
    }

    public String getDropoffLongitude(){

        return dropoffLongitude;
    }
}