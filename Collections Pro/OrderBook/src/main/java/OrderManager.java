import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Saego on 25.09.2017.
 */
class OrderManager {
    private Map<Integer, Order> orders = new HashMap<Integer, Order>();

    /** Parsing an xml file by using StAX parser. Calculating orders using private methods.
     * @param fileName - name of *xml file.
     * @throws FileNotFoundException - exception file is not exist.
     */
    void xMLReader(String fileName) throws FileNotFoundException {
        File xmlFile = new File(fileName);
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(new FileInputStream(xmlFile));
            int event = streamReader.getEventType();
            boolean n = true;
            while (n) {
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Process started....   " + "Encoding: " + streamReader.getEncoding());
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if (!streamReader.getLocalName().equals("Orders")) {
                            if (streamReader.getLocalName().equals("AddOrder")) {
                                addOrder(new Book(streamReader.getAttributeValue(0)), streamReader.getAttributeValue(1).equals("BUY") ? "bid" : "ask",
                                        Float.valueOf(streamReader.getAttributeValue(2)), Integer.valueOf(streamReader.getAttributeValue(3)),
                                        Integer.valueOf(streamReader.getAttributeValue(4)));

                            } else {
                                removeOrder(new Book(streamReader.getAttributeValue(0)), Integer.valueOf(streamReader.getAttributeValue(1)));
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        n = false;
                        break;
                }
                if (n) {
                    event = streamReader.next();
                } else streamReader.close();
            }
            streamReader.close();
            ArrayList<Order> calculatedOrders = calculatingProcess(this.orders);
            output(getListOfListOfTree(getListOfBookOrders(getSetOfBooks(calculatedOrders), calculatedOrders)));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param book - object book in order.
     * @param ask - type of ask: sell or buy.
     * @param price - price in order.
     * @param volume - quantity of books in order.
     * @param orderId - id of current order.
     */
    void addOrder(Book book, String ask, float price, int volume, int orderId) {
        this.orders.put(orderId, new Order(book, ask.equals("bid"), price, volume));
    }

    /**
     * @param book - object book in order.
     * @param orderId - id of current order.
     */
    void removeOrder(Book book, int orderId) {
        if (this.orders.containsKey(orderId)) {
            if (this.orders.get(orderId).getBook().equals(book)) {
                this.orders.remove(orderId);
            }
        }
    }

    Map<Integer, Order> getOrders(){
        return this.orders;
    }

    /**
     * Prints result order.
     */
    private void output(List<List<TreeSet<Order>>> listOfListsOfTree) {
        for (List<TreeSet<Order>> listOfTree:
             listOfListsOfTree) {
            System.out.print("@-@-@-@-@");
            System.out.print("---" + listOfTree.get(0).first().getBook() + "---");
            System.out.println("@-@-@-@-@");
            //for (TreeSet<Order> tr:
            //     listOfTree) {
                /*String operation;
                if (tr.first().isOperation()){
                    operation = "@ SELL";
                }
                else operation = "@ BUY";
                int quantityOfColums;
                if (listOfTree.get(0).size() > listOfTree.get(1).size()){
                    quantityOfColums = listOfTree.get(0).size();
                }
                else quantityOfColums = listOfTree.get(1).size();
                System.out.println("Operation : " + operation);
                */
                //
                String sell = "@SELL";
                String buy = "@BUY";
                TreeSet<Order> sells = listOfTree.get(0);
                TreeSet<Order> buys = listOfTree.get(1);
                Iterator<Order> iteratorSell = sells.iterator();
                Iterator<Order> iteratorBuy = buys.iterator();
                int quantityOfColums;
                if (listOfTree.get(0).size() > listOfTree.get(1).size()){
                    quantityOfColums = listOfTree.get(0).size();
                }
                else quantityOfColums = listOfTree.get(1).size();
                System.out.println(String.format("%21s%s%21s", sell, "|", buy));
                Order orderSell, orderBuy;
                String priceSell, quantitySell, priceBuy, quantityBuy;
                for (int i = 0; i < quantityOfColums; i++){
                    if (iteratorSell.hasNext()) {
                        orderSell = iteratorSell.next();
                    }
                    else {
                        orderSell = null;
                    }
                    if (iteratorBuy.hasNext()) {
                        orderBuy = iteratorBuy.next();
                    }
                    else {
                        orderBuy = null;
                    }
                    if (orderSell != null){
                        priceSell = String.valueOf(orderSell.getPrice());
                        quantitySell = String.valueOf(orderSell.getVolume());
                    }
                    else {
                        priceSell = "-/-";
                        quantitySell = "-/-";
                    }
                    if (orderBuy !=null){
                        priceBuy = String.valueOf(orderBuy.getPrice());
                        quantityBuy = String.valueOf(orderBuy.getVolume());
                    }
                    else {
                        priceBuy = "-/-";
                        quantityBuy = "-/-";
                    }
                    System.out.println(String.format("%10s%s%10s%s%10s%s%10s", priceSell, "|", quantitySell, "|", priceBuy, "|", quantityBuy));
                }
                //
                /*
                for (Order ord:
                     tr) {
                    System.out.println(" Price: " + ord.getPrice() + " Volume: " + ord.getVolume());
                }
                */
                System.out.println("___________________");
            //}
        }
    }

    /**
     * @param orders - map of orders by id.
     * @return - list of orders.
     */
    ArrayList<Order> calculatingProcess(Map<Integer, Order> orders) {
        List<Order> orderList = new ArrayList<Order>();
        orderList.addAll(orders.values());
        for (int i = 0; i < orderList.size() - 1; i++) {
            for (int n = i + 1; n < orderList.size(); n++) {
                if ((orderList.get(i).getBook().equals(orderList.get(n).getBook())) & (orderList.get(i).getPrice() == orderList.get(n).getPrice()) &
                        orderList.get(i).isOperation() == orderList.get(n).isOperation()) {
                    orderList.get(i).setVolume(orderList.get(i).getVolume() + orderList.get(n).getVolume());
                    orderList.remove(n);
                }
            }
        }
        return (ArrayList<Order>) orderList;
    }

    /**
     * Makes set of books without duplicates.
     *
     * @param orders - all unsorted orders.
     * @return - set of book's names.
     */
    Set<Book> getSetOfBooks(ArrayList<Order> orders) {
        Set<Book> books = new TreeSet<Book>();
        for (Order order :
                orders) {
            books.add(order.getBook());
        }
        return books;
    }

    /** Makes list of orders by each book, BUY & C=SELL aren't sorted.
     * @param books - book(the title of book).
     * @param orders - all orders in one list.
     * @return - list of lists of orders by each book.
     */
    List<List<Order>> getListOfBookOrders(Set<Book> books, List<Order> orders){
        List<List<Order>> listOfBookOrders = new ArrayList<List<Order>>();
        for (Book book:
             books) {
            ArrayList <Order> ordersOfEachBook = new ArrayList<Order>();
            listOfBookOrders.add(ordersOfEachBook);
            for (Order order:
                 orders) {
                if (book.equals(order.getBook())){
                    ordersOfEachBook.add(order);
                }
            }
        }
        return listOfBookOrders;
    }

    /** Makes list of orders by each book, which consists of two trees SELL & BUY.
     * @param orders - lis of orders by each books, BUY & SELL together.
     * @return - list of lists of trees of orders.
     */
    List<List<TreeSet<Order>>> getListOfListOfTree(List<List<Order>> orders){
        List<List<TreeSet<Order>>> finalRes = new ArrayList<List<TreeSet<Order>>>();
        for (List<Order> list:
             orders) {
            List<TreeSet<Order>> listOfTree = new ArrayList<TreeSet<Order>>();
            TreeSet<Order> sell = new TreeSet<Order>(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.getPrice() > o2.getPrice()){
                        return -1;
                    }
                    else return 1;
                }
            });
            TreeSet<Order> buy = new TreeSet<Order>(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.getPrice() < o2.getPrice()){
                        return -1;
                    }
                    else return 1;
                }
            });
            listOfTree.add(sell);
            listOfTree.add(buy);
            finalRes.add(listOfTree);
            for (Order order:
                 list) {
                if (order.isOperation()) {
                    sell.add(order);
                } else {
                    buy.add(order);
                }
            }
        }
        return finalRes;
    }
}