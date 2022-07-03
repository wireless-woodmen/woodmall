package org.wireless.woodmen.woodmall.domain.customer.port.model.response;

public record CustomerResponse(Long customerId, String customerName, String email, String phoneNumber) {
}
