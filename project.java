
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
abstract class Vehicle {

    private String vehicleId;
    private String brand;

    Vehicle(String vehicleId, String brand) {
        this.vehicleId = vehicleId;
        this.brand = brand;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public abstract String getVehicleType();
}

class Car extends Vehicle {

    Car(String id, String brand) {
        super(id, brand);
    }
    @Override
    public String getVehicleType() {
        return "Car";
    }
}

class Bike extends Vehicle {

    Bike(String id, String brand) {
        super(id, brand);
    }

    public String getVehicleType() {
        return "Bike";
    }
}

class Bus extends Vehicle {

    Bus(String id, String brand) {
        super(id, brand);
    }

    public String getVehicleType() {
        return "Bus";
    }
}

class Truck extends Vehicle {

    Truck(String id, String brand) {
        super(id, brand);
    }

    public String getVehicleType() {
        return "Truck";
    }
}

class parkingLot {

private ArrayList<Vehicle> vehicles = new ArrayList<>();

private HashMap<String, LocalDateTime> entryTimes =
    new HashMap<>();

private final int capacity = 10;


public void parkVehicle(Vehicle abc) {
try{
    if (vehicles.size() >= capacity) {
    throw new Exception("Parking is full!!");
}

if (entryTimes.containsKey(abc.getVehicleId())) {
    throw new Exception("Car already parked!!");
}

vehicles.add(abc);

entryTimes.put(
    abc.getVehicleId(),
    LocalDateTime.now()
);

System.out.println("Car Parked Succefully!!!!");
}
catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
   

    public void removeVehicle(String abc) {
        Vehicle foundVehicle = null;

        for (Vehicle c : vehicles) {

            if (c.getVehicleId().equals(abc)) {
                foundVehicle = c;
                break;
            }
        }

        if (foundVehicle != null) {

            LocalDateTime exitTime = LocalDateTime.now();

            LocalDateTime entryTime = entryTimes.get(abc);

            Duration duration =
                Duration.between(entryTime, exitTime);

            long hours = duration.toHours();

            if (hours == 0) {
                hours = 1;
            }

            long fees = hours * 20;

            System.out.println("Total fees is " + fees);

            vehicles.remove(foundVehicle);

            entryTimes.remove(abc);

            System.out.println("Car removed successfully!!");

        }

        else {
            System.out.println("Car doesn't exist in parking!");
        }
    }

    public void displayVehicle() {
        for (int i = 0; i < vehicles.size(); i++) {

            System.out.println("Parking slot no.- " + (i + 1));

            System.out.println(vehicles.get(i).getVehicleId());

            System.out.println(vehicles.get(i).getBrand());
        }
}

public void avaialableSlots(){
   System.out.println(
            "Available slots are " + (capacity - vehicles.size())
        );

        System.out.println(
            "Occupied slots are " + vehicles.size()
        );
    }
}


public class project{
    public static void main(String[] arg){
        parkingLot p1 = new parkingLot();
        Vehicle v1 = new Car("dl12b4444", "toyota");
        Vehicle v2 = new Bike("dl33b4444", "Royal Enfield");
        Vehicle v3 = new Bus("hr33u9878", "Volvo");
        Vehicle v4 = new Truck("dl44b5555", "Tata");

        p1.parkVehicle(v1);
        p1.parkVehicle(v2);
        p1.parkVehicle(v3);
        p1.parkVehicle(v4);
        p1.displayVehicle();
        p1.avaialableSlots();
        p1.removeVehicle("dl12b4444");
        p1.displayVehicle();
        p1.avaialableSlots();
    }
}

