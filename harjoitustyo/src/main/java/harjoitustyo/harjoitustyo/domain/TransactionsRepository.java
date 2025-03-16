package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Subscriptions, Long> {
    Transactions findByTransactionId(int id);
}