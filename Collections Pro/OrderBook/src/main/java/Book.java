/**
 * Created by Saego on 04.09.2017.
 */
class Book implements Comparable<Book>{
    private String theTitleOfTheBook;

    Book(String theTitleOfTheBook) {
        this.theTitleOfTheBook = theTitleOfTheBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return theTitleOfTheBook != null ? theTitleOfTheBook.equals(book.theTitleOfTheBook) : book.theTitleOfTheBook == null;
    }

    @Override
    public int hashCode() {
        return theTitleOfTheBook != null ? theTitleOfTheBook.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book: " + theTitleOfTheBook;
    }

    @Override
    public int compareTo(Book o) {
        return this.theTitleOfTheBook.compareTo(o.theTitleOfTheBook);
    }
}
