package org.wireless.woodmen.woodmall.domain.customer.port;

import org.wireless.woodmen.woodmall.domain.customer.port.model.request.CustomerAddRequest;

public interface CustomerRepositoryPort {

    void addCustomer(CustomerAddRequest request);
}
