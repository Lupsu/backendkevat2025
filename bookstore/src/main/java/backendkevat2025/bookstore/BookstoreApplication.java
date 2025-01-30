package backendkevat2025.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendkevat2025.bookstore.domain.Book;
import backendkevat2025.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookSample(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Sieppari ruispellossa", "Kai Kuikka", 1995, 1234568790, 19.90));
			repository.save(new Book("Harri Patteri virta loppuu", "Jaakko Kalevi Romula", 2000, 878654342, 39.90));
			repository.save(new Book("Kaislikossa kuhisee", "Pasi Punkki", 1984, 1234568111, 29.90));
			};

		};
	}

