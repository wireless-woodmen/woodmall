package org.wireless.woodmen.woodmall.domain.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wireless.woodmen.woodmall.domain.customer.port.CustomerQueryRepositoryPort;
import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerQueryService {
	private final CustomerQueryRepositoryPort customerQueryRepositoryPort;
	
	public CustomerResponse find(Long customerId) {
		return customerQueryRepositoryPort.find(customerId).toResponse();
	}
}
