package org.wireless.woodmen.woodmall.persistence.jpa.domain.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wireless.woodmen.woodmall.domain.customer.port.CustomerRepositoryPort;
import org.wireless.woodmen.woodmall.domain.customer.port.model.request.CustomerAddRequest;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerService implements CustomerRepositoryPort {
    private final CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerAddRequest request) {
        customerRepository.save(Customer.from(request));
    }
}
