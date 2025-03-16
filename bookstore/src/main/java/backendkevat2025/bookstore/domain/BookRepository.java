package backendkevat2025.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN FETCH b.category")
    List<Book> findAllWithCategory();

    List<Book> findByCategoryName(String name);
}