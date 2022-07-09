package org.wireless.woodmen.woodmall.api.controller.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wireless.woodmen.woodmall.api.controller.customer.dto.request.CustomerRegisterDto;
import org.wireless.woodmen.woodmall.domain.customer.CustomerCommandService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping(path = {"/api/v1/customers"})
@RestController
public class CustomerCommandController {
    private final CustomerCommandService customerCommandService;

    @PostMapping
    public void registerCustomer(@RequestBody @Valid CustomerRegisterDto request) {
        customerCommandService.registerCustomer(request.toDomain());
    }
}
