package backendkevat2025.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backendkevat2025.bookstore.domain.Book;
import backendkevat2025.bookstore.domain.BookRepository;
import backendkevat2025.bookstore.domain.CategoryRepository;

@RestController
public class BookRestController {
    @Autowired
	private BookRepository brepository;

    @Autowired
	private CategoryRepository crepository;

     @GetMapping("/books")
        public Iterable<Book> getBooks() {
        return brepository.findAll();
    }

    @PostMapping("books")
    Book newBook(@RequestBody Book newBook) {
        return brepository.save(newBook);
    }
    
    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return brepository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        brepository.deleteById(id);
        return brepository.findAll();
    }

    @GetMapping("/books/{id}")
    Optional<Book> getBook(@PathVariable Long id) {
        return brepository.findById(id);
    }

	@GetMapping("/books/category/{name}")
    List<Book> getBooksByCategory(@PathVariable String name) {
        return brepository.findByCategoryName(name);
    }
}
