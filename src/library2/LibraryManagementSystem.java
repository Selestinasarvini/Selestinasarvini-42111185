package library2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryManagementSystem
{
	List<Book> books = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook()
    {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = Integer.parseInt(scanner.nextLine());

        books.add(new Book(bookId, title, author, copies));
        System.out.println("Book added successfully!");
    }

    public void removeBook()
    {
        System.out.print("Enter Book ID to Remove: ");
        String bookId = scanner.nextLine();

        books.removeIf(book -> book.bookId.equals(bookId));
        System.out.println("Book removed successfully!");
    }

    public void viewBooks()
    {
        System.out.println("\nAvailable Books:");
        for (Book book : books)
        {
            book.displayBook();
        }
    }

    public void registerStudent()
    {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        students.add(new Student(studentId, name));
        System.out.println("Student registered successfully!");
    }

    public void removeStudent()
    {
        System.out.print("Enter Student ID to Remove: ");
        String studentId = scanner.nextLine();

        students.removeIf(student -> student.studentId.equals(studentId));
        System.out.println("Student removed successfully!");
    }

    public void viewStudents()
    {
        System.out.println("\nRegistered Students:");
        for (Student student : students)
        {
            student.displayStudent();
        }
    }

    public void issueBook()
    {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        Student student = findStudentById(studentId);
        Book book = findBookById(bookId);

        if (student != null && book != null && book.copies > 0)
        {
            student.borrowedBooks.add(bookId);
            book.copies--;
            System.out.println("Book issued successfully!");
        }
        else
        {
            System.out.println("Book issue failed. Check availability or student details.");
        }
    }

    public void returnBook()
    {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        Student student = findStudentById(studentId);
        Book book = findBookById(bookId);

        if (student != null && book != null && student.borrowedBooks.contains(bookId))
        {
            student.borrowedBooks.remove(bookId);
            book.copies++;
            System.out.println("Book returned successfully!");
        }
        else
        {
            System.out.println("Book return failed. Check details.");
        }
    }

    public void viewIssuedBooks()
    {
        System.out.println("\nIssued Books:");
        for (Student student : students)
        {
            if (!student.borrowedBooks.isEmpty())
            {
                System.out.println("Student: " + student.name + ", Borrowed Books: " + student.borrowedBooks);
            }
        }
    }

    private Book findBookById(String bookId)
    {
        for (Book book : books)
        {
            if (book.bookId.equals(bookId))
            {
                return book;
            }
        }
        return null;
    }

    private Student findStudentById(String studentId)
    {
        for (Student student : students)
        {
            if (student.studentId.equals(studentId))
            {
                return student;
            }
        }
        return null;
    }

    public void execute()
    {
        while (true)
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Register Student");
            System.out.println("5. Remove Student");
            System.out.println("6. View Students");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. View Issued Books");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice)
            {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> viewBooks();
                case 4 -> registerStudent();
                case 5 -> removeStudent();
                case 6 -> viewStudents();
                case 7 -> issueBook();
                case 8 -> returnBook();
                case 9 -> viewIssuedBooks();
                case 0 ->
                {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}