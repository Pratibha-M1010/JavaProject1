package CarR;

public class Car {
    private int car_id;
    private String car_name;
    private String car_model;
   private double car_price;
    private boolean car_availability;
//assign value - construtor
    public Car(int car_id, String car_name, String car_model, double car_price, boolean car_availability) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_model = car_model;
        this.car_price = car_price;
        this.car_availability = true;
    }





    //fetch details getter
    public int getCar_id() {
        return car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getCar_model() {
        return car_model;
    }
public double totalPrice(int days){

        return car_price*days;
}
public void carRent(){
car_availability=false;
}
public void returnCar(){
        car_availability=true;
}

public boolean carAvailablity()
{
   return car_availability;

}

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_name='" + car_name + '\'' +
                ", car_model='" + car_model + '\'' +
                ", car_price=" + car_price +
                ", car_availability=" + car_availability +
                '}';
    }
}
