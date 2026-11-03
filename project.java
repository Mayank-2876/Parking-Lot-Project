import java.time.Duration;
import java.time.LocalDateTime;
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

car[] cars = new car[10];
LocalDateTime[] entryTimes = new LocalDateTime[10];


public void parkCar(car abc) {
    
        
    try{
        boolean parked=false;
        
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = abc;
                entryTimes[i]=LocalDateTime.now();
                System.out.println("Car parked successfully!!");
                
                parked=true;
                break;   
            }
        }
    
            if(parked==false){
                throw new Exception ("parking is full!!");
            }
        } 
            catch(Exception e){

                System.out.println(e.getMessage());
            }        
        }
    

    public void removeCar(String abc) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getCarId().equals(abc)) {
                    LocalDateTime exitTime = LocalDateTime.now();
                    LocalDateTime entryTime=entryTimes[i];
                    Duration duration = Duration.between(entryTime,exitTime);
                    long hours = duration.toHours();
                    if (hours==0){
                        hours=1;
                    }

                    long fees = hours * 20;

                    System.out.println("total fees is "+ fees);

                    cars[i] = null;
                    entryTimes[i]=null;
                    System.out.println("Car removed successfully!!");


                    return;
                }
            }
        }
        System.out.println("Car doesnt exists in parking!");
    }

    public void displayCar() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println("parking slot no.- " + (i + 1));
                System.out.println(cars[i].getCarId());
                System.out.println(cars[i].getBrand());  
            }
    }
}

public void avaialableSlots(){
    int count=0;
    for (int i=0;i<cars.length;i++){
        if(cars[i]==null){
            count++;
        }
    }
    System.out.println("Avaialble slots are " + count );
    System.out.println("occupied slots are " + (cars.length-count));
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


