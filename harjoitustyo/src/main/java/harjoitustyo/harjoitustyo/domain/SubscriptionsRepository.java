package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Long> {
    Subscriptions findBySubscriptionName(String subscriptionName);
}
