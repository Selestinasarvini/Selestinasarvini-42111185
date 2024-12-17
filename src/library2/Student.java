package library2;
import java.util.ArrayList;
import java.util.List;
public class Student
{
	    String studentId;
	    String name;
	    List<String> borrowedBooks;

	    public Student(String studentId, String name) {
	        this.studentId = studentId;
	        this.name = name;
	        this.borrowedBooks = new ArrayList<>();
	    }

	    public void displayStudent() {
	        System.out.println("ID: " + studentId + ", Name: " + name + ", Borrowed Books: " + borrowedBooks);
	    }
	}
