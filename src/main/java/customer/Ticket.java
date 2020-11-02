package customer;

import enums.TicketType;
import goods.Person;

import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Ticket {

    private UUID ticketNumber;
    private TicketType type;
    private Person[] people;
    private float price;

}
