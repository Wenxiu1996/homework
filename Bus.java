package parking;

public class Bus extends Vehicle{
	public Bus() {
		numberOfPlaces=3;
		veh.size=V.VehicleSize.Large;
	}
	
	public boolean canSpot(ParkingSpot spot) {
		return spot.getSize()==V.VehicleSize.Large;
	}
	
	public void print() {
		System.out.print("Bu");
	}
}

