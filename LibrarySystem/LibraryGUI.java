import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class LibraryGUI extends JFrame implements ActionListener {
    private JTextField isbnField, titleField, authorField, priceField, qtyField, extraField;
    private JComboBox<String> typeBox;
    private JTextArea outputArea;
    private JButton addButton, showButton;
    private Library library = new Library("AIUB Library");

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(520, 620);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel[] labels = {
            new JLabel("ISBN:"), new JLabel("Title:"), new JLabel("Author:"),
            new JLabel("Price:"), new JLabel("Quantity:"), new JLabel("Genre/Standard:")
        };
        JTextField fields[] = {
            isbnField = new JTextField(), titleField = new JTextField(), authorField = new JTextField(),
            priceField = new JTextField(), qtyField = new JTextField(), extraField = new JTextField()
        };

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(30, 30 + i * 40, 140, 25);
            fields[i].setBounds(180, 30 + i * 40, 250, 25);
            add(labels[i]);
            add(fields[i]);
        }

        typeBox = new JComboBox<>(new String[] { "StoryBook", "TextBook" });
        typeBox.setBounds(30, 280, 180, 25);
        add(typeBox);

        addButton = new JButton("Add Book");
        addButton.setBounds(220, 280, 100, 25);
        addButton.addActionListener(this);
        add(addButton);

        showButton = new JButton("Show All Books");
        showButton.setBounds(330, 280, 150, 25);
        showButton.addActionListener(this);
        add(showButton);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 320, 420, 240);
        outputArea.setEditable(false);
        add(outputArea);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(qtyField.getText());
                String extra = extraField.getText();

                Book book;
                if (typeBox.getSelectedItem().equals("StoryBook")) {
                    book = new StoryBook(isbn, title, author, price, qty, extra);
                } else {
                    book = new TextBook(isbn, title, author, price, qty, extra);
                }

                library.addBook(book);

                // Save book details to file
                try (FileWriter writer = new FileWriter("books.txt", true)) {
                    writer.write(book.showDetails() + "\n");
                } catch (IOException ioe) {
                    outputArea.setText("Book added but failed to save in file.");
                    return;
                }

                outputArea.setText("Book added successfully.");
            } catch (Exception ex) {
                outputArea.setText("Invalid input. Please try again.");
            }
        } else if (e.getSource() == showButton) {
            outputArea.setText("");
            Book[] bookList = library.getBooks();
            for (int i = 0; i < bookList.length; i++) {
                outputArea.append(bookList[i].showDetails() + "\n");
            }
        }
    }
}
