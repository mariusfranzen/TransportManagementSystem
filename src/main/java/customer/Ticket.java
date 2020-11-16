package customer;

import enums.TicketType;
import goods.Person;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */

public class Ticket {

    private UUID ticketId;
    private TicketType type;
    private List<Person> personList = new ArrayList<>();
    private float price; //Euro
    private String travelOrigin;
    private String travelDestination;
    private Date travelDate;

    public Ticket() {
        ticketId = UUID.randomUUID();
    }

    public Document getAsDocument() {
        return new Document("_id", this.ticketId)
                .append("ticketType", this.type)
                .append("personList", this.personList)
                .append("price", this.price)
                .append("travelOrigin", this.travelOrigin)
                .append("travelDestination", this.travelDestination)
                .append("travelDate", this.travelDate);
    }

    public String getTravelOrigin() {
        return travelOrigin;
    }

    public Ticket setTravelOrigin(String travelOrigin) {
        this.travelOrigin = travelOrigin;
        return this;
    }

    public String getTravelDestination() {
        return travelDestination;
    }

    public Ticket setTravelDestination(String travelDestination) {
        this.travelDestination = travelDestination;
        return this;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public Ticket setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
        return this;
    }

    public UUID getTicketId() {
        return ticketId;
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

    public Ticket addPersonToList(Person person) {
        this.personList.add(person);
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
