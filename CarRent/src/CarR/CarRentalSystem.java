package CarR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer>customers;
    private List<CarRent>carRents;

  public  CarRentalSystem() {
cars=new ArrayList<>();
customers=new ArrayList<>();
carRents=new ArrayList<>();
    }
 public void addCar(Car car)
 {
     cars.add(car);

 }

    public void addCustomer(Customer cust)
    {
        customers.add(cust);

    }

    public void rentCar(Car car, Customer cust, int day)
    {
        if(car.carAvailablity())
    {
        car.carRent();
        carRents.add(new CarRent(car,cust,day));
    } else
            System.out.println();

    }


public void returningCar(Car car) {
    car.returnCar();
    CarRent removecar = null;
    for (CarRent i : carRents) {
        if (i.getCar() == car) {
            removecar = i;
            break;

        }

        if (removecar != null) {
            carRents.remove(removecar);
            System.out.println("car return suucessfully");
        } else {
            System.out.println("car return unsuucessfully");
        }

    }
}
    public void main(){

        Scanner sc= new Scanner(System.in);
        Boolean Exit=true;
        while(Exit){

            System.out.println("1Rent the car");

            System.out.println ("2.Return the car");
            //System.out.println ("3.show car");
            System.out.println ("4.exit");
            System.out.println ("enter choice ");
            int ch=sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.println("enter the id of customer ");
                    int cust_id = sc.nextInt();
                    System.out.println("enter the name of customer ");
                    String cust_name = sc.next();
                    for (Car car : cars) {
                        if (car.carAvailablity()) {
                            System.out.println(car.getCar_id() + " " + car.getCar_name() + " " + car.getCar_model());
                        }
                    }

                    System.out.println("enter the carid ");
                    int carid = sc.nextInt();
                    System.out.println("enter the no of days ");
                    int no_days = sc.nextInt();

                    System.out.println("enter the Custid ");
                    int custId = sc.nextInt();

                    Customer c = new Customer(custId, cust_name);
                    addCustomer(c);
                    Car selectCar = null;
                    for (Car car : cars) {
                        if (car.carAvailablity()&& car.getCar_id() == carid) {
                            selectCar = car;
                            break;

                        }}
                        if (selectCar != null) {
                            double totalPrice = selectCar.totalPrice(no_days);

                            System.out.println("enter the' Customer id'" + c.getCust_Id());
                            System.out.println("enter the' Customer name'" + c.getCust_Name());
                            System.out.println("enter the' Customer model'" + selectCar.getCar_id());
                            System.out.println("enter the' Customer model'" + selectCar.getCar_name());
                            System.out.println("enter the' Customer model'" + selectCar.getCar_model());
                            System.out.println("Total price " + totalPrice);
                            System.out.println("Enter the' Confermation Y/n");

                            String choice = sc.next();
                            if (choice.equalsIgnoreCase("y")) {
                                rentCar(selectCar, c, no_days);
                                System.out.println("car rented successfull");
                            } else if (choice.equalsIgnoreCase("N")) {
                                System.out.println("rent cancel sucfully");
                            }} else {
                                System.out.println("rent cancel car is not avilable");
                            }break;

                case 2:
                    System.out.println("To  Returning the car");
                    System.out.println("enter the id of Carid to returning car ");
                    int car_id1 = sc.nextInt();

                    Car returnCar1 = null;
                    for (Car car1 : cars) {
                        if (car_id1 == car1.getCar_id() && !car1.carAvailablity()) {
                            returnCar1 = car1;
                            break;
                        }
                    }
                    Customer customer1 = null;
                    if (returnCar1 != null) {

                        for (CarRent i : carRents) {
                            if (i.getCar() == returnCar1) {
                                customer1 = i.getCustomer();
                                break;
                            }
                        }

                        if (customer1 != null) {
                            returningCar(returnCar1);
                            System.out.println(" car return successfully\n ");
                        } else {
                            System.out.println("car is not returned ");
                        }
                    }
            else{
                System.out.println("Invalid car Id 0or car not rerurned");
            }
break;

//                case 3:
//                    for (Car car : cars) {
//                        car.toString();
//                    }
//                    break;

                case 4:
                    Exit=false;
                    }

                    }

        }
}


















