package CamelDSL;

public class Drink {
    private int shots;
    private boolean iced;
    private int orderNumber;
    private DrinkType drinkType;

    public Drink(int shots, boolean iced, int orderNumber, DrinkType drinkType) {
        this.shots = shots;
        this.iced = iced;
        this.orderNumber = orderNumber;
        this.drinkType = drinkType;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return (this.iced? "COOL": "HOT") + " " + this.drinkType.toString() + " " + this.shots + " shots";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (shots != drink.shots) return false;
        if (iced != drink.iced) return false;
        if (orderNumber != drink.orderNumber) return false;
        return drinkType == drink.drinkType;
    }

    @Override
    public int hashCode() {
        int result = shots;
        result = 31 * result + (iced ? 1 : 0);
        result = 31 * result + orderNumber;
        result = 31 * result + drinkType.hashCode();
        return result;
    }
}
