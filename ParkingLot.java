package parking;

public class ParkingLot {  
	    private Level[] levels;  
	    private static int NUM_LEVELS = 5;
	    private int freeSpaces;
	    public ParkingLot() {  
	        levels = new Level[NUM_LEVELS];  
	        for (int i = 0; i < NUM_LEVELS; i++) {  
	            levels[i] = new Level(i, 30);  
	            freeSpaces+=levels[i].availableSpots;
	        }
	    }
	    
	    public boolean parkVehicle(Vehicle vehicle) {  
	        for (int i = 0; i < levels.length; i++) {  
	            if (levels[i].parkVehicle(vehicle)) {  
	                return true;  
	            }  
	        }  
	        return false;  
	    }  

}
