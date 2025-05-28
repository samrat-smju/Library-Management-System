class StoryBook extends Book {
    String genre;

    StoryBook(String isbn, String title, String author, double price, int quantity, String genre) {
        super(isbn, title, author, price, quantity);
        this.genre = genre;
    }

    @Override
    String showDetails() {
        return "StoryBook - " + title + " | Genre: " + genre + " | Author: " + author + " | Qty: " + quantity;
    }
}
