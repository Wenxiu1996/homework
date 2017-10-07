package parking;

public class Bike extends Vehicle{
	public Bike() {
		numberOfPlaces=1;
		veh.size=V.VehicleSize.Bike;
	}
	
	public boolean canSpot(ParkingSpot spot) {
		return true;
	}
	
	public void print() {
		System.out.print("Bi");
	}
}
