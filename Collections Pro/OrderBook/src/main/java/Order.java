/**
 * Created by Saego on 04.09.2017.
 */
public class Order {
    private float price;
    private String type;
    private int quantity;
    private int id;

    public Order(float price, String type, int quantity, int id) {
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.id = id;
    }
}
