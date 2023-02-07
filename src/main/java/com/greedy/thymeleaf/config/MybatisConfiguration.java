package com.greedy.thymeleaf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.greedy.thymeleaf"})
public class MybatisConfiguration {
}
