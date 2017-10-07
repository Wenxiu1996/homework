package parking;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots=0;
	private static int SPOTSPERROW=10;
	
	public Level(int f,int numberSpots) {
		floor=f;
		spots=new ParkingSpot[numberSpots];
		int charging=20;
		int largeSpots = numberSpots / 4;  
        int bikeSpots = numberSpots / 4;  
        int compactSpots = numberSpots - largeSpots - bikeSpots;
        availableSpots=availableSpots();
        for(int i = 0; i < numberSpots; i++) {
        	V.VehicleSize s=V.VehicleSize.Bike;
        	if(i < largeSpots){
        		s = V.VehicleSize.Large;  
            } else if (i < largeSpots + compactSpots) {  
            	 s = V.VehicleSize.Compact;  
            }
        	    int row = i / SPOTSPERROW; 
        	    
        	    spots[i] = new ParkingSpot(this, row, i, s,charging);
        }
	}

	public boolean parkVehicle(Vehicle vehicle) {
		if(availableSpots() < Vehicle.getNumberOfPlaces()) {
			return false;
		}
		int spotNumber=findAvailableSpots(vehicle);  
        if(spotNumber < 0){  
            return false;  
        }  
        return parkStartingAtSpot(spotNumber, vehicle);  
    }  
	
	 private int findAvailableSpots(Vehicle vehicle) {  
	        int spotsNeeded = vehicle.getNumberOfPlaces();  
	        int lastRow = -1;  
	        int spotsFound = 0;  
	  
	        for(int i = 0; i < spots.length; i++){  
	            ParkingSpot spot = spots[i];
	            if(lastRow!=spot.getRow()) {
	            	spotsFound=0;
	            	lastRow=spot.getRow();
	            }
	            if(spot.canFit(vehicle)) {
	            	spotsFound++;
	            }else {
	            	spotsFound=0;
	            	
	            }
	            if(spotsFound== spotsNeeded) {
	            	return i-(spotsNeeded-1);
	            }
	        }
	        return -1;
}
	 private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {  
	        vehicle.clearSpots();  
	  
	        boolean success = true;  
	          
	        for (int i = spotNumber; i < spotNumber + vehicle.numberOfPlaces; i++) {  
	             success &= spots[i].park(vehicle);  
	        }  
	          
	        availableSpots -= vehicle.numberOfPlaces;  
	        return success;  
	    }
	 public void spotFreed() {  
	        availableSpots++;  
	    }  
	  
	 public int availableSpots() {  
	        return availableSpots;  
	    } 
}
 
 