package harjoitustyo.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import harjoitustyo.harjoitustyo.domain.SubscriptionsRepository;
import harjoitustyo.harjoitustyo.domain.TransactionsRepository;

@Controller
public class SubManAppController {
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
    
}
