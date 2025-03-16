package harjoitustyo.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.harjoitustyo.domain.AppUsers;
import harjoitustyo.harjoitustyo.domain.AppUsersRepository;
import harjoitustyo.harjoitustyo.domain.Roles;
import harjoitustyo.harjoitustyo.domain.RolesRepository;
import harjoitustyo.harjoitustyo.domain.SignupForm;
import jakarta.validation.Valid;

@Controller
public class AppUserController {
    @Autowired
    private AppUsersRepository appUsersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @RequestMapping(value = "signup")
    public String addUser(Model model) {
        model.addAttribute("signupform", new SignupForm());
        return "signup";
    }

    @PostMapping("saveuser")
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
                String pwd = signupForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashPassword = bc.encode(pwd);

                AppUsers newUser = new AppUsers();
                newUser.setUsername(signupForm.getUsername());
                newUser.setFirstName(signupForm.getFirstName());
                newUser.setLastName(signupForm.getLastName());
                newUser.setEmail(signupForm.getEmail());
                newUser.setPasswordhash(hashPassword);

                Roles role = rolesRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid role ID: 1"));
                newUser.setRole(role);

                if (appUsersRepository.findByUsername(signupForm.getUsername()) == null) {
                    appUsersRepository.save(newUser);
                } else {
                    bindingResult.rejectValue("username", "err.username", "Username already exists");
                    return "signup";
                }
            }
        }
        else {
            return "signup";
        }
        return "redirect:/login";
    }
    
}
