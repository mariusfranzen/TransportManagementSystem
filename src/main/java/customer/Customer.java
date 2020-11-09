package customer;

import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Customer {

    private UUID customerNumber;
    private String firstName;
    private String lastName;
    private String address;
    private Ticket[] tickets;
    private String phoneNumber;
    private String email;

    public Customer(){
        this.customerNumber = UUID.randomUUID();
    }

    public UUID getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Customer setTickets(Ticket[] tickets) {
        this.tickets = tickets;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Customer setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }
}
