package harjoitustyo.harjoitustyo.domain;

import org.springframework.data.repository.CrudRepository;

public interface VendorsRepository extends CrudRepository<Vendors, Long> {
    Vendors findByVendorName(String vendorName);
}
