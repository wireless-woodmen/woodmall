package org.wireless.woodmen.woodmall.persistence.jpa.domain.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wireless.woodmen.woodmall.domain.customer.port.CustomerFindRepositoryPort;
import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerFindService implements CustomerFindRepositoryPort {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse find(Long customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow()
            .toResponse();
    }
}
