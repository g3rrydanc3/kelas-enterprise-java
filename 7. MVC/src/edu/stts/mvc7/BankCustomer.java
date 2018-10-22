package edu.stts.mvc7;

import java.util.HashMap;

public class BankCustomer {
    private static HashMap<String, BankCustomer> customers;

    static{
        customers = new HashMap<String, BankCustomer>();
        customers.put("id001", new BankCustomer("id001", "Upin1", "Unyil", 500));
        customers.put("id002", new BankCustomer("id002", "Upin2", "Unyil", 500));
        customers.put("id003", new BankCustomer("id003", "Upin3", "Unyil", 500));
    }

    public static BankCustomer getCustomer(String id){
        return customers.get(id);
    }



    private String id;
    private String firstName;
    private String lastName;
    private double balance;


    public BankCustomer(String id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
