// Abstract class (Abstraction)
abstract class LibraryItem {
    private String title;
    private String id;

    public LibraryItem(String _title, String _id) {
        title = _title;
        id = _id;
    }

    // Abstract method (fungsinya harus diimplementasikan oleh subclass)
    abstract void displayDetails();

    // Encapsulation
    public String getTitle() {
        return title;
    }

    // Encapsulation
    public void setTitle(String title) {
        this.title = title;
    }

    // Encapsulation
    public String getId() {
        return id;
    }

    // Encapsulation
    public void setId(String id) {
        this.id = id;
    }
}

// Inheritance (subclass Book mewairisi fitur superclass LibraryItem)
class Book extends LibraryItem {
    private String author;

    public Book(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    // Polymorphism
    @Override
    void displayDetails() {
        System.out.println("Book Title: " + getTitle() + ", ID: " + getId() + ", Author: " + author);
    }

    // Overloading
    public void displayDetails(String additionalInfo) {
        System.out.println("Book Title: " + getTitle() + ", ID: " + getId() + ", Author: " + author + ", Info: " + additionalInfo);
    }

    // Getter and Setter untuk 'author' (Encapsulation) 
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Inheritance (subclass Magazine mewairisi fitur superclass LibraryItem)
class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String id, int issueNumber) {
        super(title, id);
        this.issueNumber = issueNumber;
    }

    @Override
    void displayDetails() {
        System.out.println("Magazine Title: " + getTitle() + ", ID: " + getId() + ", Issue Number: " + issueNumber);
    }

    // Getter and Setter untuk 'issueNumber' (Encapsulation)
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int _issueNumber) {
        issueNumber = _issueNumber;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Contoh pembuatan Object
        LibraryItem book = new Book("Buku PBO", "B001", "Lionel Messi");
        LibraryItem magazine = new Magazine("Majalah PBO", "M001", 2024);

        // Contoh penggunaan Polymorphism
        book.displayDetails(); // Output: Book Title: Java Programming, ID: B001, Author: Lionel Messi
        magazine.displayDetails(); // Output: Magazine Title: Majalah PBO, ID: M001, Issue Number: 2024

        // Contoh pengunaan Overloading
        Book specificBook = (Book) book;
        specificBook.displayDetails("Buku untuk belajar PBO"); // Output: Book Title: Java Programming, ID: B001, Author: Lionel Messi, Info: Buku untuk belajar PBO

        // Contoh penggunaan Encapsulation
        System.out.println("Original Author: " + specificBook.getAuthor()); // Output: Original Author: Lionel Messi
        specificBook.setAuthor("Russell Westbrook");
        System.out.println("Updated Author: " + specificBook.getAuthor()); // Output: Updated Author: Russell Westbrook
    }
}
