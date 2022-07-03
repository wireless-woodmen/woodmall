package org.wireless.woodmen.woodmall.persistence.jpa.domain.customer;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CustomerQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private static final QCustomer CUSTOMER = QCustomer.customer;

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
