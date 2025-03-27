package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions, Long> {
    List<Transactions> findByUser(AppUsers user);
    Transactions findBySubscriptionId(Long subscriptionId);
}