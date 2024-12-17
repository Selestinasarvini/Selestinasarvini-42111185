package library2;

public class Book {
    String bookId;
    String title;
    String author;
    int copies;

    public Book(String bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public void displayBook() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Copies: " + copies);
    }
}


