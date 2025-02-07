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
import backendkevat2025.bookstore.domain.CategoryRepository;





@Controller
public class BookController {
    @Autowired
	private BookRepository brepository;

    @Autowired
	private CategoryRepository crepository; 

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String goToIndex() {
        return "index";
    }

    @GetMapping("/booklist")
    public String goToBooklist(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @PostMapping("/savebook")
    public String save(Book book) {
        brepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", brepository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
}
