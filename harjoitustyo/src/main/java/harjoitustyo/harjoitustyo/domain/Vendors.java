package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @OneToMany(mappedBy = "vendor")
    private List<Subscriptions> subscriptions;

    public Vendors() {
    }

    public Vendors(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", vendor_name='" + getVendorName() + "'" +
            "}";
    }
}
