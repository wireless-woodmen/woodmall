package org.wireless.woodmen.woodmall.domain.customer.port;


import org.wireless.woodmen.woodmall.domain.customer.Customer;

public interface CustomerQueryRepositoryPort {
    Customer find(Long customerId);
}
