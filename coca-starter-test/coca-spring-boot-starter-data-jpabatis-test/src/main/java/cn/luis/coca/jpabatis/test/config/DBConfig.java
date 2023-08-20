package cn.luis.coca.jpabatis.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @EntityScan(basePackages = "cn.luis.coca.jpabatis.test.domain")
@EnableJpaRepositories(basePackages = {"cn.luis.coca.jpabatis.test.dao.repository"})
// @MapperScan(basePackages = {"cn.luis.coca.jpabatis.test.dao.mapper"})
@Configuration
public class DBConfig {

}
