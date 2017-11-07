package CamelDSL;

public class OrderItem {
    DrinkType drinkType;
    int shots = 2;
    private boolean iced;
    private Order order;

    public OrderItem(DrinkType drinkType, int shots, boolean iced, Order order) {
        this.drinkType = drinkType;
        this.shots = shots;
        this.iced = iced;
        this.order = order;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getShots() {
        return shots;
    }

    public boolean isIced() {
        return iced;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (shots != orderItem.shots) return false;
        if (iced != orderItem.iced) return false;
        if (drinkType != orderItem.drinkType) return false;
        return order.equals(orderItem.order);
    }

    @Override
    public int hashCode() {
        int result = drinkType.hashCode();
        result = 31 * result + shots;
        result = 31 * result + (iced ? 1 : 0);
        result = 31 * result + order.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return (this.iced? "COOL": "HOT") + " " + this.drinkType.toString() + " " + this.shots + " shots";
    }
}
