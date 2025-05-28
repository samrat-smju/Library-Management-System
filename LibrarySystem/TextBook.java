class TextBook extends Book {
    String standard;

    TextBook(String isbn, String title, String author, double price, int quantity, String standard) {
        super(isbn, title, author, price, quantity);
        this.standard = standard;
    }

    @Override
    String showDetails() {
        return "TextBook - " + title + " | Std: " + standard + " | Author: " + author + " | Qty: " + quantity;
    }
}
