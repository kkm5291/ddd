package org.example.domain_driven_dev;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository {

    Customer findById(String customerId);
}
