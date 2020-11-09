package goods;

import customer.Customer;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Goods {

    private String description;
    private float weight;
    private float width;
    private float length;
    private float height;

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

    private Customer sender;
    private Customer receiver;

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
