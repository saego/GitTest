package CamelDSL;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems = new ArrayList<>();
    private int number;

    public Order(int number) {
        this.number = number;
    }

    public List<OrderItem> addItem(DrinkType drinkType, int shots, boolean iced){
        this.orderItems.add(new OrderItem(drinkType, shots, iced, this));
        return this.orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public int getNumber() {
        return number;
    }
}
