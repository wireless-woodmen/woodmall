package org.wireless.woodmen.woodmall.domain.customer.port.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerAddRequest {
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerPassword;
}
