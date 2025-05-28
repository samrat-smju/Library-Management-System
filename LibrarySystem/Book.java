abstract class Book {
    String isbn, title, author;
    double price;
    int quantity;

    Book(String isbn, String title, String author, double price, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    abstract String showDetails();
}
