package backendkevat2025.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backendkevat2025.bookstore.web.BookController;
import backendkevat2025.bookstore.web.BookRestController;
import backendkevat2025.bookstore.web.UserController;
import backendkevat2025.bookstore.web.UserDetailServiceImpl;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bController;
	private BookRestController bRestController;
	private UserController uController;
	private UserDetailServiceImpl uDetailServiceController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bController).isNotNull();
		assertThat(bRestController).isNotNull();
		assertThat(uController).isNotNull();
		assertThat(uDetailServiceController).isNotNull();
	}

}

