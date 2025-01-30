package backendkevat2025.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
}
