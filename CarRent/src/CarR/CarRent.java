package CarR;

public class CarRent {
   private Car car ;
   private Customer customer;

   private int day;

   public CarRent(Car car, Customer customer, int day) {
      this.car = car;
      this.customer = customer;
      this.day = day;
   }

   public Car getCar() {
      return car;
   }

   public Customer getCustomer() {
      return customer;
   }

   public int getDay() {
      return day;
   }
}
