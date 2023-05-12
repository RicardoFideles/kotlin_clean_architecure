package br.com.rf.datasource.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["br.com.rf.datasource.entity"])
@EnableJpaRepositories(basePackages = ["br.com.rf.datasource.repositories"])
class DBConfig