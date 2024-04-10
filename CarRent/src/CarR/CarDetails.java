package CarR;

public class CarDetails {
    public static void main(String[] args) {

        Car car1=new Car(1,"nexa","x5",1200000,true);
        Car car2=new Car(2,"Rumion","x10",700000,true);
        Car car3=new Car(3,"Ertica","Z3",500000,true);

        CarRentalSystem carRentalSystem=new CarRentalSystem();
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);

carRentalSystem.main();





    }
}
