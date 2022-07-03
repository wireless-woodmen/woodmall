package org.wireless.woodmen.woodmall.persistence.jpa.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"org.wireless.woodmen.woodmall.persistence.jpa"})
@Configuration
public class JpaConfig {
}
