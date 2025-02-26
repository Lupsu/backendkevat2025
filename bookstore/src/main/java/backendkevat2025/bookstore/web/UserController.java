package backendkevat2025.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import backendkevat2025.bookstore.domain.AppUser;
import backendkevat2025.bookstore.domain.AppUserRepository;
import backendkevat2025.bookstore.domain.SignupForm;
import jakarta.validation.Valid;



@Controller
public class UserController {
    @Autowired
    private AppUserRepository repository;

    @RequestMapping(value = "signup")
    public String addUser(Model model) {
        model.addAttribute("signupform", new SignupForm());
        return "signup";
    }
    
    @PostMapping("saveuser")
    public String save(@Valid @ModelAttribute("signupform") SignupForm signUpForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) {
                String pwd = signUpForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashPassword = bc.encode(pwd);

                AppUser newUser = new AppUser();
                newUser.setPasswordHash(hashPassword);
                newUser.setUsername(signUpForm.getUsername());
                newUser.setEmail(signUpForm.getEmail());
                newUser.setRole("USER");
                if (repository.findByUsername(signUpForm.getUsername()) == null) {
                    repository.save(newUser);
                } else {
                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "signup";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "err.passwordCheck", "Passwords does not match");
                return "signup";
            }
        } else {
            return "signup";
        }
        return "redirect:/login";
    }
}
