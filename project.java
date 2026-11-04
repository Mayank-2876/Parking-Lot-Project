
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
class car {

    private String carId;
    private String brand;

    car(String carId, String brand) {
        this.carId = carId;
        this.brand = brand;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

}

class parkingLot {

private ArrayList<car> cars = new ArrayList<>();

private HashMap<String, LocalDateTime> entryTimes =
    new HashMap<>();

private final int capacity = 10;


public void parkCar(car abc) {
try{
    if (cars.size() >= capacity) {
    throw new Exception("Parking is full!!");
}

if (entryTimes.containsKey(abc.getCarId())) {
    throw new Exception("Car already parked!!");
}

cars.add(abc);

entryTimes.put(
    abc.getCarId(),
    LocalDateTime.now()
);

System.out.println("Car Parked Succefully!!!!");
}
catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
   

    public void removeCar(String abc) {
        car foundCar = null;

        for (car c : cars) {

            if (c.getCarId().equals(abc)) {
                foundCar = c;
                break;
            }
        }

        if (foundCar != null) {

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

            cars.remove(foundCar);

            entryTimes.remove(abc);

            System.out.println("Car removed successfully!!");

        }

        else {
            System.out.println("Car doesn't exist in parking!");
        }
    }

    public void displayCar() {
        for (int i = 0; i < cars.size(); i++) {

            System.out.println("Parking slot no.- " + (i + 1));

            System.out.println(cars.get(i).getCarId());

            System.out.println(cars.get(i).getBrand());
        }
}

public void avaialableSlots(){
   System.out.println(
            "Available slots are " + (capacity - cars.size())
        );

        System.out.println(
            "Occupied slots are " + cars.size()
        );
    }
}


public class project{
    public static void main(String[] arg){
        parkingLot p1 = new parkingLot();
        car c1=new car("dl12b4444","toyota");
        car c2=new car("hr33u9878","bmw");
        car c3=new car("rj32u9878","bmw");
        car c4=new car("GM32u9878","bmw");
        car c5=new car("ME32u9878","bmw");
        car c6=new car("ERr32u9878","bmw");
        car c7=new car("Pr32u9878","bmw");
        car c8=new car("Qr32u9878","bmw");
        car c9=new car("Tr32u9878","bmw");
        car c10=new car("Xr32u9878","bmw");
        car c11=new car("Zr32u9878","bmw");
        car c12=new car("Lr32u9878","bmw");
        p1.parkCar(c1);
        p1.parkCar(c2);
        p1.parkCar(c3);
        p1.parkCar(c4);
        p1.parkCar(c5);
        p1.parkCar(c6);
        p1.parkCar(c7);
        p1.parkCar(c8);
        p1.parkCar(c9);
        p1.parkCar(c10);
        p1.parkCar(c11);
        p1.parkCar(c12);
        p1.displayCar();
        p1.avaialableSlots();
        p1.removeCar("dl12b4444");
        p1.displayCar();
        p1.avaialableSlots();
        



    }
}

