package CarR;

public class Customer {
private int cust_Id;
private String cust_Name;

    public Customer(int cust_Id, String cust_Name) {
        this.cust_Id = cust_Id;
        this.cust_Name = cust_Name;
    }

    public int getCust_Id() {
        return cust_Id;
    }

    public String getCust_Name() {
        return cust_Name;
    }

}
