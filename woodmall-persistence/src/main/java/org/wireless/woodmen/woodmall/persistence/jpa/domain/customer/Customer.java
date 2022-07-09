package org.wireless.woodmen.woodmall.persistence.jpa.domain.customer;

import lombok.*;
import org.wireless.woodmen.woodmall.domain.customer.port.model.request.CustomerAddRequest;
import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String password;

    public static Customer from(CustomerAddRequest request) {
        return new Customer(
            null,
            request.getCustomerName(),
            request.getEmail(),
            request.getPhoneNumber(),
            request.getPassword()
        );
    }

    public CustomerResponse toResponse() {
        return new CustomerResponse(this.customerId,
            this.customerName,
            this.email,
            this.phoneNumber
        );
    }
}
