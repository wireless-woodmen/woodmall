package org.wireless.woodmen.woodmall.persistence.redis.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(basePackages = {"org.wireless.woodmen.woodmall.persistence.redis"})
@Configuration
public class RedisConfig {
}
