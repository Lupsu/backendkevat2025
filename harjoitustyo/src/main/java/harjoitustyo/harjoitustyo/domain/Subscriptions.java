package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "subscription_name", nullable = false)
    private String subscriptionName;

    @Column(name = "subscription_description", nullable = false)
    private String subscriptionDescription;

    @Column(name = "subscription_erp_price", nullable = false)
    private double subscriptionErpPrice;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendors vendor;

    @JsonIgnoreProperties("subscription")
    @OneToMany(mappedBy = "subscription")
    private List<Transactions> transaction;

    public Subscriptions() {
    }

    public Subscriptions(String subscriptionName, String subscriptionDescription, double subscriptionErpPrice, Vendors vendor, List<Transactions> transaction) {
        this.subscriptionName = subscriptionName;
        this.subscriptionDescription = subscriptionDescription;
        this.subscriptionErpPrice = subscriptionErpPrice;
        this.vendor = vendor;
        this.transaction = transaction;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriptionName() {
        return this.subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getSubscriptionDescription() {
        return this.subscriptionDescription;
    }

    public void setSubscriptionDescription(String subscriptionDescription) {
        this.subscriptionDescription = subscriptionDescription;
    }

    public double getSubscriptionErpPrice() {
        return this.subscriptionErpPrice;
    }

    public void setSubscriptionErpPrice(double subscriptionErpPrice) {
        this.subscriptionErpPrice = subscriptionErpPrice;
    }

    public Vendors getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendors vendor) {
        this.vendor = vendor;
    }

    public List<Transactions> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", subscription_name='" + getSubscriptionName() + "'" +
            ", subscription_description='" + getSubscriptionDescription() + "'" +
            ", subscription_erp_price='" + getSubscriptionErpPrice() + "'" +
            ", vendor='" + getVendor() + "'" +
            "}";
    }
}
