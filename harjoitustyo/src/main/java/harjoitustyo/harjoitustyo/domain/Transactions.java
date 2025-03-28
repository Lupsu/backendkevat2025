package harjoitustyo.harjoitustyo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "buy_price", nullable = false)
    private double buyPrice;

    @Column(name = "purchase_date", nullable = false)
    private String purchaseDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUsers user;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscriptions subscription;

    public Transactions() {
    }

    public Transactions(double buyPrice, String purchaseDate, AppUsers user, Subscriptions subscription) {
        this.buyPrice = buyPrice;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.subscription = subscription;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public AppUsers getUser() {
        return this.user;
    }

    public void setUser(AppUsers user) {
        this.user = user;
    }

    public Subscriptions getSubscription() {
        return this.subscription;
    }

    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", buyPrice='" + getBuyPrice() + "'" +
            ", purchaseDate='" + getPurchaseDate() + "'" +
            ", user='" + getUser() + "'" +
            ", subscription='" + getSubscription() + "'" +
            "}";
    }
    
}
