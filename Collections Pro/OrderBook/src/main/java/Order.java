/**
 * Created by Saego on 04.09.2017.
 */
class Order {
    private Book book;
    private boolean operation;
    private float price;
    private int volume;
    //int orderId;

    Order(Book book, boolean operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    //    this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "book=" + book +
                ", operation=" + operation +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (operation != order.operation) return false;
        if (Float.compare(order.price, price) != 0) return false;
        if (volume != order.volume) return false;
        return book != null ? book.equals(order.book) : order.book == null;
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + (operation ? 1 : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + volume;
        return result;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
