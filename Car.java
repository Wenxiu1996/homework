package parking;

public class Car extends Vehicle{
	public Car() {
		numberOfPlaces=1;
		veh.size=V.VehicleSize.Compact;
	}
	
	public boolean canSpot(ParkingSpot spot) {
		return spot.getSize()==V.VehicleSize.Compact || spot.getSize()==V.VehicleSize.Large;
	}
	
	public void print() {
		System.out.print("C");
	}
}
