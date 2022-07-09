package org.wireless.woodmen.woodmall.domain.customer;

import lombok.*;
import org.wireless.woodmen.woodmall.domain.customer.port.model.request.CustomerAddRequest;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String password;

    public CustomerAddRequest toAddRequest() {
        return new CustomerAddRequest(
            this.getCustomerName(),
            this.getEmail(),
            this.getPhoneNumber(),
            this.getPassword()
        );
    }
}
