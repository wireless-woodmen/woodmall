package org.wireless.woodmen.woodmall.api.controller.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.wireless.woodmen.woodmall.api.controller.customer.dto.request.CustomerRegisterDto;
import org.wireless.woodmen.woodmall.domain.customer.CustomerCommandService;
import org.wireless.woodmen.woodmall.domain.customer.CustomerQueryService;
import org.wireless.woodmen.woodmall.domain.customer.port.model.response.CustomerResponse;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Validated
@RequiredArgsConstructor
@RequestMapping(path = {"/api/v1/customers"})
@RestController
public class CustomerController {
    
    /**
     * command는 도메인의 상태를 변경할 수 있다.
     * command는 return을 하지 않는다.
     * **/
    private final CustomerCommandService customerCommandService;

    /**
     * query는 도메인의 상태를 변경하면 안된다.
     * query는 return을 한다.
     * **/
    private final CustomerQueryService customerQueryService;
    
    @PostMapping
    public void registerCustomer(@RequestBody @Valid CustomerRegisterDto request) {
        customerCommandService.registerCustomer(request.toDomain());
    }
    
    @GetMapping(path = {"/{customerId}"})
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable @PositiveOrZero Long customerId) {
        return ResponseEntity.ok(customerQueryService.find(customerId));
    }
}
