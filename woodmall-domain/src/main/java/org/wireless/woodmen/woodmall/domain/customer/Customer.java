package org.wireless.woodmen.woodmall.domain.customer;

import lombok.*;
import org.wireless.woodmen.woodmall.domain.customer.port.model.request.CustomerAddRequest;
import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

@Getter
public class Customer {
	private Long customerId = null;
    private final String customerName;
    private final String email;
    private final String phoneNumber;
    private final String password;
	
	public Customer(String customerName, String email, String phoneNumber, String password) {
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public CustomerAddRequest toAddRequest() {
        return new CustomerAddRequest(
            this.getCustomerName(),
            this.getEmail(),
            this.getPhoneNumber(),
            this.getPassword()
        );
    }
	
	public CustomerResponse toResponse() {
		return new CustomerResponse(
			this.customerId,
			this.customerName,
			this.email,
			this.phoneNumber
		);
	}
}
