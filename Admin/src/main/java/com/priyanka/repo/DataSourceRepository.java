package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.priyanka.config.DataSourceConfig;

@Repository
@Component

public interface DataSourceRepository extends JpaRepository<DataSourceConfig, String> {
	DataSourceConfig findByusername(String username);
}
