package com.priyanka.config;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;

import com.priyanka.repo.DataSourceRepository;

@SuppressWarnings("serial")
//@Component

public class TenanatDataSource implements Serializable {

	private HashMap<String, DataSource> dataSources = new HashMap<>();

	@Autowired
	private DataSourceRepository configRepo;

	public DataSource getDataSource(String name) {
		if (dataSources.get(name) != null) {
			return dataSources.get(name);
		}
		DataSource dataSource = createDataSource(name);
		if (dataSource != null) {
			dataSources.put(name, dataSource);
		}
		return dataSource;
	}

	@PostConstruct
	public Map<String, DataSource> getAll() {
		List<DataSourceConfig> configList = configRepo.findAll();
		Map<String, DataSource> result = new HashMap<>();
		for (DataSourceConfig config : configList) {
			DataSource dataSource = getDataSource(config.getUsername());
			result.put(config.getUsername(), dataSource);
		}
		return result;
	}

	private DataSource createDataSource(String name) {
		DataSourceConfig config = configRepo.findByusername(name);
		if (config != null) {
			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(config.getDriverClassName())
					.username(config.getUsername()).password(config.getPassword()).url(config.getUrl());
			DataSource ds = factory.build();
			return ds;
		}
		return null;

	}

}
