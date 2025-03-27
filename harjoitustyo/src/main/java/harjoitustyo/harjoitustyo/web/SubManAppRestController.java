package harjoitustyo.harjoitustyo.web;

import java.util.List;
import java.util.Optional;
import java.util.Collection;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import harjoitustyo.harjoitustyo.domain.AppUsersRepository;
import harjoitustyo.harjoitustyo.domain.Subscriptions;
import harjoitustyo.harjoitustyo.domain.SubscriptionsRepository;
import harjoitustyo.harjoitustyo.domain.TransactionsRepository;
import harjoitustyo.harjoitustyo.domain.VendorsRepository;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SubManAppRestController {
    private static final Logger logger = LoggerFactory.getLogger(SubManAppRestController.class);

    @Autowired
    private AppUsersRepository appusersRepository;

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private VendorsRepository vendorsRepository;

    @GetMapping("/rest/subscriptions")
    public Iterable<Subscriptions> getSubscriptions() {
        return subscriptionsRepository.findAll();
    }

    @GetMapping("/rest/subscriptions/{id}")
    Optional<Subscriptions> getSubscription(@PathVariable Long id) {
        return subscriptionsRepository.findById(id);
    }

    @PostMapping("/rest/subscriptions")
    Subscriptions newSubscription(@RequestBody Subscriptions newSubscription) {
        return subscriptionsRepository.save(newSubscription);
    }

    @PutMapping("/rest/subscriptions/{id}")
    Subscriptions editSubscription(@RequestBody Subscriptions editedSubscription, @PathVariable Long id) {
        editedSubscription.setId(id);
        return subscriptionsRepository.save(editedSubscription);
    }

    @DeleteMapping("/rest/subscriptions/{id}")
    public Iterable<Subscriptions> deleteSubscription(@PathVariable Long id) {
        subscriptionsRepository.deleteById(id);
        return subscriptionsRepository.findAll();
    }
}
