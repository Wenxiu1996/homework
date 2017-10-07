package parking;

public class ParkingSpot {
	private Vehicle vehicle;
	private V.VehicleSize spotSize;
	private int row;
	private int number;
	private Level level;
	private int charging;
	
	public ParkingSpot(Level l,int r,int n ,V.VehicleSize s,int c) {
		level=l;
		row=r;
		number=n;
		spotSize=s;
		charging=c;
	}
	
	public boolean isFree() {
		return vehicle==null;
	}

	public boolean canFit(Vehicle vehicle) {
		return isFree()&&vehicle.canSpot(this);
	}
	
	public boolean park(Vehicle v) {
		if(!canFit(v)) {
			return false;
		}
		vehicle=v;
		vehicle.parkInSpot(this);
		return true;
	}
		
		public void removeVehicle() {
			level.spotFreed();
			vehicle=null;
		}
		
		public int getRow() {
			return row;
		}
		
		public int getNumber() {
			return number;
		}
		
		public V.VehicleSize getSize(){
			return spotSize;
		}
		
		public void print(){  
	        if (vehicle == null) {  
	            if (spotSize == V.VehicleSize.Compact) {  
	                System.out.print("c");  
	            } else if (spotSize == V.VehicleSize.Large) {  
	                System.out.print("l");  
	            } else if (spotSize == V.VehicleSize.Bike) {  
	                System.out.print("b");  
	            }  
	        } else {  
	            vehicle.print();  
	        }  
	    }  
}
