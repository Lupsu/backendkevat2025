package backendkevat2025.bookstore.domain;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int isbn;
    private Double price;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String title, String author, int publicationYear, int isbn, Double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", publicationYear='" + getPublicationYear() + "'" +
            ", isbn='" + getIsbn() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
