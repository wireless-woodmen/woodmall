package org.wireless.woodmen.woodmall.domain.customer.port.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerAddRequest {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String password;
}
