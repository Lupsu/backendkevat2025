package backendkevat2025.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backendkevat2025.bookstore.domain.Book;
import backendkevat2025.bookstore.domain.BookRepository;





@Controller
public class BookController {
    @Autowired
	private BookRepository repository; 

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String goToIndex() {
        return "index";
    }

    @GetMapping("/booklist")
    public String goToBooklist(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/savebook")
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
}
