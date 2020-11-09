package goods;

import customer.Customer;
import org.bson.Document;

import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Goods {

    private UUID shippingId;
    private String description;
    private Customer sender;
    private Customer receiver;
    private float weight;
    private float width;
    private float length;
    private float height;

    public Goods(){
        this.shippingId = UUID.randomUUID();
    }

    public Document getAsDocument(){
        return new Document("_id", this.shippingId)
                .append("description", this.description)
                .append("sender", this.sender.getAsDocument())
                .append("receiver", this.receiver.getAsDocument())
                .append("weight", this.weight)
                .append("length", this.length)
                .append("height", this.height);
    }

    public UUID getShippingId() {
        return shippingId;
    }

    public float getLength() {
        return length;
    }

    public Goods setLength(float length) {
        this.length = length;
        return this;
    }

    public float getWidth() {
        return width;
    }

    public Goods setWidth(float width) {
        this.width = width;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public Goods setHeight(float height) {
        this.height = height;
        return this;
    }

    public Customer getSender() {
        return sender;
    }

    public Goods setSender(Customer sender) {
        this.sender = sender;
        return this;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public Goods setReceiver(Customer receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goods setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public Goods setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
