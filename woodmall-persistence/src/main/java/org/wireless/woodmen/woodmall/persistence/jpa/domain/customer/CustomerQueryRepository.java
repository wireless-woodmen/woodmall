package org.wireless.woodmen.woodmall.persistence.jpa.domain.customer;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.wireless.woodmen.woodmall.domain.customer.port.CustomerQueryRepositoryPort;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CustomerQueryRepository implements CustomerQueryRepositoryPort {
    private final CustomerRepository customerRepository;
    private final JPAQueryFactory jpaQueryFactory;

    private static final QCustomer CUSTOMER = QCustomer.customer;
    
    @Override
    public org.wireless.woodmen.woodmall.domain.customer.Customer find(Long customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow()
            .toDomain();
    }

    public List<Customer> searchCustomer(String keyword) {
        return jpaQueryFactory.selectFrom(CUSTOMER)
            .where(this.likeName(keyword))
            .fetch();
    }

    private BooleanExpression likeName(String keyword) {
        if (StringUtils.hasText(keyword)) {
            return CUSTOMER.customerName.like(generateLikeKeyword(keyword));
        }
        return null;
    }

    private static String generateLikeKeyword(String keyword) {
        return "%" +keyword + "%";
    }
}
