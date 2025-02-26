package backendkevat2025.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import backendkevat2025.bookstore.domain.Book;
import backendkevat2025.bookstore.domain.BookRepository;
import backendkevat2025.bookstore.domain.CategoryRepository;





@Controller
public class BookController {
    @Autowired
	private BookRepository brepository;

    @Autowired
	private CategoryRepository crepository; 

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }

    @GetMapping("/booklist")
    public String goToBooklist(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    @PreAuthorize("hasRole('ADMIN')")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @PostMapping("/savebook")
    @PreAuthorize("hasRole('ADMIN')")
    public String save(Book book) {
        brepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", brepository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
  
	// REST to get all books
    //@RequestMapping(value="/books", method = RequestMethod.GET)
    //public @ResponseBody List<Book> bookListRest() {	
    //    return (List<Book>) brepository.findAll();
    //}    
//
	// REST to get book by id
    //@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    //public @ResponseBody Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    //	return brepository.findById(bookId);
    //}
}
