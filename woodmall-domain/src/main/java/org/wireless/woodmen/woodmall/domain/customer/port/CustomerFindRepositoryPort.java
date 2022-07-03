package org.wireless.woodmen.woodmall.domain.customer.port;


import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

public interface CustomerFindRepositoryPort {
    CustomerResponse find(Long customerId);
}
