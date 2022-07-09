package org.wireless.woodmen.woodmall.domain.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wireless.woodmen.woodmall.domain.customer.port.CustomerCommandRepositoryPort;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class CustomerCommandService {
    private final CustomerCommandRepositoryPort customerCommandRepositoryPort;

    public void registerCustomer(Customer customer) {
        customerCommandRepositoryPort.addCustomer(customer.toAddRequest());
    }
}
