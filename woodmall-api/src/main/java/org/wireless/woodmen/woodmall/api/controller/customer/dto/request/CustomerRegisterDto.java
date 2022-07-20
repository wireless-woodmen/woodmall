package org.wireless.woodmen.woodmall.api.controller.customer.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.wireless.woodmen.woodmall.domain.customer.Customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CustomerRegisterDto {
    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String customerName;
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
    @Pattern(regexp = "^010(\\d{4}){2}$", message = "휴대전화번호 형식이 올바르지 않습니다.")
    @NotBlank(message = "휴대전화번호는 필수 입력값입니다.")
    private String phoneNumber;

    public Customer toDomain() {
        return new Customer(
            this.customerName,
            this.email,
            this.phoneNumber,
            this.password
        );
    }
    
    public static CustomerRegisterDto sample() {
        return new CustomerRegisterDto(
            "", "tester@test.com", "test", "01012345678"
        );
    }
}
