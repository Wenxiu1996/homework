package parking;
class V{
	  public enum VehicleSize{  Bike,Compact,Large }
	  VehicleSize size;
}
public class Vehicle {
     protected int numberOfPlaces;
     V veh=new V();
	 protected String licence;
	
	 protected ArrayList<ParkingSpot> parkingSpots=new ArrayList <ParkingSpot>();
	 
	 public int getNumberOfPlaces(){
		 return numberOfPlaces;
	 }
	 
	 public V.VehicleSize getSize(){
		 return veh.size;
	 }
	
	 public void parkInSpot(ParkingSpot spot) {
		 parkingSpots.add(spot);
	 }
	 
	 public void clearSpots() {
		 for(int i=0;i<parkingSpots.size();i++) {
			 parkingSpots.get(i).removeVehicle();
		 }
		 parkingSpots.clear();
	 }
	 
	 public boolean canSpot(ParkingSpot spot);
	 public void print();

}

