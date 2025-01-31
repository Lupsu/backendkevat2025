package backendkevat2025.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendkevat2025.bookstore.domain.Book;
import backendkevat2025.bookstore.domain.BookRepository;
import backendkevat2025.bookstore.domain.Category;
import backendkevat2025.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookSample(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			Category category1 = new Category("Fiktio");
			Category category2 = new Category("Fantasia");
			Category category3 = new Category("Lasten");
			
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			brepository.save(new Book("Sieppari ruispellossa", "Kai Kuikka", 1995, 1234568790, 19.90, category1));
			brepository.save(new Book("Harri Patteri virta loppuu", "Jaakko Kalevi Romula", 2000, 878654342, 39.90, category2));
			brepository.save(new Book("Kaislikossa kuhisee", "Pasi Punkki", 1984, 1234568111, 29.90, category3));
			};

		};
	}

