class Library implements LibraryOperations {
    String name;
    Book[] books;
    int count = 0;

    Library(String name) {
        this.name = name;
        books = new Book[100];
    }

    public boolean addBook(Book b) {
        if (count < books.length) {
            books[count++] = b;
            return true;
        }
        return false;
    }

    public void showAllBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].showDetails());
        }
    }

    public Book[] getBooks() {
        Book[] copy = new Book[count];
        for (int i = 0; i < count; i++) {
            copy[i] = books[i];
        }
        return copy;
    }
}
