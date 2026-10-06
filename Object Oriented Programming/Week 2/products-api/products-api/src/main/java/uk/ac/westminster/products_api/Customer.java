package uk.ac.westminster.products_api;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private Address address;

    public Customer () {}

    public Customer(Long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long GetId () {return id;}
    public String GetName() {return name;}
    public String GetEmail() {return email;}
    public Address getAddress() {return address;}
}

