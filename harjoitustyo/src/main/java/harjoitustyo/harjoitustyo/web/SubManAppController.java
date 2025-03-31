package harjoitustyo.harjoitustyo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.harjoitustyo.domain.AppUsers;
import harjoitustyo.harjoitustyo.domain.AppUsersRepository;
import harjoitustyo.harjoitustyo.domain.Subscriptions;
import harjoitustyo.harjoitustyo.domain.SubscriptionsRepository;
import harjoitustyo.harjoitustyo.domain.Transactions;
import harjoitustyo.harjoitustyo.domain.TransactionsRepository;
import harjoitustyo.harjoitustyo.domain.VendorsRepository;
import jakarta.validation.Valid;


@Controller
public class SubManAppController {
    
    @Autowired
    private AppUsersRepository appusersRepository;

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private VendorsRepository vendorsRepository;

    // Direct user to login page
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    // List subscriptions
    @GetMapping(value="/subscriptions")
    public String viewSubsriptions(Model model, Authentication authentication) {
        // Get role
        String roleName = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("UNKNOWN");
        model.addAttribute("roleName", roleName);
        model.addAttribute("subscriptions", subscriptionsRepository.findAll());
        return "subscriptions";
        }
    
    // Add subscription
    @GetMapping("/addsubscription")
    @PreAuthorize("hasRole('ADMIN')")
    public String addSubscription(Model model, Authentication authentication) {
        String roleName = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("UNKNOWN");
        model.addAttribute("roleName", roleName);
        model.addAttribute("subscription", new Subscriptions());
        model.addAttribute("vendors", vendorsRepository.findAll());
        return "addsubscription";
    }

    // Save subscription
    @PostMapping("/savesubscription")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveSubscription(@Valid @ModelAttribute("subscription") Subscriptions subscription, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vendors", vendorsRepository.findAll());
            return "addsubscription";
        }
        subscriptionsRepository.save(subscription);
        return "redirect:/subscriptions";
    }

    // Edit subscription
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editSubscription(@PathVariable("id") Long subscriptionId, Model model, Authentication authentication) {
        String roleName = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("UNKNOWN");
        model.addAttribute("roleName", roleName);
        model.addAttribute("subscription", subscriptionsRepository.findById(subscriptionId));
        model.addAttribute("vendors", vendorsRepository.findAll());
        return "editsubscription";
    }
    
    // Delete subscription
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSubscription(@PathVariable("id") Long subscriptionId, Model model, Authentication authentication) {
        subscriptionsRepository.deleteById(subscriptionId);
        return "redirect:../subscriptions";
    }

    // Add transaction or buy subscription
    @PostMapping("/addtransaction/{subscriptionId}")
    public String addTransaction(@PathVariable("subscriptionId") Long subscriptionId, Authentication authentication) {
    // Get current user
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    AppUsers currentUser = appusersRepository.findByUsername(userDetails.getUsername());

    // Get subscription
    Subscriptions subscription = subscriptionsRepository.findById(subscriptionId)
        .orElseThrow(() -> new IllegalArgumentException("Invalid subscription ID: " + subscriptionId));

    // Create transaction
    Transactions transaction = new Transactions();
    transaction.setUser(currentUser);
    transaction.setSubscription(subscription);
    transaction.setBuyPrice(subscription.getSubscriptionErpPrice());
    // Set format for date
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    // Convert date to string
    String formattedDate = dateFormat.format(new java.util.Date());
    transaction.setPurchaseDate(formattedDate);
    transactionsRepository.save(transaction);

    return "redirect:/subscriptions";
    }
    
    // List transactions
    @GetMapping(value="/transactions")
    public String viewTransactions(Model model, Authentication authentication) {
        String roleName = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("UNKNOWN");
        model.addAttribute("roleName", roleName);
        if ("ADMIN".equals(roleName)) {
            model.addAttribute("transactions", transactionsRepository.findAll());
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            AppUsers currentUser = appusersRepository.findByUsername(userDetails.getUsername());
            List<Transactions> transactions = transactionsRepository.findByUser(currentUser);
            model.addAttribute("transactions", transactions);
        }
        return "transactions";
    }
    }
