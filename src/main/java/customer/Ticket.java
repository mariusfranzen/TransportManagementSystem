package customer;

import enums.TicketType;
import goods.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */

public class Ticket {

    private UUID ticketNumber;
    private TicketType type;
    private List<Person> personList = new ArrayList<>();
    private float price; //Euro

    public Ticket(){
        ticketNumber = UUID.randomUUID();
    }

    public UUID getTicketNumber() {
        return ticketNumber;
    }

    public TicketType getType() {
        return type;
    }

    public Ticket setType(TicketType type) {
        this.type = type;
        return this;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Ticket setPersonList(List<Person> personList) {
        this.personList = personList;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Ticket setPrice(float price) {
        this.price = price;
        return this;
    }
}
