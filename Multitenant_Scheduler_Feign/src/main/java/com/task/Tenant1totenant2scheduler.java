package com.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Tenant1totenant2scheduler {

	@Autowired
	SchedulerFeignServiceUtil schedulerFeignServiceUtil;

	@Scheduled(fixedRate = 600000)
	public void executeSyncProcess() {
		System.out.println("scheduler called");

		List<Employee> EmployeeList = schedulerFeignServiceUtil.getAll("tenant11");
		System.out.println("Employee size "+EmployeeList.size());
		if (EmployeeList != null && EmployeeList.size() > 0) {
			
			EmployeeList.stream().forEach(emp -> {
				System.out.println("Employee size "+emp.getName());
				schedulerFeignServiceUtil.save(emp,"tenant22");
			});
		}

	}
}
