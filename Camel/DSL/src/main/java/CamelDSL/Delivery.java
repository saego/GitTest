package CamelDSL;

import java.util.List;

public class Delivery {
    private List<Drink> drinks;
    private int orderNumber;

    public Delivery(List<Drink> drinks, int orderNumber) {
        this.drinks = drinks;
        this.orderNumber = orderNumber;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "drinks=" + drinks +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
