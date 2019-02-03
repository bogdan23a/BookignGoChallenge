package part1;
public enum CarType{

        STANDARD(4) {
                	
        	public String toString() {
        		
        		return "Standard";
        	}
        }, 
        EXECUTIVE(4) {
        	        	
        	public String toString() {
        		
        		return "Executive";
        	}
        }, 
        LUXURY(4) {
        	        	
        	public String toString() {
        		
        		return "Luxury";
        	}
        	
        },
        PEOPLE_CARRIER(6) {
        	        	
        	public String toString() {
        		
        		return "People Carrier";
        	}
        },
        LUXURY_PEOPLE_CARRIER(6) {
        	
        	public String toString() {
        		
        		return "Luxury People Carrier";
        	}
        },
        MINIBUS(16) {
        	        	
        	public String toString() {
        		
        		return "Minibus";
        	}
        };
	
	public final int seats;
	
    CarType(final int seats){
    	
    	this.seats = seats;
    }

	public static CarType toCarType(String string) {
		
		switch(string) {
		
			case "STANDARD": return CarType.STANDARD;
			case "EXECUTIVE": return CarType.EXECUTIVE;
			case "LUXURY": return CarType.LUXURY;
			case "LUXURY_PEOPLE_CARRIER": return CarType.LUXURY_PEOPLE_CARRIER;
			case "MINIBUS": return CarType.MINIBUS;
			case "PEOPLE_CARRIER": return CarType.PEOPLE_CARRIER;
			default: return CarType.STANDARD;
			
		}
	}

	
	
	
}