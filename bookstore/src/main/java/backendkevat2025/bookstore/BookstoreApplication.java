package backendkevat2025.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	/*
	 * 
	
	@Bean
	public CommandLineRunner bookstoreSampleData(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository) {
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
			
			AppUser user1 = new AppUser("user", "$2a$10$hGFMQXO94avNHXLq4DqVYeg6GbRAi4DEBzrLxfrbmhkS2gTtZ0Zka", "jani@hassu.fi", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$o3aY6TFAFJal/ueZNL91POgOVdSTH1a/.RLS6fqmXUk1gbeaLqanG", "admin@hassu.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};

		};
		 */
	}

