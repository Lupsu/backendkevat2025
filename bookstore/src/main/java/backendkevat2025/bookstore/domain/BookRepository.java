package backendkevat2025.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    List<Book> findByCategoryName(String string);
}
