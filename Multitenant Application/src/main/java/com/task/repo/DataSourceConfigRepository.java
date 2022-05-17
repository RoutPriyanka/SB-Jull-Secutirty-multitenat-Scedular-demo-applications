package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.config.DataSourceConfig;


public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {

	DataSourceConfig findByName(String name);
}
