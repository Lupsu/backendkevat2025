package backendkevat2025.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="publicationyear")
    private int publicationYear;
    @Column(name="isbn")
    private int isbn;
    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String title, String author, int publicationYear, int isbn, Double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    // Getters
    public Long getId() {
        return id;
    }

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

    public Category getCategory() {
        return category;
    }

    // Setters
    public void setId(Long id) {
		this.id = id;
	}

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

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + ", category=" + category + "]";
        } else {
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + "]";
        }
    }

    
}
