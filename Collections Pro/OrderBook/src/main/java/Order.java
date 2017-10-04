/**
 * Created by Saego on 04.09.2017.
 */
class Order implements Comparable<Order>{
    private Book book;
    private boolean operation;
    private float price;
    private int volume;


    Order(Book book, boolean operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;

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

        return operation == order.operation && Float.compare(order.price, price) == 0 && volume == order.volume && (book != null ? book.equals(order.book) : order.book == null);
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + (operation ? 1 : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + volume;
        return result;
    }

    Book getBook() {
        return book;
    }

    boolean isOperation() {
        return operation;
    }

    float getPrice() {
        return price;
    }

    int getVolume() {
        return volume;
    }

    void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Order o) {
        return (int) (this.price - o.getPrice());
    }
}
